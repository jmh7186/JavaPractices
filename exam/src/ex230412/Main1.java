package ex230412;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main1 {

	public static void main(String[] args) throws IOException {
		
		ServerSocket server=new ServerSocket(80);
		int i=0;
		while(true) {
		System.out.println("서버 접속대기중...... ");
		Socket client=server.accept();
		String senddata=
		"HTTP/1.1 200 OK Content-Type:text/html;charset=utf-8\r\n\n";

		senddata+="<h1 style='color:green'>teacher com에 클라이언트 접속</h1>"+(i++);
		
		client.getOutputStream().write(senddata.getBytes());
		client.getOutputStream().flush();
		client.close();
		}
	}

}
