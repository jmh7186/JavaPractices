package ex230412;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client1 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("������ ������ �ּҸ� �Է��ϼ���.");
		String ip=new Scanner(System.in).nextLine();
		int port=new Scanner(System.in).nextInt();
		
		//Socket socket=new Socket("192.168.0.10", 5555);
		Socket socket=new Socket(ip, port);
		//����������
		
		socket.close();
	}

}
