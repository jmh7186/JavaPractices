package ex230420;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;

class CServer extends JFrame implements ActionListener{
	ServerSocket server;
	Socket client;
	
	TextField text;
	Button send;
	Label label;
	
	public CServer() {
		setBounds(100,100,500,500);
		setLayout(new FlowLayout());
		setTitle("�������α׷�");
		text=new TextField(40);
		send=new Button("����");
		add(text);
		add(send);
		text.setVisible(false);//ȭ�鿡�� ��ǰ�� ����
		send.setVisible(false);
		try {
		server=new ServerSocket(9999);
		//Ŭ���̾�Ʈ ���� ������̶�� �޽��� ���̺� ǥ��
		label=new Label("Ŭ���̾�Ʈ ���� �����");
		add(label);
		label.setBackground(Color.lightGray);
		label.setPreferredSize(new Dimension(400,400));
		label.setSize(new Dimension(400,400));
		setVisible(true);
		client=server.accept();
		label.setText(client.getInetAddress()+"�����ϼ̽��ϴ�.");
		text.setVisible(true);//������ ȭ���� ������
		send.setVisible(true);
		validate();//ȭ���� ���� ��ħ
		//���Ź޴� ������ ����
		new ServerRecvThread(this).start();
		
		//��ư ������ ���
		send.addActionListener(this);
		
		}catch(Exception e) {
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("����")) {
			//���� ê��â�� �޽��� ������(label)
			label.setText("����:"+text.getText()+"\r\n"+label.getText());
			//Ŭ���̾�Ʈ ê��â�� �޽��� ��������.(socket outputstream)
			try {
			DataOutputStream out
			=new DataOutputStream(client.getOutputStream());
			out.writeUTF("����:"+text.getText());
			out.flush();
			}catch(Exception ex) {}
			
			//textâ�� �ִ� ������ ���������
			text.setText("");
			
			validate();
			repaint();

		}
		
	}
}

public class Server1 {

	public static void main(String[] args) {
		new CServer();

	}

}
