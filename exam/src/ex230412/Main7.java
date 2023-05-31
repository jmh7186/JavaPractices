package ex230412;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main7 {

	public static void main(String[] args) throws IOException {
		//서버에 접속하여 보내오는 데이터를 출력하세요.
		ServerSocket server=new ServerSocket(80);
		System.out.println("서버 접속대기중...... ");
		Socket client=server.accept();
		//클라이언트 주소:포트번호
		System.out.println(client.getRemoteSocketAddress());
		//클라이언트 주소
		System.out.println(client.getInetAddress());
		//클라이언트 포트번호
		System.out.println(client.getPort());
		//서버의 주소
		System.out.println(client.getLocalAddress());
		//서버의 주소 포트번호
		System.out.println(client.getLocalSocketAddress());
		client.
		
		
		client.close();
		server.close();
		
	}

}
