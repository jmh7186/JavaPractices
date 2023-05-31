package ex230417;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client2 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket=new Socket("192.168.0.10",9999);
		//socket.connect(null);
		if(socket.isConnected()) {
			System.out.println("������ ���ӵǾ���.");
		}
		while(true) {
		//data receive
		BufferedReader in
		=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String data=in.readLine(); //���� �ٲٴ� ��ȣ "\n"
		System.out.println("�������� ������ �޽���:"+data);
		//data send
		//OutputStream os=socket.getOutputStream();
		//OutputStreamWriter osw=new OutputStreamWriter(os);
		//BufferedWriter out=new BufferedWriter(osw);
		BufferedWriter out
		=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		System.out.print("Ŭ���̾�Ʈ���� ���� �޽���:");
		out.write((new Scanner(System.in)).nextLine()+"\n");
		out.flush();
			
		}
		//System.out.println("������ ����Ǿ����ϴ�.");

	}

}
