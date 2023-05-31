package myprotocol;

import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;

public class Server4 {

	public static void main(String[] args) {
		try {
			//�������۽ð� ���
			new LogWriter().logServer();
			///////////////
			System.out.println("�������� ");

			ServerSocket server=new ServerSocket(9999);
			Socket client=server.accept();
			//Ŭ���̾�Ʈ���ӽð����
			new LogWriter().logClient();
			///////////////////
			
			if(client.isConnected()) {
				System.out.println("Ŭ���̾�Ʈ ����");
			}
			
			InputStream in=client.getInputStream();
			OutputStream out=client.getOutputStream();
			
			Protocol protocol=new Protocol(Protocol.PT_REQ_LOGIN);
			out.write(protocol.getPacket());
			out.flush();
			
			while(true) {
			protocol=new Protocol();
			in.read(protocol.getPacket());
			
			protocol.setProtocolType(protocol.getPacket()[0]);
			
			switch(protocol.getProtocolType()) {
			case Protocol.PT_RES_LOGIN :
				System.out.println("�α���Ȯ��");
				String id=protocol.getId();
				String password=protocol.getPassword();
				System.out.println("id:"+id);
				System.out.println("pass:"+password);
				if(id.equals("admin") && password.equals("1234")) {
					System.out.println("�α��μ�����������");
					protocol=new Protocol(Protocol.PT_LOGIN_RESULT);
					//protocol.getPacket()[1]=31;
					out.write(protocol.getPacket());
					out.flush();
					System.out.println("�ݺ��� �������ͼ� ");
					System.out.println("�ۼ��� ������ ����");
					
					
				}else {
					System.out.println("�α��ν��к�������");
					protocol=new Protocol(Protocol.PT_REQ_LOGIN);
					//protocol.getPacket()[1]=30;
					out.write(protocol.getPacket());
					out.flush();
				}
				break;
				
			}
			}
			
		}catch(Exception e) {e.printStackTrace();}

	}
 
}
