package myprotocol;

import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class Server1 {

	public static void main(String[] args) {
		try {
			System.out.println("서버실행 ");

			ServerSocket server=new ServerSocket(9999);
			Socket client=server.accept();
			if(client.isConnected()) {
				System.out.println("클라이언트 접속");
			}
			InputStream in=client.getInputStream();
			OutputStream out=client.getOutputStream();
			
			//로그인시도하세요. 프로토콜 작성, 데이터 전송
			Protocol protocol=new Protocol(Protocol.PT_REQ_LOGIN);
			//Protocol protocol=new Protocol(100);
			//보낼데이터는 별도로 없으므로 프로토콜이 완성된 것임.
			//프로토콜을 전송하면 됨.
			//OutputStream out=client.getOutputStream();
			out.write(protocol.getPacket());
			out.flush();
			
			//로그인요청을 받아서 처리(데이터 확인)
			//InputStream in=client.getInputStream();
			protocol=new Protocol();
			in.read(protocol.getPacket());
			String id=protocol.getId();
			String password=protocol.getPassword();
			System.out.println("id:"+id);
			System.out.println("pass:"+password);
			if(id.equals("admin") && password.equals("1234")) {
				//로그인성공(성공메시지보내기)-추가메시지 31(LOGIN_SUCESS)
				System.out.println("로그인성공");
				//out=client.getOutputStream();
				protocol=new Protocol(Protocol.PT_LOGIN_RESULT);
				//packet[1]=31
				protocol.getPacket()[1]=31;
				//System.arraycopy
				//("31".getBytes(), 0, protocol.getPacket(), 1, "31".length());
				out.write(protocol.getPacket());
				out.flush();
				
			}else {
				//로그인실패(실패메시지보내기)-추가메시지 30(LOGIN_FAIL)
				System.out.println("로그인실패");
				//out=client.getOutputStream();
				protocol=new Protocol(Protocol.PT_LOGIN_RESULT);
				//packet[1]=30
				protocol.getPacket()[1]=30;
				//System.arraycopy
				//("30".getBytes(), 0, protocol.getPacket(), 1, "30".length());
				out.write(protocol.getPacket());
				out.flush();
			}
			
			//챗팅내용수신하여 화면에 표시하기(빈 프로토콜 생성-데이터 읽기-데이터처리)
			protocol=new Protocol();
			in.read(protocol.getPacket());
			String msg=protocol.getMessage();
			System.out.println(msg);
			
		}catch(Exception e) {e.printStackTrace();}

	}
 
}
