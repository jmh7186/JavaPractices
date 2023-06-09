package ex230424;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server4 {

	public static void main(String[] args) {
		try {
			System.out.println("서버실행 ");

			ServerSocket server=new ServerSocket(9999);
			Socket client=server.accept();
			if(client.isConnected()) {
				System.out.println("클라이언트 접속");
			}
			ObjectInputStream in
			=new ObjectInputStream(client.getInputStream());
			
			NewProtocol data=(NewProtocol) in.readObject();
			System.out.println(data.getLenth()); //전체 패킷길이
			System.out.println(data.getId());
			System.out.println(data.getPassword());
			
			System.out.println("서버종료");
			
		}catch(Exception e) {e.printStackTrace();}

	}

}
