package multichat_answer;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

public class Client6 {
	public static void main(String[] args) {
		
		try {
			Socket socket=new Socket("192.168.0.10",9999);
			if(socket.isConnected()) System.out.println("클라이언시작");
			
			InputStream is = socket.getInputStream();
			OutputStream out=socket.getOutputStream();
			boolean state=true;
			while(state) {
			Protocol protocol = new Protocol();
			is.read(protocol.getPacket());
			
			protocol.setProtocolType(protocol.getPacket()[0]);
			
			switch(protocol.getProtocolType()) {
			case Protocol.PT_REQ_LOGIN : 
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
					System.out.println("로그인성공/챗팅쓰레드 생성");
					//new RecvThread2(socket.getInputStream()).start();
					new SendThread2(socket.getOutputStream()).start();
					//state=false;
					break;
			case Protocol.PT_CHAT :
				System.out.println("받은메시지:"+protocol.getMessage());
					break;
			case Protocol.PT_LOGOUT :
				System.out.println("클라이언트 프로그램을 종료합니다.");System.exit(0);
					break;
			}
		 			
			}//while end
		}catch(Exception e) {}
		

	}

}
