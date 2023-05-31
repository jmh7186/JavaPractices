package ex230427;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class Proc1 implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(e.getX() + ", " + e.getY());

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}

public class Main2 {

	public static void main(String[] args) {
		Frame f=new Frame() {
			public void paint(Graphics g) {
			g.setColor(Color.black);
			g.drawLine(100, 100, 300, 300);
			}
		};
		
		f.setBounds(100,100,800,600);
		f.setVisible(true);
		f.addMouseListener(new Proc1());
	}
}
