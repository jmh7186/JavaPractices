package ex230427;

import java.awt.AWTException;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class RecvThread extends Thread {
	Socket socket;
	Button btn;

	public RecvThread(Socket socket, Button btn) {
		this.socket = socket;
		this.btn = btn;
	}

	@Override
	public void run() {
		byte[] cdata = new byte[1];
		while (true) {
			try {
				socket.getInputStream().read(cdata);
			} catch (Exception e) {
				try {
					socket.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			if (cdata[0] == 2) {
				// 출근함
				btn.setBackground(Color.green);
			} else {
				btn.setBackground(Color.orange);
			}
		}
	}
}

public class Server4 {

	public static void main(String[] args) throws IOException, AWTException {
		System.out.println("서버 실행");
		ServerSocket server = new ServerSocket(9999);
		Frame f = new Frame("출결관리 서버");
		Button[] btn = new Button[4];
		f.setBounds(1200, 100, 600, 200);
		f.setLayout(new FlowLayout());
		for (int i = 0; i < btn.length; i++) {
			btn[i] = new Button("Computer: " + (i + 1));
			btn[i].setBackground(Color.orange);
			f.add(btn[i]);
		}
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		String[] ips = { "192.168.0.2", "192.168.0.30", "192.168.0.52", "192.168.0.82" };
		System.out.println("접속 대기 중...");
		Socket[] client = new Socket[4];
		int i = 0;
		while (true) {
			if (i < 4) {
				client[i] = server.accept();
				String ip = client[i].getInetAddress().getHostAddress();
				System.out.println("클라이언트 접속: " + ip);
				for (int index = 0; index < ips.length; index++) {
					if (ips[index].equals(ip)) {
						new RecvThread(client[i], btn[index]).start();
						i++;
						break;
					}
				}
			}
		}

	}

}
