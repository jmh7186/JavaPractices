package ex230412;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client2 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		//System.out.println("������ ������ �ּҸ� �Է��ϼ���.");
		//String ip=new Scanner(System.in).nextLine();
		//int port=new Scanner(System.in).nextInt();
		
		Socket socket=new Socket("192.168.0.10", 5555);
		//Socket socket=new Socket(ip, port);
		//���������� ��� �������
		InputStream in=socket.getInputStream();
		OutputStream out=socket.getOutputStream();
		byte[] data=new byte[1024];
		in.read(data);
		System.out.print("�������� �� �޽���:");
		System.out.println(new String(data));
		
		socket.close();
	}

}
