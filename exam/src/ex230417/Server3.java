package ex230417;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server3 {

	public static void main(String[] args) throws IOException {
		ServerSocket server=new ServerSocket(9999); 
		System.out.println("�������α׷� ������...(���Ӵ��)");
		Socket client=server.accept();
		System.out.println("������ Ŭ���̾�Ʈ ������");
		
		while(true) {
			//data send
			BufferedWriter out
			=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			System.out.print("Ŭ���̾�Ʈ���� ���� �޽���:");
			//�������α׷����� ������ ����
			//�й� �̸� ���� ���� ����
			//"20000101 ȫ�浿 100 90 80"
			String id="20000101";
			String name="ȫ�浿";
			int kor=100; int eng=90; int math=80;
			//String sdata=id+" "+name+" "+kor+" "+eng+" "+math+"\n";
			
			StringBuffer buf=new StringBuffer();
			buf.append(id);buf.append(" ");
			buf.append(name);buf.append(" ");
			buf.append(kor);buf.append(" ");
			buf.append(eng);buf.append(" ");
			buf.append(math);buf.append("\n");
			
			out.write(buf.toString());
			out.flush();
			//data recevice
			BufferedReader in
			=new BufferedReader(new InputStreamReader(client.getInputStream()));
			String data=in.readLine();
			System.out.println("Ŭ���̾�Ʈ���� ������ �޽���:"+data);
		}
		//System.out.println("Ŭ���̾�Ʈ ���� ���� �����Ǿ���.");
		

	}

}
//�� ���α׷��� ��������
/*
���Ṯ��
�������ֻ���(������), �������·� ê�� �ȵ�.
������ 1:1��Ÿ� �Ǵ� ����, �ٴ����� ����.
�ݵ�� �ʿ��� ���� : ������ ����
*/


