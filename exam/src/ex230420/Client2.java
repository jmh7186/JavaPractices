package ex230420;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.JFrame;

class CClient2 extends JFrame implements ActionListener{
	
	Socket socket;
	TextField text;
	Button send;
	TextArea label;
	
	public CClient2() {
		setBounds(100,100,500,500);
		setLayout(new FlowLayout());
		setTitle("Ŭ���̾�Ʈ ���α׷�");
		
		text=new TextField(40);
		send=new Button("����");
		add(text);
		add(send);
		text.setVisible(false);//ȭ�鿡�� ��ǰ�� ����
		send.setVisible(false);
		
		label=new TextArea();
		add(label);
		label.setPreferredSize(new Dimension(400,400));
		label.setSize(new Dimension(400,400));
		send.addActionListener(this);
		
		try {
		socket=new Socket("192.168.0.10",9999);
		if(socket.isConnected()) {
			label.setText("������ ���ӵǾ����ϴ�.");
			text.setVisible(true);//������ ȭ���� ������
			send.setVisible(true);
			validate();//ȭ���� ���� ��ħ
			//���Ź޴� ������ ����
			new ClientRecvThread2(this).start();
		}else {
			label.setText("���� ���ӿ� �����߽��ϴ�.");
		}
		}catch(Exception e) {
			
		}
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("����")) {
			//���� ê��â�� �޽��� ������(label)
			label.setText("Ŭ���̾�:"+text.getText()+"\r\n"+label.getText());
			//Ŭ���̾�Ʈ ê��â�� �޽��� ��������.(socket outputstream)
			try {
			DataOutputStream out
			=new DataOutputStream(socket.getOutputStream());
			out.writeUTF("Ŭ���̾�Ʈ:"+text.getText());
			out.flush();
			}catch(Exception ex) {}
			
			//textâ�� �ִ� ������ ���������
			text.setText("");
			
			validate();
			repaint();

			
		}
		
	}
}
public class Client2 {

	public static void main(String[] args) {
		new CClient2();

	}

}
