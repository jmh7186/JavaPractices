package ex230427;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main5 {

	public static void main(String[] args) {
		Frame f = new Frame("출결관리 서버");
		Button[] btn=new Button[24];
		
		f.setBounds(1200,100,600,200);
		f.setLayout(new FlowLayout());
		for(int i=0;i<btn.length;i++) {
			btn[i]=new Button("Computer: "+(i+1));
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
	}

}
