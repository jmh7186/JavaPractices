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

public class Server3 {

	public static void main(String[] args) throws IOException, AWTException {
		ServerSocket server = new ServerSocket(9999);
		System.out.println("���� ����");
		Frame f = new Frame("������ ����");
		Button[] btn = new Button[24];
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

		System.out.println("���� ��� ��...");
		Socket client = server.accept();
		if (!client.isConnected()) {
			System.exit(0);
		}
		String ip = client.getInetAddress().getHostAddress();
		System.out.println("Ŭ���̾�Ʈ ����: " + ip);
		

		while (true) {
			byte[] cdata = new byte[1];
			client.getInputStream().read(cdata);
			if (cdata[0] == 2) {
				// �����
				btn[0].setBackground(Color.green);
			} else {
				btn[0].setBackground(Color.orange);
			}
		}
	}

}
