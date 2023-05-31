package time;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

class Send extends Thread {
	OutputStream os;

	public Send(OutputStream os) {
		this.os = os;
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				byte[] timebuf = new byte[1024];
				String time = new Date().toString();
				System.arraycopy(time.getBytes(), 0, timebuf, 0, time.getBytes().length);
				os.write(timebuf);
				sleep(1000);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}

public class Server {

	public static void main(String[] args) {
		byte[] buf;
		boolean login = false;
		try {
			ServerSocket sSocket = new ServerSocket(9999);
			new LogWriter().logServer();
			System.out.println("���α׷� ����, ���� ��� ��...");
			Socket client = sSocket.accept();
			System.out.println("Ŭ���̾�Ʈ ����: " + client.getInetAddress().getHostAddress());
			new LogWriter().logClient();

			InputStream is = client.getInputStream();
			OutputStream os = client.getOutputStream();

			while (!(login)) {
				buf = new byte[21];
				is.read(buf);

				String id = new String(buf, 1, 10).trim();
				String password = new String(buf, 11, 10).trim();

				switch (buf[0]) {
				case 1:
					buf = new byte[2];
					if (id.equals("admin") && password.equals("1234")) {
						System.out.println("�α��� ����");
						buf[0] = 2;
						buf[1] = 1;
						os.write(buf);
						os.flush();
						new Send(client.getOutputStream()).start();
						login = true;
					} else {
						System.out.println("�α��� ����");
						buf[0] = 2;
						buf[1] = 0;
						os.write(buf);
						os.flush();
					}
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
