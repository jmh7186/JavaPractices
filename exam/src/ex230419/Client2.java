package ex230419;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client2 {

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		Socket socket=new Socket("192.168.0.10",9999);
		
		if(!socket.isConnected()) {
			System.out.println("���ӿ���!!!");
			System.exit(0);
		}
		//������ ���� �Էµǰ� ��µǴ� ��θ� �̸� ����
		DataInputStream in
		=new DataInputStream(socket.getInputStream());
		DataOutputStream out
		=new DataOutputStream(socket.getOutputStream());
		
		System.out.println("Ŭ���̾�Ʈ ���α׷� ������!!!");
		//while(true) {
			//�޴��� ȭ�鿡 ��Ÿ������ ��.
			//�������� ������ �޴��� ���� �� ȭ�鿡 ǥ��
		while(true) {
			System.out.println(in.readUTF());
			out.writeUTF(new Scanner(System.in).nextLine());
			out.flush();
		}
		

	}

}
