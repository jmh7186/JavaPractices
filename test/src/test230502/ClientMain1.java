package test230502;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain1 {

	public static void main(String[] args) {
		try {
			System.out.println("클라이언트 실행, 접속 대기 중...");
			Socket server = new Socket("127.0.0.1", 9999);
			if (server.isConnected()) {
				System.out.println("서버 접속 : " + server.getInetAddress().getHostAddress());
				new LogWriter().logClient();
			}

			Protocol pr = new Protocol();
			OutputStream os = server.getOutputStream();
			InputStream is = server.getInputStream();
			
			boolean login = false;
			while (!(login)) {
				pr = new Protocol();
				is.read(pr.getPacket());
				
				switch (pr.getProtocolType()) {
				case Protocol.PT_LOGIN_REQ:
					System.out.println("로그인 요청 도착");
					System.out.print("아이디 입력 : ");
					String id = new Scanner(System.in).nextLine();
					System.out.print("비밀번호 입력 : ");
					String password = new Scanner(System.in).nextLine();
					pr = new Protocol(Protocol.PT_LOGIN_RES);
					System.arraycopy(id.getBytes(), 0, pr.getPacket(), 1, id.getBytes().length);
					System.arraycopy(password.getBytes(), 0, pr.getPacket(), 11, password.getBytes().length);
					os.write(pr.getPacket());
					os.flush();
					break;
				case Protocol.PT_RESULT_LOGIN:
					if (pr.getPacket()[1] == Protocol.PT_LOGIN_SUCCESS) {
						System.out.println("로그인 성공");
						login = true;
						new RecvThread(server).start();
						new SendThread(server).start();
					} else if (pr.getPacket()[1] == Protocol.PT_LOGIN_FAIL) {
						System.out.println("로그인 실패");
					} else {
						System.out.println("결과 오류");
					}
					break;
					
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}