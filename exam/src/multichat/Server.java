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
				String msg = "���� : " +new Scanner(System.in).nextLine();
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
			// Ŭ���̾�Ʈ ���� �� (Ŭ���̾�Ʈ�� 100ȸ �̻� ���� �� ������ �߻�)
			// ������ ������ ������(Ŭ���̾�Ʈ�� ������ �����) �̸� �����Ͽ� ������ �����ؾ� ��
			while (true) {
				if (index < 100) {
					client[index++] = server.accept();
					System.out.println("������ ��: " + index);
					// �ۼ��� ������ ����
					// �޽����� �����ϴ� �����带 ���Ϻ��� ����� ��ü����(Ŭ���̾�Ʈ��)�� ������ ������� �Ѱܼ� ��ü���Ͽ� �޽����� �ѷ���� ��
					new RecvThread(client[index - 1], client).start();
					new SendThread(client).start();
				}

			}

		} catch (Exception e) {

		}
	}

}
