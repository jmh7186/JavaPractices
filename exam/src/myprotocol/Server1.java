package myprotocol;

import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
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
			InputStream in=client.getInputStream();
			OutputStream out=client.getOutputStream();
			
			//�α��νõ��ϼ���. �������� �ۼ�, ������ ����
			Protocol protocol=new Protocol(Protocol.PT_REQ_LOGIN);
			//Protocol protocol=new Protocol(100);
			//���������ʹ� ������ �����Ƿ� ���������� �ϼ��� ����.
			//���������� �����ϸ� ��.
			//OutputStream out=client.getOutputStream();
			out.write(protocol.getPacket());
			out.flush();
			
			//�α��ο�û�� �޾Ƽ� ó��(������ Ȯ��)
			//InputStream in=client.getInputStream();
			protocol=new Protocol();
			in.read(protocol.getPacket());
			String id=protocol.getId();
			String password=protocol.getPassword();
			System.out.println("id:"+id);
			System.out.println("pass:"+password);
			if(id.equals("admin") && password.equals("1234")) {
				//�α��μ���(�����޽���������)-�߰��޽��� 31(LOGIN_SUCESS)
				System.out.println("�α��μ���");
				//out=client.getOutputStream();
				protocol=new Protocol(Protocol.PT_LOGIN_RESULT);
				//packet[1]=31
				protocol.getPacket()[1]=31;
				//System.arraycopy
				//("31".getBytes(), 0, protocol.getPacket(), 1, "31".length());
				out.write(protocol.getPacket());
				out.flush();
				
			}else {
				//�α��ν���(���и޽���������)-�߰��޽��� 30(LOGIN_FAIL)
				System.out.println("�α��ν���");
				//out=client.getOutputStream();
				protocol=new Protocol(Protocol.PT_LOGIN_RESULT);
				//packet[1]=30
				protocol.getPacket()[1]=30;
				//System.arraycopy
				//("30".getBytes(), 0, protocol.getPacket(), 1, "30".length());
				out.write(protocol.getPacket());
				out.flush();
			}
			
			//ê�ó�������Ͽ� ȭ�鿡 ǥ���ϱ�(�� �������� ����-������ �б�-������ó��)
			protocol=new Protocol();
			in.read(protocol.getPacket());
			String msg=protocol.getMessage();
			System.out.println(msg);
			
		}catch(Exception e) {e.printStackTrace();}

	}
 
}
