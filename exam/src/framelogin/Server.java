package framelogin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;


class SendThread extends Thread {
	Socket socket;
	public SendThread(Socket socket) {
		this.socket=socket;
	}
	@Override
	public void run() {
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			while(true) {
				bw.write(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date())+"\n");
				bw.flush();
				sleep(1000);
			}
		}catch(Exception e) {}
	}
}

public class Server {

	public static void main(String[] args) {
		try {
			System.out.println("���� ����");
			ServerSocket socket = new ServerSocket(9999);
			System.out.println("���� �����...");
			Socket client = socket.accept();
			System.out.println("Ŭ���̾�Ʈ ����: " + client.getInetAddress().getHostAddress());
			BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

			while (true) {
				String data = br.readLine();
				if (data.split(" ")[0].equals("admin") && data.split(" ")[1].equals("1234")) {
					bw.write("�α��� ����\n");
					new SendThread(client).start();
					System.out.println("Ŭ���̾�Ʈ �α��� ����");
					break;
				} else {
					bw.write("�α��� ����\n");
					System.out.println("Ŭ���̾�Ʈ �α��� ����");
				}
				bw.flush();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
