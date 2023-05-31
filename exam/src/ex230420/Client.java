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
		setTitle("클라이언트 프로그램");
		
		//text=new TextField(30); 
		//sendbtn=new Button("전송");
		
		//add(text);
		//add(sendbtn);
		
		//sendbtn.addActionListener(this);
		label=new Label();
		add(label);
		label.setSize(300, 300);
		label.setText("전송받은 메시지");
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
		
		//서버는 프레임서버를 사용하고 클라이언트는 콘솔로 처리
		/*
		try {
		Socket socket=new Socket("192.168.0.10",9999);
		//서버에서 수신받은 데이터를 콘솔로만 출력
		DataInputStream in=new DataInputStream(socket.getInputStream());
		while(true) {
		System.out.println(in.readUTF());
		}
		
		}catch(Exception e) {
			
		}
		*/

		//윈도우에서 데이터처리하는역할
		ChatClient chat=new ChatClient();
		
		//서버와 클라이언트 모두 프레임으로 처리하는 코드
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
