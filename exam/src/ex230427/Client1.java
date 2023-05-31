package ex230427;

import java.net.Socket;

public class Client1 {

	public static void main(String[] args) {
		try {
			Socket server = new Socket("192.168.0.30", 9999);
			if(!(server.isConnected())) System.out.println("서버 접속 실패");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
