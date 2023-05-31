package multichat_answer;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class SendThread2 extends Thread {
	DataOutputStream out;

	public SendThread2() {
		// TODO Auto-generated constructor stub
	}

	public SendThread2(OutputStream os) {
		out = new DataOutputStream(os);
	}

	@Override
	public void run() {
		Protocol protocol = null;
		System.out.println("�����޽����� �Է��ϸ� �˴ϴ�.(����:logout)");
		while (true) {
			try {
				String msg = new Scanner(System.in).nextLine();
				if (msg.equals("logout")) {
					protocol = new Protocol(Protocol.PT_LOGOUT);
				} else {
					protocol = new Protocol(Protocol.PT_CHAT);
					System.arraycopy(msg.getBytes(), 0, protocol.getPacket(), 1, msg.length());// ��Ŷ�� ���̵� �Է�
				}
				out.write(protocol.getPacket());
				out.flush();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
