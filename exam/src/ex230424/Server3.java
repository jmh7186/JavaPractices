package ex230424;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server3 {

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
			
			NewProtocol data=(NewProtocol) in.readObject();
			System.out.println(data.getId());
			System.out.println(data.getPassword());
			
			System.out.println("��������");
			
		}catch(Exception e) {e.printStackTrace();}

	}

}
