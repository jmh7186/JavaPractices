package ex230427;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main3 {
	static Color color = null;
	static int prex = 0;
	static int prey = 0;
	static int x = 0;
	static int y = 0;

	public static void main(String[] args) throws InterruptedException {

		Frame f = new Frame("그림판") {
			@Override
			public void paint(Graphics g) {
				g.setColor(color);
				g.drawLine(prex, prey, x, y);
			}
		};

		f.setBounds(0, 0, 800, 600);
		f.setVisible(true);

		// 리스너를 어댑터로 구현하기 (기존 방식의 '안쓰는 부분까지 구현해야 하는 단점' 보완)
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		f.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					prex = x;
					prey = y;
					x = e.getX();
					y = e.getY();
					f.paint(f.getGraphics());
				}
				if (e.getButton() == 3) {
					f.repaint();
				}
			}
		});
		f.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				prex = x;
				prey = y;
				x = e.getX();
				y = e.getY();
				f.paint(f.getGraphics());
			}
		});

//		// 윈도우를 새로고침해야(창 크기 조정 등) 화면에 표시된다.
//		Thread.sleep(1000);
//		x = 100;
//		y = 100;
//
//		// 윈도우를 새로고침하지 않아도 그려지게 한다.
//		f.paint(f.getGraphics());

//		Thread.sleep(1000);
//		prex = x;
//		prey = y; // 이전 좌표를 현재 좌표값으로 변경시키고 새로운 값을 받아 그림.
//		x = 100;
//		y = 300;
		f.paint(f.getGraphics());

	}
}
