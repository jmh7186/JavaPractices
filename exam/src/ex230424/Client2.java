package ex230424;

import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class Client2 {
	public static void main(String[] args) {
		
		try {
			Socket socket=new Socket("192.168.0.10",9999);
			ObjectOutputStream out
			=new ObjectOutputStream(socket.getOutputStream());
			Protocol data=new Protocol(1,"admin1234");
			out.writeObject(data);
			out.flush();
			//���������۽� �ý��������� ���� �����Ͱ� ������ �ð��� �����ؾ���.
			Thread.sleep(1000);//******************
			System.out.println("���������ۿϷ�");
		}catch(Exception e) {}
		

	}

}
