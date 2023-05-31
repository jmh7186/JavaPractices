package test230502;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

class SendThread extends Thread {
	Socket socket;

	public SendThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			while (true) {
				OutputStream os = socket.getOutputStream();
				Protocol pr = new Protocol(Protocol.PT_CHAT);
				String msg = new Scanner(System.in).nextLine();
				System.arraycopy(msg.getBytes(), 0, pr.getPacket(), 1, msg.getBytes().length);
				os.write(pr.getPacket());
				os.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class RecvThread extends Thread {
	Socket socket;

	public RecvThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			InputStream is = socket.getInputStream();
			while (true) {
				Protocol pr = new Protocol();
				is.read(pr.getPacket());
				String msg = socket.getInetAddress().getHostAddress() + " : "
						+ new String(pr.getPacket(), 1, 1023).trim();
				System.out.println(msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

public class ServerMain {

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(9999);
			System.out.println("서버 실행, 접속 대기 중...");
			new LogWriter().logServer();
			Socket client = server.accept();
			System.out.println("클라이언트 접속 : " + client.getInetAddress().getHostAddress());
			OutputStream os = client.getOutputStream();
			InputStream is = client.getInputStream();
			Protocol pr = new Protocol(Protocol.PT_LOGIN_REQ);
			os.write(pr.getPacket());
			os.flush();

			boolean login = false;
			while (!(login)) {
				pr = new Protocol();
				is.read(pr.getPacket());

				switch (pr.getProtocolType()) {
				case Protocol.PT_LOGIN_RES:
					if (pr.getId().equals("admin") && pr.getPassword().equals("1234")) {
						System.out.println(client.getInetAddress().getHostAddress() + "- 로그인 성공");
						login = true;
						pr = new Protocol(Protocol.PT_RESULT_LOGIN);
						pr.getPacket()[1] = Protocol.PT_LOGIN_SUCCESS;
						os.write(pr.getPacket());
						os.flush();

						new SendThread(client).start();
						new RecvThread(client).start();

						break;
					} else {
						System.out.println(client.getInetAddress().getHostAddress() + "- 로그인 실패");
						pr = new Protocol(Protocol.PT_RESULT_LOGIN);
						pr.getPacket()[1] = Protocol.PT_LOGIN_FAIL;
						os.write(pr.getPacket());
						os.flush();

						pr = new Protocol(Protocol.PT_LOGIN_REQ);
						os.write(pr.getPacket());
						os.flush();
						break;
					}
//				case Protocol.PT_CHAT:
//					new SendThread(client).start();
//					new RecvThread(client).start();
//					break;

				}

			} // while(!(login)) end

		} catch (Exception e) {

		}
	}

}
