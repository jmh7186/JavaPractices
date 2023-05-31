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
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;

class CServer2 extends JFrame implements ActionListener{
	ServerSocket server;
	Socket client;
	
	TextField text;
	Button send;
	TextArea label;
	
	public CServer2() {
		setBounds(100,100,500,500);
		setLayout(new FlowLayout());
		setTitle("서버프로그램");
		text=new TextField(40);
		send=new Button("전송");
		add(text);
		add(send);
		text.setVisible(false);//화면에서 부품을 숨김
		send.setVisible(false);
		try {
		server=new ServerSocket(9999);
		//클라이언트 접속 대기중이라는 메시지 레이블에 표시
		label=new TextArea("클라이언트 접속 대기중");
		add(label);
		label.setPreferredSize(new Dimension(400,400));
		label.setSize(new Dimension(400,400));
		setVisible(true);
		client=server.accept();
		label.setText(client.getInetAddress()+"접속하셨습니다.");
		text.setVisible(true);//숨겨진 화면을 보여줌
		send.setVisible(true);
		validate();//화면을 새로 고침
		//수신받는 쓰레드 동작
		new ServerRecvThread2(this).start();
		
		//버튼 리스너 등록
		send.addActionListener(this);
		
		}catch(Exception e) {
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("전송")) {
			//서버 챗팅창에 메시지 보내고(label)
			label.setText("서버:"+text.getText()+"\r\n"+label.getText());
			//클라이언트 챗팅창에 메시지 보내야함.(socket outputstream)
			try {
			DataOutputStream out
			=new DataOutputStream(client.getOutputStream());
			out.writeUTF("서버:"+text.getText());
			out.flush();
			}catch(Exception ex) {}
			
			//text창에 있는 내용을 비워져야함
			text.setText("");
			
			validate();
			repaint();

		}
		
	}
}

public class Server2 {

	public static void main(String[] args) {
		new CServer2();

	}

}
