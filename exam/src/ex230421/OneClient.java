package ex230421;

import java.net.ServerSocket;
import java.net.Socket;

public class OneClient {

	public static void main(String[] args) {
		try {
			Socket socket=new Socket("192.168.0.10",9999);
			if(socket.isConnected()) System.out.println("������ ���� ����");
			else System.out.println("������ ���� ����");
			//Ŭ���̾�Ʈ ���� ���� �� ������ �ۼ����� ���� �۾��Ǿ����.
			new SendThread(socket.getOutputStream()).start();
			new RecvThread(socket.getInputStream()).start();
		}catch(Exception e) {}

	}

}
