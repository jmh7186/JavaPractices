package ex230417;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) throws IOException {
		ServerSocket server=new ServerSocket(9999); 
		System.out.println("�������α׷� ������...(���Ӵ��)");
		Socket client=server.accept();
		System.out.println("������ Ŭ���̾�Ʈ ������");
		
		while(client.isConnected()) {
			//data send
			BufferedWriter out=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			System.out.print("Ŭ���̾�Ʈ���� ���� �޽���:");
			out.write((new Scanner(System.in)).nextLine()+"\n");
			out.flush();
			//data recevice
			
		}
		System.out.println("Ŭ���̾�Ʈ ���� ���� �����Ǿ���.");
		

	}

}
