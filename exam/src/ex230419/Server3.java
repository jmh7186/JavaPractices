package ex230419;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server3 {

	public static void main(String[] args) throws IOException {
		
		ServerSocket server=new ServerSocket(9999);
		System.out.println("���������.....");
		Socket client=server.accept();
		System.out.println("ê�ü�������.....");
		while(true) {
			String sendmsg=new Scanner(System.in).nextLine();
			DataOutputStream out
			=new DataOutputStream(client.getOutputStream());
			out.writeUTF(sendmsg);
			out.flush();
		}

	}

}
