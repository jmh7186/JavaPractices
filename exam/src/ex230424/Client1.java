package ex230424;

import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class Client1 {
	public static void main(String[] args) {
		
		try {
			Socket socket=new Socket("192.168.0.10",9999);
			DataOutputStream out
			=new DataOutputStream(socket.getOutputStream());
			int protocol=1;
			String id="admin";
			String pass="1234";
			
			byte[] data=new byte[100];
			//�����ǳ����� ����Ʈ �迭�� �Է��ϰ� ��Ʈ������ ����
			data[0]=(byte)protocol;
			System.arraycopy
			(id.getBytes(),0, data, 10, id.getBytes().length);
			System.arraycopy
			(pass.getBytes(),0, data, 20, pass.getBytes().length);
			System.out.println(Arrays.toString(data));
			out.write(data);
			//out.write(data, 0, 21);
			out.flush();
			//Thread.sleep(1000);
			System.out.println("��������");
			
		}catch(Exception e) {}
		

	}

}
