package ex230424;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {

	public static void main(String[] args) {
		try {
			System.out.println("�������� ");

			ServerSocket server=new ServerSocket(9999);
			Socket client=server.accept();
			if(client.isConnected()) {
				System.out.println("Ŭ���̾�Ʈ ����");
			}
			ObjectInputStream in
			=new ObjectInputStream(client.getInputStream());
			
			Protocol data=(Protocol) in.readObject();
			System.out.println(data.toString());
			System.out.println("��������");
			
		}catch(Exception e) {e.printStackTrace();}

	}

}
