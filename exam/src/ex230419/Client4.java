package ex230419;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client4 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket=new Socket("192.168.0.10",9999);
		
		if(!socket.isConnected()) {
			System.out.println("���ӿ���!!!");
			System.exit(0);
		}
		System.out.println("Ŭ���̾�Ʈ ����");
		//�޽����� ������ ���� �� �� �ʿ��� ����
		SendMSG send=new SendMSG(socket.getOutputStream());
		RecvMSG recv=new RecvMSG(socket.getInputStream(),"����");
		send.start();
		recv.start();

	}

}
