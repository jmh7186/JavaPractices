package ex230412;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main7 {

	public static void main(String[] args) throws IOException {
		//������ �����Ͽ� �������� �����͸� ����ϼ���.
		ServerSocket server=new ServerSocket(80);
		System.out.println("���� ���Ӵ����...... ");
		Socket client=server.accept();
		//Ŭ���̾�Ʈ �ּ�:��Ʈ��ȣ
		System.out.println(client.getRemoteSocketAddress());
		//Ŭ���̾�Ʈ �ּ�
		System.out.println(client.getInetAddress());
		//Ŭ���̾�Ʈ ��Ʈ��ȣ
		System.out.println(client.getPort());
		//������ �ּ�
		System.out.println(client.getLocalAddress());
		//������ �ּ� ��Ʈ��ȣ
		System.out.println(client.getLocalSocketAddress());
		client.
		
		
		client.close();
		server.close();
		
	}

}
