package ex230421;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginServer {
	static final int LOGIN=1;
	static final int LOGOUT=2;
	static final int MSG_SEND=3;
	static final int MSG_RECV=4;
	
	public static void main(String[] args) {
		/*
		 서버와 클라이언트간에는 바이트 스트림이 전송되고 있는 상황
		 만약 바이트의 연속적인 흐름이 규칙을 정하지 않으면 무엇인지 알수 없다.
		 규칙이라는 것이 프로토콜
		 
		 서버에서 할 수 있는 사항들
		 로그인(아이디, 패스워드를 입력받아 인증요청)
		 로그아웃(요청된 인증을 해제)
		 메시지 송신(보내는것)
		 메시지 수신(받는 것)
		 
		 프로토콜 만들기
		 인증요청 : 1 - 필요한 사항 (id(10), password(10))
		 로그아웃 : 2 - 로그아웃 성공하는 21, 실패하면 20
		 메시지 송신 : 3 - 메시지 길이는 무한이라고 가정함
		 메시지 수신 : 4
		 */
		
		try {
			ServerSocket server=new ServerSocket(9999);
			System.out.println("접속대기중.....");
			Socket client=server.accept();
			System.out.println("클라이언접속...서버실행중");
			DataOutputStream out
			=new DataOutputStream(client.getOutputStream());
			DataInputStream in
			=new DataInputStream(client.getInputStream());
			//System.out.println(in.readUTF());
			while(true) {
			String data=in.readUTF();
			System.out.println(data);
			System.out.println(Integer.parseInt(data.substring(0,1)));
			int code=Integer.parseInt(data.substring(0,1));
			//System.out.println(data.substring(1,(1+10)).trim());
			//String code=data.substring(0,1);
			//String id=data.substring(1,(1+10));
			//String password=data.substring(12,(12+10));
			//System.out.println(code);
			//System.out.println(id);
			//System.out.println(password);
			/*
			switch(code) {
			case 1: System.out.println("로그인 인증"); break;
			case 2: System.out.println("로그아웃"); break;
			case 3: System.out.println("메시지 송신"); break;
			case 4: System.out.println("메시지 수신"); break;
			default : System.out.println("데이터폐기"); break;
			}
			*/
			switch(code) {
			case LOGIN: 
				//System.out.println("로그인 인증");
				//아이디, 패스워드 분리 후 확인
				//메시지를 보내서 성공여부 확인
				String id=data.substring(1,(1+10)).trim();
				String password=data.substring(11,(11+10)).trim();
				if(id.equals("admin") && password.equals("1234")) {
					System.out.println("로그인 성공 전송");
				}else {
					System.out.println("로그인 실패 전송");
				}
				break;
			
			case LOGOUT: 
				//System.out.println("로그아웃");
				//로그아웃할 아이디를 분리하고
				//해당하는 아이디가 있을 경우 로그아웃 성공여부 확인 메시지 전송
				break;
			
			case MSG_SEND: 
				//System.out.println("메시지 송신"); 
				break;
			
			case MSG_RECV: 
				//System.out.println("메시지 수신");
				//메시지 부분을 분리하여 메시지만 처리
				break;
			
			default : 
				System.out.println("데이터폐기"); 
				break;
			}
			
			}
			//client.close();
			//server.close();
			}catch(Exception e) {}

	}

}
