package ex230412;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main1 {

	public static void main(String[] args) throws IOException {
		
		ServerSocket server=new ServerSocket(80);
		int i=0;
		while(true) {
		System.out.println("���� ���Ӵ����...... ");
		Socket client=server.accept();
		String senddata=
		"HTTP/1.1 200 OK Content-Type:text/html;charset=utf-8\r\n\n";

		senddata+="<h1 style='color:green'>teacher com�� Ŭ���̾�Ʈ ����</h1>"+(i++);
		
		client.getOutputStream().write(senddata.getBytes());
		client.getOutputStream().flush();
		client.close();
		}
	}

}
