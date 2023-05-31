package ex230427;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Robot;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class MouseMoveColor {
	static int x1 = 0;
	static int y1 = 0;
	static int prex = 0;
	static int prey = 0;
	static int a = 1;
	static Color color = null;

	public static void main(String[] args) throws IOException, AWTException {
		ServerSocket server = new ServerSocket(55000);
		Socket client = server.accept();

		// 소켓으로 데이터를 수신받아 x, y분리
		// mouse를 움직임 당하는 쪽은 서버역할

		System.out.println("서버");

		// Robot robot = new Robot();
		Frame f = new Frame("server") {
			@Override
			public void paint(Graphics g) {
				// g.drawLine(0, 0, 200, 200);
				// g.drawLine(0, 0, x, y);
				g.setColor(color);
				g.drawLine(prex, prey, x1, y1);

				// g.drawRect(100, 100, 300, 300);
			}

		};

		f.setBounds(100, 100, 400, 200);
		f.setVisible(true);
		f.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {

			}
		});
		
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

		while (true) {
			String data = in.readLine();
			System.out.println(data.substring(0, 1).trim());
			if (data == null)
				break;
			else if (data.substring(0, 1).trim().equals("x")) {
				String[] arraydata = data.split(" ");
				// System.out.println(arraydata[0]);
				// System.out.println(arraydata[1]);
				String[] x = arraydata[0].split(":");
				String[] y = arraydata[1].split(":");
				// System.out.println(x[0]);
				System.out.println("x:" + x[1]);
				// System.out.println(y[0]);
				System.out.println("y:" + y[1]);

				x1 = Integer.parseInt(x[1]);
				y1 = Integer.parseInt(y[1]);
				f.paint(f.getGraphics());
				prex = x1;
				prey = y1;
				// System.out.println("if문들어옴");
			} else if (data.substring(0, 1).trim().equals("3")) {
				System.out.println(data);
				f.repaint();
			} else if (data.substring(0, 1).trim().equals("2")) {

				switch (a) {
				case 1:
					color = Color.black;
					f.paint(f.getGraphics());
					// f.getGraphics().setColor(Color.black);
					a++;
					System.out.println("블랙실행");
					break;

				case 2:
					color = Color.blue;
					f.paint(f.getGraphics());
					a++;
					System.out.println("블루실행");
					break;
				case 3:
					color = Color.red;
					f.paint(f.getGraphics());
					a++;
					System.out.println("레드실행");
					break;
				case 4:
					a = 1;
					break;

				}

				if (a == 4) {
					a = 1;
				}

			}

			// robot.mouseMove(Integer.parseInt(x[1]), Integer.parseInt(y[1]));
		}
		client.shutdownInput();
		client.close();
		server.close();
	}

}
