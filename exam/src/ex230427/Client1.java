package ex230427;

import java.net.Socket;

public class Client1 {

	public static void main(String[] args) {
		try {
			Socket server = new Socket("192.168.0.30", 9999);
			if(!(server.isConnected())) System.out.println("���� ���� ����");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
