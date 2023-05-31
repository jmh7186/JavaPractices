package multichat;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

class RecvThreadforC extends Thread {
	InputStream server;

	public RecvThreadforC(InputStream server) {
		this.server = server;
	}

	@Override
	public void run() {
		while (true) {
			byte[] msgbuf = new byte[1024];
			try {
				server.read(msgbuf);
				String msg = new String(msgbuf).trim();
				System.out.println(msg);
			} catch (Exception e1) {
			}
		}
	}
}

public class Client {

	public static void main(String[] args) {
		try {
			Socket server = new Socket("192.168.0.30", 9999);
			OutputStream os = server.getOutputStream();
			new RecvThreadforC(server.getInputStream()).start();
			while (true) {
				byte[] msgbuf = new byte[1024];
				String msg = new Scanner(System.in).nextLine();
				System.arraycopy(msg.getBytes(), 0, msgbuf, 0, msg.getBytes().length);
				os.write(msgbuf);
				os.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}