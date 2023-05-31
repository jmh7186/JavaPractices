package ex230427;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main4 {

	public static void main(String[] args) {
		Frame f = new Frame("출결관리");
		Button btn=new Button("출근");
		
		f.setBounds(1200,100,250,100);
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
				if(btn.getBackground()==Color.orange) {
					btn.setBackground(Color.green);
					btn.setLabel("퇴근");
				}else if(btn.getBackground()==Color.green) {
					btn.setBackground(Color.orange);
					btn.setLabel("출근");
				}
			}
		});
		
		
	}

}
