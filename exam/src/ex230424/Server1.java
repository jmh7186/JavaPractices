package ex230424;

import java.io.DataInputStream;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class Server1 {

	public static void main(String[] args) {
		try {
			System.out.println("�������� ");

			ServerSocket server=new ServerSocket(9999);
			Socket client=server.accept();
			if(client.isConnected()) {
				System.out.println("Ŭ���̾�Ʈ ����");
			}
			DataInputStream in
			=new DataInputStream(client.getInputStream());
			//byte[] data=new byte[100];
			//byte[]  data=in.readAllBytes(); //�����߻�
			//ù��°���
			byte[] data=in.readNBytes(100); //�����Ʈ�� ���۵Ǵ��� Ȯ���� �ؾ���
			
			//�ι�° ���
			//byte[] data=new byte[100];
			//int len=in.read(data);
			//System.out.println(len);
			
			System.out.println(Arrays.toString(data));
			
			int protocol=data[0];
			byte[] imsi=new byte[100];
			System.arraycopy(data, 10, imsi, 0, 10);
			String id=new String(imsi).trim();
			
			Array.setByte(imsi, 0, (byte) 0);
			System.arraycopy(data, 20, imsi, 0, 10);
			String pass=new String(imsi).trim();;
			
			System.out.println("protocol:"+protocol);
			System.out.println("id:"+id);
			System.out.println("password:"+pass);
			System.out.println("��������");
		}catch(Exception e) {e.printStackTrace();}

	}

}
