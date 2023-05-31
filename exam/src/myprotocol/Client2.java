package myprotocol;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
	public static void main(String[] args) {
		
		try {
			Socket socket=new Socket("192.168.0.10",9999);
			if(socket.isConnected()) System.out.println("클라이언시작");
			
			InputStream is = socket.getInputStream();
			OutputStream out=socket.getOutputStream();
			
			while(true) {
			//서버에서 전송된 데이터를 프로토콜객체의 packet을 이용
			Protocol protocol = new Protocol();//장바구니역할
			is.read(protocol.getPacket());
			//데이터를 가지오는 역할도 하지만 주소를 반환하는 역할을 하므로 
			//해당 위치에 전송된 데이터를 pakcet에 저장할 수 있음.
			//System.out.println(protocol.getPacket()[0]); //확인작업
			protocol.setProtocolType(protocol.getPacket()[0]);
			System.out.println(protocol.getProtocolType());
			
			switch(protocol.getProtocolType()) {
			//case Protocol.PT_EXIT : System.out.println("로그인종료");break;
			case Protocol.PT_REQ_LOGIN : 
				System.out.println("로그인요청받음");
				//로그인시도(필요한 사항:아이디, 패스워드를 입력하여 요청)
				//보내야하는 사항이므로 프로토콜을 만드는 작업진행
				protocol=new Protocol(Protocol.PT_RES_LOGIN);
				System.out.println("아이디를 입력하세요.");
				String id=new Scanner(System.in).nextLine();
				System.out.println("패스워드를 입력하세요.");
				String password=new Scanner(System.in).nextLine();
				System.arraycopy(id.getBytes(), 0, protocol.getPacket(), 1, id.length());//패킷에 아이디 입력
				System.arraycopy(password.getBytes(), 0, protocol.getPacket(), 10, password.length());//패킷에 비밀번호 입력
				out.write(protocol.getPacket());//packet에 저장된 데이터를 전송
				out.flush();
				break;
			case Protocol.PT_LOGIN_RESULT :
				if(protocol.getPacket()[1]==Protocol.PT_LOGIN_RESULT_SUCESS) {
				System.out.println("로그인성공");
				}else {
				System.out.println("로그인실패");
				}
				break;
			}
			}//while end	 
			
		
			
		}catch(Exception e) {}
		

	}

}
