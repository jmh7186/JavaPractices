package ex230412;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {

	public static void main(String[] args) throws IOException {
		ServerSocket server=new ServerSocket(5555);
		System.out.println("�������α׷� ����");
		Socket client=server.accept();//���
		System.out.println(client.getInetAddress()+"Ŭ���̾�Ʈ�� �����Ͽ����ϴ�.");
		//������ ����
		
		client.close();
		server.close();

	}

}
