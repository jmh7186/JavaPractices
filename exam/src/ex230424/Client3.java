package ex230424;

import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class Client3 {
	public static void main(String[] args) {
		
		try {
			Socket socket=new Socket("192.168.0.10",9999);
			
			ObjectOutputStream out
			=new ObjectOutputStream(socket.getOutputStream());
			
			//������ �����ʹ� ������ Ŭ����
			NewProtocol data=new NewProtocol();
			//������ ���ڿ��� byte�迭�� �Է����� 
			String id="admin";
			String pass="1234";
			//int len=id.length()+pass.length();
			
			System.arraycopy
			(id.getBytes(),0, data.packet, 0, id.length());
			System.arraycopy
			(pass.getBytes(),0, data.packet, 10, pass.length());
			
						
			out.writeObject(data);
			out.flush();
			//���������۽� �ý��������� ���� �����Ͱ� ������ �ð��� �����ؾ���.
			Thread.sleep(1000);//******************
			System.out.println("���������ۿϷ�");
		}catch(Exception e) {}
		

	}

}
