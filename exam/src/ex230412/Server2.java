package ex230412;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {

	public static void main(String[] args) throws IOException {
		ServerSocket server=new ServerSocket(5555);
		System.out.println("�������α׷� ����");
		Socket client=server.accept();//���
		System.out.println(client.getInetAddress()+"Ŭ���̾�Ʈ�� �����Ͽ����ϴ�.");
		//������ ����(��������� stream�̿�)
		InputStream in=client.getInputStream();
		OutputStream out=client.getOutputStream();
		out.write("hello client".getBytes());
		out.flush();
		
		client.close();
		server.close();

	}

}
