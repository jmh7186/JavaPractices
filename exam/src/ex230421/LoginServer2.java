package ex230421;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginServer2 {
	
	public static void main(String[] args) {
				
		try {
			ServerSocket server=new ServerSocket(9999);
			System.out.println("접속대기중.....");
			Socket client=server.accept();
			System.out.println("클라이언접속...서버실행중");
			DataOutputStream out
			=new DataOutputStream(client.getOutputStream());
			DataInputStream in
			=new DataInputStream(client.getInputStream());
			
			
		}catch(Exception e) {}
		
	}

}
