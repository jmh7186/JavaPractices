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
		setTitle("서버프로그램");
		
		text=new TextField(30); 
		sendbtn=new Button("전송");
		
		add(text);
		add(sendbtn);
		
		sendbtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("전송")) {
			//전송버튼을 누를 때 클라이언트에게 텍스트 상자의 값을 전송한다.
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
		//ChatServer 클래스 실행
		ChatServer chat=new ChatServer();
		
		try {
		//서버소켓 생성 및 접속
		ServerSocket server=new ServerSocket(9999); 
		Socket client=server.accept();
		
		//클라이언트 소켓생성 후 ChatSever클래스에 클라이언트 소켓을 넘겨줌
		chat.setSocket(client);
		}catch(Exception e) {
			
		}

		
	}

}
