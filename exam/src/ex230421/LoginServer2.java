package ex230421;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginServer2 {
	
	public static void main(String[] args) {
				
		try {
			ServerSocket server=new ServerSocket(9999);
			System.out.println("���Ӵ����.....");
			Socket client=server.accept();
			System.out.println("Ŭ���̾�����...����������");
			DataOutputStream out
			=new DataOutputStream(client.getOutputStream());
			DataInputStream in
			=new DataInputStream(client.getInputStream());
			
			
		}catch(Exception e) {}
		
	}

}
