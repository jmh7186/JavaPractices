package ex230412;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server4 {

	public static void main(String[] args){
		try {
		ServerSocket server=new ServerSocket(5555);
		System.out.println("�������α׷� ����");
		Socket client=server.accept();//���
		System.out.println(client.getInetAddress()+"Ŭ���̾�Ʈ�� �����Ͽ����ϴ�.");
		//������ ����(��������� stream�̿�)
		InputStream in=client.getInputStream();
		OutputStream out=client.getOutputStream();
		
		//����->Ŭ���̾�Ʈ�� ������ ����
		out.write("hello client".getBytes());
		out.flush();
		
		//Ŭ���̾�->�������� ������ �޽��� ó��
		ObjectInputStream objin=new ObjectInputStream(in);
		Member m=(Member)objin.readObject();
		System.out.println("Ŭ���̾�Ʈ���� �� �޽���:");
		System.out.println(m.getId());
		System.out.println(m.getPassword());
		client.close();
		server.close();
		Thread.sleep(1000);
		}catch(Exception e) {e.printStackTrace(); }
	}

}
