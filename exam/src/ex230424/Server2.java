package ex230424;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {

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
			
			Protocol data=(Protocol) in.readObject();
			System.out.println(data.toString());
			System.out.println("서버종료");
			
		}catch(Exception e) {e.printStackTrace();}

	}

}
