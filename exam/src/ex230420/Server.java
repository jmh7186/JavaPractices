package ex230420;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

class ChatServer extends Frame implements WindowListener, ActionListener{
	
	Socket socket;
	Button sendbtn;
	TextField text;
	
	public ChatServer() {
		setLayout(new FlowLayout());
		setBounds(100, 100, 300, 400);
		setVisible(true);
		addWindowListener(this);
		setTitle("�������α׷�");
		
		text=new TextField(30); 
		sendbtn=new Button("����");
		
		add(text);
		add(sendbtn);
		
		sendbtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("����")) {
			//���۹�ư�� ���� �� Ŭ���̾�Ʈ���� �ؽ�Ʈ ������ ���� �����Ѵ�.
			try {
			DataOutputStream out
			=new DataOutputStream(socket.getOutputStream());
			out.writeUTF(text.getText());
			text.setText("");
			}catch(Exception ex) {
				
			}
		}
		
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

	
}

public class Server {

	public static void main(String[] args) {
		//ChatServer Ŭ���� ����
		ChatServer chat=new ChatServer();
		
		try {
		//�������� ���� �� ����
		ServerSocket server=new ServerSocket(9999); 
		Socket client=server.accept();
		
		//Ŭ���̾�Ʈ ���ϻ��� �� ChatSeverŬ������ Ŭ���̾�Ʈ ������ �Ѱ���
		chat.setSocket(client);
		}catch(Exception e) {
			
		}

		
	}

}
