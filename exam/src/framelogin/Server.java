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
			System.out.println("서버 실행");
			ServerSocket socket = new ServerSocket(9999);
			System.out.println("접속 대기중...");
			Socket client = socket.accept();
			System.out.println("클라이언트 접속: " + client.getInetAddress().getHostAddress());
			BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

			while (true) {
				String data = br.readLine();
				if (data.split(" ")[0].equals("admin") && data.split(" ")[1].equals("1234")) {
					bw.write("로그인 성공\n");
					new SendThread(client).start();
					System.out.println("클라이언트 로그인 성공");
					break;
				} else {
					bw.write("로그인 실패\n");
					System.out.println("클라이언트 로그인 실패");
				}
				bw.flush();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
