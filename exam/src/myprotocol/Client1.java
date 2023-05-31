package myprotocol;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class Client1 {
	public static void main(String[] args) {
		
		try {
			Socket socket=new Socket("192.168.0.10",9999);
			if(socket.isConnected()) System.out.println("Ŭ���̾����");
			
			InputStream is = socket.getInputStream();
			OutputStream out=socket.getOutputStream();
			
			//�������� ���۵� �����͸� �������ݰ�ü�� packet�� �̿�
			Protocol protocol = new Protocol();//��ٱ��Ͽ���
			is.read(protocol.getPacket());
			//�����͸� �������� ���ҵ� ������ �ּҸ� ��ȯ�ϴ� ������ �ϹǷ� 
			//�ش� ��ġ�� ���۵� �����͸� pakcet�� ������ �� ����.
			//System.out.println(protocol.getPacket()[0]); //Ȯ���۾�
			protocol.setProtocolType(protocol.getPacket()[0]);
			System.out.println(protocol.getProtocolType());
			
			switch(protocol.getProtocolType()) {
			//case Protocol.PT_EXIT : System.out.println("�α�������");break;
			case Protocol.PT_REQ_LOGIN : 
				System.out.println("�α��ο�û����");
				//�α��νõ�(�ʿ��� ����:���̵�, �н����带 �Է��Ͽ� ��û)
				protocol=new Protocol(Protocol.PT_RES_LOGIN);
				System.arraycopy("admin".getBytes(), 0, protocol.getPacket(), 1, "admin".length());//��Ŷ�� ���̵� �Է�
				System.arraycopy("12345".getBytes(), 0, protocol.getPacket(), 10, "12345".length());//��Ŷ�� ��й�ȣ �Է�
				out.write(protocol.getPacket());//packet�� ����� �����͸� ����
				out.flush();
				break;
			case Protocol.PT_LOGIN_RESULT :
				protocol=new Protocol(Protocol.PT_LOGIN_RESULT);
				System.out.println("�α��μ�������:"+protocol.getPacket()[1]);
				break;
			}
			 
			protocol = new Protocol();//��ٱ��Ͽ���
			is.read(protocol.getPacket());
			System.out.println("�α��μ�������:"+protocol.getPacket()[1]);
			
			//ê���ϱ�(�������ݸ����-���ڿ��Է�)
			protocol=new Protocol(Protocol.PT_CHAT);
			System.arraycopy("hello".getBytes(), 0, protocol.getPacket(), 1, "hello".length());
			out.write(protocol.getPacket());
			
			
		}catch(Exception e) {}
		

	}

}
