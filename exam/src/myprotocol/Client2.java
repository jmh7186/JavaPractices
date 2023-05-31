package myprotocol;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
	public static void main(String[] args) {
		
		try {
			Socket socket=new Socket("192.168.0.10",9999);
			if(socket.isConnected()) System.out.println("Ŭ���̾����");
			
			InputStream is = socket.getInputStream();
			OutputStream out=socket.getOutputStream();
			
			while(true) {
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
				//�������ϴ� �����̹Ƿ� ���������� ����� �۾�����
				protocol=new Protocol(Protocol.PT_RES_LOGIN);
				System.out.println("���̵� �Է��ϼ���.");
				String id=new Scanner(System.in).nextLine();
				System.out.println("�н����带 �Է��ϼ���.");
				String password=new Scanner(System.in).nextLine();
				System.arraycopy(id.getBytes(), 0, protocol.getPacket(), 1, id.length());//��Ŷ�� ���̵� �Է�
				System.arraycopy(password.getBytes(), 0, protocol.getPacket(), 10, password.length());//��Ŷ�� ��й�ȣ �Է�
				out.write(protocol.getPacket());//packet�� ����� �����͸� ����
				out.flush();
				break;
			case Protocol.PT_LOGIN_RESULT :
				if(protocol.getPacket()[1]==Protocol.PT_LOGIN_RESULT_SUCESS) {
				System.out.println("�α��μ���");
				}else {
				System.out.println("�α��ν���");
				}
				break;
			}
			}//while end	 
			
		
			
		}catch(Exception e) {}
		

	}

}
