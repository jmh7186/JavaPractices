package ex230419;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server4 {

	public static void main(String[] args) throws IOException {
		//�Ʒ��� ����� �з��ϼ���. 
		/*
		1)����(���ϻ���) -> main()�Լ�
		2)�޽��� ������ ���(�۽�) -> SendMSG class
		3)�޽��� �޴� ���(����) ->RecvMSG class
		*/
		ServerSocket server=new ServerSocket(9999);
		System.out.println("���������.....");
		Socket client=server.accept();
		System.out.println(client.getInetAddress()+":ê�ü�������.....");
		//�޽����� ������ ���� �� �� �ʿ��� ����
		SendMSG send=new SendMSG(client.getOutputStream());
		RecvMSG recv=new RecvMSG(client.getInputStream(),"Ŭ���̾�Ʈ");
		send.start();
		recv.start();

	}

}
