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
		System.out.println("클라이언트 실행");
		System.out.println("접속 대기 중");
		Socket server = new Socket("192.168.0.10", 9999);
		if (!server.isConnected()) {
			System.out.println("접속 실패");
			System.exit(0);
		}
		System.out.println("서버 접속: " + server.getInetAddress().getHostAddress());

		Frame f = new Frame("출결관리");
		Button btn = new Button("출근");

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
					btn.setLabel("퇴근");
					try {
						server.getOutputStream().write(2);
						server.getOutputStream().flush();
					} catch (Exception e1) {
					}
				} else if (btn.getBackground() == Color.green) {
					btn.setBackground(Color.orange);
					btn.setLabel("출근");
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
