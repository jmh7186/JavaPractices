package multichat;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

class SendThread extends Thread {
	Socket[] msgRecvClient;

	public SendThread(Socket[] msgRecvClient) {
		this.msgRecvClient = msgRecvClient;
	}

	@Override
	public void run() {
		try {
			while (true) {
				byte[] msgbuf = new byte[1024];
				String msg = "서버 : " +new Scanner(System.in).nextLine();
				System.out.println(msg);
				for (int i = 0; i < 100; i++) {
					try {
						OutputStream os = msgRecvClient[i].getOutputStream();
						System.arraycopy(msg.getBytes(), 0, msgbuf, 0, msg.getBytes().length);
						os.write(msgbuf);
						os.flush();
					} catch (Exception e2) {
					}
				}
			}
		} catch (Exception e1) {
		}
	}
}

class RecvThread extends Thread {
	Socket msgOwnSocket;
	Socket[] msgRecvClient;

	public RecvThread(Socket msgOwnSocket, Socket[] msgRecvClient) {
		this.msgOwnSocket = msgOwnSocket;
		this.msgRecvClient = msgRecvClient;
	}

	@Override
	public void run() {
		try {
			InputStream is = msgOwnSocket.getInputStream();
			while (true) {
				byte[] msgbuf = new byte[1024];
				is.read(msgbuf);
				String msg = msgOwnSocket.getInetAddress().getHostAddress() + " : " + new String(msgbuf).trim();
				System.out.println(msg);
				for (int i = 0; i < 100; i++) {
					try {
						OutputStream os = msgRecvClient[i].getOutputStream();
						System.arraycopy(msg.getBytes(), 0, msgbuf, 0, msg.getBytes().length);
						os.write(msgbuf);
						os.flush();
					} catch (Exception e2) {
					}
				}
			}
		} catch (Exception e1) {
		}
	}
}

public class Server {

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(9999);
			Socket[] client = new Socket[100];
			int index = 0;
			// 클라이언트 소켓 수 (클라이언트가 100회 이상 접속 시 오류가 발생)
			// 생성된 소켓이 닫히면(클라이언트가 연결이 끊기면) 이를 인지하여 소켓을 제거해야 함
			while (true) {
				if (index < 100) {
					client[index++] = server.accept();
					System.out.println("접속자 수: " + index);
					// 송수신 스레드 생성
					// 메시지를 수신하는 스레드를 소켓별로 만들고 전체소켓(클라이언트들)의 정보를 스레드로 넘겨서 전체소켓에 메시지를 뿌려줘야 함
					new RecvThread(client[index - 1], client).start();
					new SendThread(client).start();
				}

			}

		} catch (Exception e) {

		}
	}

}
