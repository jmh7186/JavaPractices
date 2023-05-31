package ex230421;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginServer {
	static final int LOGIN=1;
	static final int LOGOUT=2;
	static final int MSG_SEND=3;
	static final int MSG_RECV=4;
	
	public static void main(String[] args) {
		/*
		 ������ Ŭ���̾�Ʈ������ ����Ʈ ��Ʈ���� ���۵ǰ� �ִ� ��Ȳ
		 ���� ����Ʈ�� �������� �帧�� ��Ģ�� ������ ������ �������� �˼� ����.
		 ��Ģ�̶�� ���� ��������
		 
		 �������� �� �� �ִ� ���׵�
		 �α���(���̵�, �н����带 �Է¹޾� ������û)
		 �α׾ƿ�(��û�� ������ ����)
		 �޽��� �۽�(�����°�)
		 �޽��� ����(�޴� ��)
		 
		 �������� �����
		 ������û : 1 - �ʿ��� ���� (id(10), password(10))
		 �α׾ƿ� : 2 - �α׾ƿ� �����ϴ� 21, �����ϸ� 20
		 �޽��� �۽� : 3 - �޽��� ���̴� �����̶�� ������
		 �޽��� ���� : 4
		 */
		
		try {
			ServerSocket server=new ServerSocket(9999);
			System.out.println("���Ӵ����.....");
			Socket client=server.accept();
			System.out.println("Ŭ���̾�����...����������");
			DataOutputStream out
			=new DataOutputStream(client.getOutputStream());
			DataInputStream in
			=new DataInputStream(client.getInputStream());
			//System.out.println(in.readUTF());
			while(true) {
			String data=in.readUTF();
			System.out.println(data);
			System.out.println(Integer.parseInt(data.substring(0,1)));
			int code=Integer.parseInt(data.substring(0,1));
			//System.out.println(data.substring(1,(1+10)).trim());
			//String code=data.substring(0,1);
			//String id=data.substring(1,(1+10));
			//String password=data.substring(12,(12+10));
			//System.out.println(code);
			//System.out.println(id);
			//System.out.println(password);
			/*
			switch(code) {
			case 1: System.out.println("�α��� ����"); break;
			case 2: System.out.println("�α׾ƿ�"); break;
			case 3: System.out.println("�޽��� �۽�"); break;
			case 4: System.out.println("�޽��� ����"); break;
			default : System.out.println("���������"); break;
			}
			*/
			switch(code) {
			case LOGIN: 
				//System.out.println("�α��� ����");
				//���̵�, �н����� �и� �� Ȯ��
				//�޽����� ������ �������� Ȯ��
				String id=data.substring(1,(1+10)).trim();
				String password=data.substring(11,(11+10)).trim();
				if(id.equals("admin") && password.equals("1234")) {
					System.out.println("�α��� ���� ����");
				}else {
					System.out.println("�α��� ���� ����");
				}
				break;
			
			case LOGOUT: 
				//System.out.println("�α׾ƿ�");
				//�α׾ƿ��� ���̵� �и��ϰ�
				//�ش��ϴ� ���̵� ���� ��� �α׾ƿ� �������� Ȯ�� �޽��� ����
				break;
			
			case MSG_SEND: 
				//System.out.println("�޽��� �۽�"); 
				break;
			
			case MSG_RECV: 
				//System.out.println("�޽��� ����");
				//�޽��� �κ��� �и��Ͽ� �޽����� ó��
				break;
			
			default : 
				System.out.println("���������"); 
				break;
			}
			
			}
			//client.close();
			//server.close();
			}catch(Exception e) {}

	}

}
