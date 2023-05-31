package test230502;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain1 {

	public static void main(String[] args) {
		try {
			System.out.println("Ŭ���̾�Ʈ ����, ���� ��� ��...");
			Socket server = new Socket("127.0.0.1", 9999);
			if (server.isConnected()) {
				System.out.println("���� ���� : " + server.getInetAddress().getHostAddress());
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
					System.out.println("�α��� ��û ����");
					System.out.print("���̵� �Է� : ");
					String id = new Scanner(System.in).nextLine();
					System.out.print("��й�ȣ �Է� : ");
					String password = new Scanner(System.in).nextLine();
					pr = new Protocol(Protocol.PT_LOGIN_RES);
					System.arraycopy(id.getBytes(), 0, pr.getPacket(), 1, id.getBytes().length);
					System.arraycopy(password.getBytes(), 0, pr.getPacket(), 11, password.getBytes().length);
					os.write(pr.getPacket());
					os.flush();
					break;
				case Protocol.PT_RESULT_LOGIN:
					if (pr.getPacket()[1] == Protocol.PT_LOGIN_SUCCESS) {
						System.out.println("�α��� ����");
						login = true;
						new RecvThread(server).start();
						new SendThread(server).start();
					} else if (pr.getPacket()[1] == Protocol.PT_LOGIN_FAIL) {
						System.out.println("�α��� ����");
					} else {
						System.out.println("��� ����");
					}
					break;
					
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}