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
		System.out.println("서버프로그램 실행중...(접속대기)");
		Socket client=server.accept();
		System.out.println("서버에 클라이언트 접속함");
		
		while(client.isConnected()) {
			//data send
			BufferedWriter out=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			System.out.print("클라이언트에게 보낼 메시지:");
			out.write((new Scanner(System.in)).nextLine()+"\n");
			out.flush();
			//data recevice
			
		}
		System.out.println("클라이언트 소켓 연결 해제되었음.");
		

	}

}
