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

		Frame f = new Frame("�׸���") {
			@Override
			public void paint(Graphics g) {
				g.setColor(color);
				g.drawLine(prex, prey, x, y);
			}
		};

		f.setBounds(0, 0, 800, 600);
		f.setVisible(true);

		// �����ʸ� ����ͷ� �����ϱ� (���� ����� '�Ⱦ��� �κб��� �����ؾ� �ϴ� ����' ����)
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

//		// �����츦 ���ΰ�ħ�ؾ�(â ũ�� ���� ��) ȭ�鿡 ǥ�õȴ�.
//		Thread.sleep(1000);
//		x = 100;
//		y = 100;
//
//		// �����츦 ���ΰ�ħ���� �ʾƵ� �׷����� �Ѵ�.
//		f.paint(f.getGraphics());

//		Thread.sleep(1000);
//		prex = x;
//		prey = y; // ���� ��ǥ�� ���� ��ǥ������ �����Ű�� ���ο� ���� �޾� �׸�.
//		x = 100;
//		y = 300;
		f.paint(f.getGraphics());

	}
}
