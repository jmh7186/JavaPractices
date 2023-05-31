package multichat_answer;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

public class Client6 {
	public static void main(String[] args) {
		
		try {
			Socket socket=new Socket("192.168.0.10",9999);
			if(socket.isConnected()) System.out.println("Ŭ���̾����");
			
			InputStream is = socket.getInputStream();
			OutputStream out=socket.getOutputStream();
			boolean state=true;
			while(state) {
			Protocol protocol = new Protocol();
			is.read(protocol.getPacket());
			
			protocol.setProtocolType(protocol.getPacket()[0]);
			
			switch(protocol.getProtocolType()) {
			case Protocol.PT_REQ_LOGIN : 
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
					System.out.println("�α��μ���/ê�þ����� ����");
					//new RecvThread2(socket.getInputStream()).start();
					new SendThread2(socket.getOutputStream()).start();
					//state=false;
					break;
			case Protocol.PT_CHAT :
				System.out.println("�����޽���:"+protocol.getMessage());
					break;
			case Protocol.PT_LOGOUT :
				System.out.println("Ŭ���̾�Ʈ ���α׷��� �����մϴ�.");System.exit(0);
					break;
			}
		 			
			}//while end
		}catch(Exception e) {}
		

	}

}
