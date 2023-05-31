package ex230427;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client4 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("Ŭ���̾�Ʈ ����");
		System.out.println("���� ��� ��");
		Socket server = new Socket("192.168.0.10", 9999);
		if (!server.isConnected()) {
			System.out.println("���� ����");
			System.exit(0);
		}
		System.out.println("���� ����: " + server.getInetAddress().getHostAddress());

		Frame f = new Frame("������");
		Button btn = new Button("���");

		f.setBounds(1200, 100, 250, 100);
		f.setLayout(new FlowLayout());
		btn.setBackground(Color.orange);
		f.add(btn);
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(btn.getBackground());
				if (btn.getBackground() == Color.orange) {
					btn.setBackground(Color.green);
					btn.setLabel("���");
					try {
						server.getOutputStream().write(2);
						server.getOutputStream().flush();
					} catch (Exception e1) {
					}
				} else if (btn.getBackground() == Color.green) {
					btn.setBackground(Color.orange);
					btn.setLabel("���");
					try {
						server.getOutputStream().write(1);
						server.getOutputStream().flush();
					} catch (Exception e1) {
					}
				}
			}
		});

	}

}
