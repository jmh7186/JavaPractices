package ex230412;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client3 {

	public static void main(String[] args) throws UnknownHostException, IOException {
				
		Socket socket=new Socket("192.168.0.10", 5555);
		
		//���������� ��� �������
		InputStream in=socket.getInputStream();
		OutputStream out=socket.getOutputStream();
		
		//����->Ŭ���̾�Ʈ�� �޾� ó��
		byte[] data=new byte[1024];
		in.read(data);
		System.out.print("�������� �� �޽���:");
		System.out.println(new String(data));
		
		//Ŭ���̾�Ʈ->�������� �����͸� ��������.
		//out.write("hello server".getBytes()); //������ �����Ͱ� ����
		//out.flush();
		
		//1.������ �ִ� ������ ������ ���(�������� ����)->���������� Ŭ���̾�Ʈ ������
		//String senddata="hello server";
		//out.write(senddata.getBytes()); //������ �����Ͱ� ����
		//out.flush();
		
		//2.Ű���带 ���� �Է¹޾� ������ ���->���������� Ŭ���̾�Ʈ ������(������ ����)
		//String senddata=new Scanner(System.in).nextLine();
		//out.write(senddata.getBytes()); //������ �����Ͱ� ����
		//out.flush();
		
		//3.���Ϸκ��� �����͸� ������ �ͼ� ������ ���->���������� Ŭ���̾�Ʈ ������(���Ͽ� ����)
		FileInputStream file=new FileInputStream("a.txt"); 
		String senddata=new String(file.readAllBytes());
		out.write(senddata.getBytes()); //������ �����Ͱ� ����
		out.flush();
		
		
	}

}
