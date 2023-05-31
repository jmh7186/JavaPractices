package time;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

class Recv extends Thread {
	InputStream is;

	public Recv(InputStream is) {
		this.is = is;
	}

	@Override
	public void run() {
		try {
			while(true) {
				byte[] timebuf = new byte[1024];
				is.read(timebuf);
				System.out.println(new String(timebuf,0,1023).trim());
				sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

public class Client {

	public static void main(String[] args) {
		boolean login = false;
		try {
			Socket server = new Socket("127.0.0.1", 9999);
			if (!(server.isConnected()))
				System.out.println("서버 접속: " + server.getInetAddress().getHostAddress());

			OutputStream os = server.getOutputStream();
			InputStream is = server.getInputStream();
			byte[] buf;

			while (!(login)) {
				buf = new byte[21];
				buf[0] = 1;

				System.out.println("아이디 입력");
				String id = new Scanner(System.in).nextLine();

				System.out.println("비밀번호 입력");
				String password = new Scanner(System.in).nextLine();

				System.arraycopy(id.getBytes(), 0, buf, 1, id.getBytes().length);
				System.arraycopy(password.getBytes(), 0, buf, 11, password.getBytes().length);
				os.write(buf);
				os.flush();

				buf = new byte[2];
				is.read(buf);

				switch (buf[0]) {
				case 2:
					if (buf[1] == 1) {
						System.out.println("로그인 성공");
						new Recv(server.getInputStream()).start();
						login = true;
					} else {
						System.out.println("로그인 실패");
					}
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
