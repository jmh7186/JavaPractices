package ex230420;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
class ChatClient extends Frame implements WindowListener, ActionListener{
	
	Socket socket;
	Label label;
	//Button sendbtn;
	//TextField text;
	
	public ChatClient() {
		setLayout(new FlowLayout());
		setBounds(400, 400, 300, 400);
		setVisible(true);
		addWindowListener(this);
		setTitle("Ŭ���̾�Ʈ ���α׷�");
		
		//text=new TextField(30); 
		//sendbtn=new Button("����");
		
		//add(text);
		//add(sendbtn);
		
		//sendbtn.addActionListener(this);
		label=new Label();
		add(label);
		label.setSize(300, 300);
		label.setText("���۹��� �޽���");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void sendMessage(String data) {
		label.setText(data);
	}

	
}
public class Client {

	public static void main(String[] args) {
		
		//������ �����Ӽ����� ����ϰ� Ŭ���̾�Ʈ�� �ַܼ� ó��
		/*
		try {
		Socket socket=new Socket("192.168.0.10",9999);
		//�������� ���Ź��� �����͸� �ַܼθ� ���
		DataInputStream in=new DataInputStream(socket.getInputStream());
		while(true) {
		System.out.println(in.readUTF());
		}
		
		}catch(Exception e) {
			
		}
		*/

		//�����쿡�� ������ó���ϴ¿���
		ChatClient chat=new ChatClient();
		
		//������ Ŭ���̾�Ʈ ��� ���������� ó���ϴ� �ڵ�
		try {
			Socket socket=new Socket("192.168.0.10",9999);
			chat.setSocket(socket);
			
			DataInputStream in=new DataInputStream(socket.getInputStream());
			while(true) {
			//System.out.println(in.readUTF());
			String data=in.readUTF();
			chat.sendMessage(data);
			}
			
			}catch(Exception e) {
				
			}
		
	}

}
