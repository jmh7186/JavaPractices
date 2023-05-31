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
		setTitle("클라이언트 프로그램");
		
		text=new TextField(40);
		send=new Button("전송");
		add(text);
		add(send);
		text.setVisible(false);//화면에서 부품을 숨김
		send.setVisible(false);
		
		label=new TextArea();
		add(label);
		label.setPreferredSize(new Dimension(400,400));
		label.setSize(new Dimension(400,400));
		send.addActionListener(this);
		
		try {
		socket=new Socket("192.168.0.10",9999);
		if(socket.isConnected()) {
			label.setText("서버에 접속되었습니다.");
			text.setVisible(true);//숨겨진 화면을 보여줌
			send.setVisible(true);
			validate();//화면을 새로 고침
			//수신받는 쓰레드 동작
			new ClientRecvThread2(this).start();
		}else {
			label.setText("서버 접속에 실패했습니다.");
		}
		}catch(Exception e) {
			
		}
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("전송")) {
			//서버 챗팅창에 메시지 보내고(label)
			label.setText("클라이언:"+text.getText()+"\r\n"+label.getText());
			//클라이언트 챗팅창에 메시지 보내야함.(socket outputstream)
			try {
			DataOutputStream out
			=new DataOutputStream(socket.getOutputStream());
			out.writeUTF("클라이언트:"+text.getText());
			out.flush();
			}catch(Exception ex) {}
			
			//text창에 있는 내용을 비워져야함
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
