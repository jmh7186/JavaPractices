package framelogin;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JFrame;

class RecvThread extends Thread {
	Socket socket;
	Label recvMsg;
	JFrame frame;

	public RecvThread(Socket socket, Label recvMsg, JFrame frame) {
		this.socket = socket;
		this.recvMsg = recvMsg;
		this.frame = frame;
	}

	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while (true) {
				String msg = br.readLine();
				recvMsg.setText(msg);
				frame.revalidate();
			}
		} catch (Exception e) {
		}
	}

}

public class Client {
	static Socket server;

	public static void main(String[] args) {
		JFrame f = new JFrame("로그인 클라이언트");

		f.setBounds(1100, 300, 285, 150);
		f.setLayout(new FlowLayout());
		Label idLabel = new Label("ID :                    ");
		Label passLabel = new Label("PASSWORD : ");
		TextField idText = new TextField(15);
		TextField passText = new TextField(15);
		Button loginBtn = new Button("로그인");
		Dialog dig = new Dialog(f, "메시지 창", true);
		Button digOkbtn = new Button("확인");
		Label digLabel = new Label("입력란이 비어있습니다.");
		Label recvMsg = new Label();
		dig.setLayout(new FlowLayout());
		dig.add(digLabel);
		dig.add(digOkbtn);
		dig.setSize(200, 100);
		passText.setEchoChar('●');
		f.add(idLabel);
		f.add(idText);
		f.add(passLabel);
		f.add(passText);
		f.add(loginBtn);
		f.add(recvMsg);
		f.setVisible(true);

		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (idText.getText().equals("") || passText.getText().equals("")) {
					dig.setVisible(true);
				} else {
					try {
						server = new Socket("192.168.0.51", 9999);
						while (true) {
							if (server != null) {
								idLabel.setVisible(false);
								idText.setVisible(false);
								passText.setVisible(false);
								passLabel.setVisible(false);
								loginBtn.setVisible(false);
								f.paint(f.getGraphics());

								// 데이터 송신
								String data = idText.getText() + " " + passText.getText() + "\n";
								// 라인으로 보내기 (\n 필요)
								BufferedWriter bw = new BufferedWriter(
										new OutputStreamWriter(server.getOutputStream()));
								bw.write(data);
								bw.flush();
								idText.setText("");
								passText.setText("");

//								//writeUTF (\n 불필요)
//								DataOutputStream dos = new DataOutputStream(server.getOutputStream());
//								바이트 문자열로 보내기
//								server.getOutputStream().write(data.getBytes());

								BufferedReader br = new BufferedReader(new InputStreamReader(server.getInputStream()));
								if (br.readLine().equals("로그인 성공")) {
									digLabel.setText("로그인 성공");
									dig.setSize(300, 100);
									dig.setVisible(true);
									idLabel.setVisible(false);
									idText.setVisible(false);
									passText.setVisible(false);
									passLabel.setVisible(false);
									loginBtn.setVisible(false);
									recvMsg.setVisible(true);
									f.paint(f.getGraphics());
									// 데이터 송수신 스레드 생성
									new RecvThread(server, recvMsg, f).start();
									break;
								} else {
									// 로그인 실패 메시지
									digLabel.setText("아이디 또는 비밀번호가 일치하지 않습니다.");
									idLabel.setVisible(true);
									idText.setVisible(true);
									passText.setVisible(true);
									passLabel.setVisible(true);
									loginBtn.setVisible(true);
									dig.setVisible(true);
									f.revalidate();
									System.out.println("클라이언트 로그인 실패");
								}

							}
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		dig.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dig.setVisible(false);
			}
		});

		digOkbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dig.setVisible(false);
			}
		});

	}

}
