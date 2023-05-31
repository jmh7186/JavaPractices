package ex230331;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class Window extends Frame implements KeyListener{
	public Window() {
	addKeyListener(this);
	setBounds(100,100,400,400);
	setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.print(e.getKeyChar());
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}


public class Main2 {

	public static void main(String[] args) {
		Window win=new Window();

	}

}
