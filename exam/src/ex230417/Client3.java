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

public class Client3 {

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
		String[] buf=data.split(" ");
		String id=buf[0];
		String name=buf[1];
		int kor=Integer.parseInt(buf[2]);
		int eng=Integer.parseInt(buf[3]);
		int math=Integer.parseInt(buf[4]);
		System.out.printf("�й�:%s �̸�:%s\n",id, name);
		System.out.printf("����:%d ����:%d ����:%d\n",kor,eng,math);
		System.out.printf("�հ�:%d ���:%.2f\n",kor+eng+math,(float)(kor+eng+math)/3);
		//data send
		BufferedWriter out
		=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		System.out.print("Ŭ���̾�Ʈ���� ���� �޽���:");
		out.write((new Scanner(System.in)).nextLine()+"\n");
		out.flush();
			
		}
		//System.out.println("������ ����Ǿ����ϴ�.");

	}

}
