package ex230417;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket=new Socket("192.168.0.10",9999);
		//socket.connect(null);
		if(socket.isConnected()) {
			System.out.println("������ ���ӵǾ���.");
		}
		while(socket.isConnected()) {
		//data receive
		BufferedReader in
		=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String data=in.readLine(); //���� �ٲٴ� ��ȣ "\n"
		System.out.println("�������� ������ �޽���:"+data);
		//data send
			
		}
		System.out.println("������ ����Ǿ����ϴ�.");

	}

}
