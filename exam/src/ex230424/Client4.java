package ex230424;

import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class Client4 {
	public static void main(String[] args) {
		
		try {
			Socket socket=new Socket("192.168.0.10",9999);
			
			ObjectOutputStream out
			=new ObjectOutputStream(socket.getOutputStream());
			
			//�������� Ÿ���� �α����̿��� ��Ŷ�� ����ٰ� ������ ���
			//���̵� : ��Ŷũ�� 10byte, �н����� :��Ŷũ�� 10byte, ��ü ��Ŷ���� : 4byte���
			//���̵����+�н��������+��ü��Ŷ����=�� ��Ŷ�� ������ 24
			int len=24;
			//������ �����ʹ� ������ Ŭ����
			NewProtocol data=new NewProtocol(len);
			//������ ���ڿ��� byte�迭�� �Է����� 
			String id="admin";
			String pass="1234";
			//int len=id.length()+pass.length();
			
			/* ���⼭ ���� ��Ŷ�� ����� �۾� */
			System.arraycopy
			(id.getBytes(),0, data.packet, 0, id.length());
			
			System.arraycopy
			(pass.getBytes(),0, data.packet, 10, pass.length());
			
			//������ ���� len�� ���� 4����Ʈ �迭�� �����(ù��° �Է�)
			//data.packet�� 20��°�ڸ����� 4����Ʈ�� ���縦 �Ѵ�.(����° �Է�~�ټ���°�Է�)
			System.arraycopy
			(ByteBuffer.allocate(4).putInt(len).array(),0,data.packet,20,4);
			/* ��Ŷ�۾� �Ϸ� */
			
			out.writeObject(data);
			out.flush();
			//���������۽� �ý��������� ���� �����Ͱ� ������ �ð��� �����ؾ���.
			Thread.sleep(1000);//******************
			System.out.println("���������ۿϷ�");
		}catch(Exception e) {}
		

	}

}
