package ex230421;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class LoginClient {

	public static void main(String[] args) {
		try {
		Socket socket=new Socket("192.168.0.10",9999);
		if(socket.isConnected()) System.out.println("������ ���� ����");
		else System.out.println("������ ���� ����");
		DataOutputStream out
		=new DataOutputStream(socket.getOutputStream());
		DataInputStream in
		=new DataInputStream(socket.getInputStream());
		/*
		 �������� �����
		 
		 ������û : 1 - �ʿ��� ���� (id(10), password(10))
		 �α׾ƿ� : 2 - �α׾ƿ� �����ϴ� 21, �����ϸ� 20
		 �޽��� �۽� : 3 - �޽��� ���̴� �����̶�� ������
		 �޽��� ���� : 4
		 */
		
		//out.writeUTF("1admin     1234      ");
		while(true) {
		out.writeUTF(new Scanner(System.in).nextLine());
		out.flush();
		}
		
		//socket.close();
		}catch(Exception e) {}
	}

}
