package multichat_answer;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server6 {

	public static void main(String[] args) {
		boolean state = true;
		SendThread2 t1 = null;
		try {
			// �������۽ð� ���
			new LogWriter().logServer();
			///////////////
			System.out.println("�������� ");

			ServerSocket server = new ServerSocket(9999);
			while (true) {
				Socket client = server.accept();
				// Ŭ���̾�Ʈ���ӽð����
				new LogWriter().logClient();
				///////////////////

				if (client.isConnected()) {
					System.out.println("Ŭ���̾�Ʈ ����");
				}

				InputStream in = client.getInputStream();
				OutputStream out = client.getOutputStream();

				Protocol protocol = new Protocol(Protocol.PT_REQ_LOGIN);
				out.write(protocol.getPacket());
				out.flush();
				state = true;

				while (state) {
					protocol = new Protocol();
					in.read(protocol.getPacket());

					protocol.setProtocolType(protocol.getPacket()[0]);

					switch (protocol.getProtocolType()) {
					case Protocol.PT_RES_LOGIN:
						System.out.println("�α���Ȯ��");
						String id = protocol.getId();
						String password = protocol.getPassword();
						System.out.println("id:" + id);
						System.out.println("pass:" + password);
						if (id.equals("admin") && password.equals("1234")) {
							System.out.println("�α��μ�����������");
							protocol = new Protocol(Protocol.PT_LOGIN_RESULT);
							// protocol.getPacket()[1]=31;
							out.write(protocol.getPacket());
							out.flush();
							System.out.println("�ݺ��� �������ͼ� ");
							System.out.println("�ۼ��� ������ ����");
							// new RecvThread2(client.getInputStream()).start();
							t1 = new SendThread2(client.getOutputStream());
							t1.start();
							// state=false;

						} else {
							System.out.println("�α��ν��к�������");
							protocol = new Protocol(Protocol.PT_REQ_LOGIN);
							// protocol.getPacket()[1]=30;
							out.write(protocol.getPacket());
							out.flush();
						}
						break;
					case Protocol.PT_CHAT:
						System.out.println("�����޽���:" + protocol.getMessage());
						break;
					case Protocol.PT_LOGOUT:
						System.out.println("���α׷��� �����մϴ�.");
						state = false;
						t1.stop();
						protocol = new Protocol(Protocol.PT_LOGOUT);
						out.write(protocol.getPacket());
						out.flush();
						break;
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
