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
		JFrame f = new JFrame("�α��� Ŭ���̾�Ʈ");

		f.setBounds(1100, 300, 285, 150);
		f.setLayout(new FlowLayout());
		Label idLabel = new Label("ID :                    ");
		Label passLabel = new Label("PASSWORD : ");
		TextField idText = new TextField(15);
		TextField passText = new TextField(15);
		Button loginBtn = new Button("�α���");
		Dialog dig = new Dialog(f, "�޽��� â", true);
		Button digOkbtn = new Button("Ȯ��");
		Label digLabel = new Label("�Է¶��� ����ֽ��ϴ�.");
		Label recvMsg = new Label();
		dig.setLayout(new FlowLayout());
		dig.add(digLabel);
		dig.add(digOkbtn);
		dig.setSize(200, 100);
		passText.setEchoChar('��');
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

								// ������ �۽�
								String data = idText.getText() + " " + passText.getText() + "\n";
								// �������� ������ (\n �ʿ�)
								BufferedWriter bw = new BufferedWriter(
										new OutputStreamWriter(server.getOutputStream()));
								bw.write(data);
								bw.flush();
								idText.setText("");
								passText.setText("");

//								//writeUTF (\n ���ʿ�)
//								DataOutputStream dos = new DataOutputStream(server.getOutputStream());
//								����Ʈ ���ڿ��� ������
//								server.getOutputStream().write(data.getBytes());

								BufferedReader br = new BufferedReader(new InputStreamReader(server.getInputStream()));
								if (br.readLine().equals("�α��� ����")) {
									digLabel.setText("�α��� ����");
									dig.setSize(300, 100);
									dig.setVisible(true);
									idLabel.setVisible(false);
									idText.setVisible(false);
									passText.setVisible(false);
									passLabel.setVisible(false);
									loginBtn.setVisible(false);
									recvMsg.setVisible(true);
									f.paint(f.getGraphics());
									// ������ �ۼ��� ������ ����
									new RecvThread(server, recvMsg, f).start();
									break;
								} else {
									// �α��� ���� �޽���
									digLabel.setText("���̵� �Ǵ� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
									idLabel.setVisible(true);
									idText.setVisible(true);
									passText.setVisible(true);
									passLabel.setVisible(true);
									loginBtn.setVisible(true);
									dig.setVisible(true);
									f.revalidate();
									System.out.println("Ŭ���̾�Ʈ �α��� ����");
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
