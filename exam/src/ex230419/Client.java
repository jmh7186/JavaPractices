package ex230419;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		Socket socket=new Socket("192.168.0.10",9999);
		
		if(!socket.isConnected()) {
			System.out.println("���ӿ���!!!");
			System.exit(0);
		}
		//������ ���� �Էµǰ� ��µǴ� ��θ� �̸� ����
		//BufferedReader in
		//=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		BufferedWriter out
		=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		
		System.out.println("Ŭ���̾�Ʈ ���α׷� ������!!!");
		while(true) {
			//������ ��û
			System.out.println("������ �������� �й��� �Է��ϼ���.(����:exit)");
			String id=(new Scanner(System.in)).nextLine();
			out.write(id+"\n");
			out.flush();
			//��û�� �����͸� ����
			ObjectInputStream obj=new ObjectInputStream(socket.getInputStream());
			Student s=(Student)obj.readObject();
			//���ŵ� �����͸� ���
			System.out.println(s.toString());
		}

	}

}
