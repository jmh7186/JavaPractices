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

public class Server2 {

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
			out.write((new Scanner(System.in)).nextLine()+"\n");
			out.flush();
			//data recevice
			//InputStream is=client.getInputStream();
			//InputStreamReader isr=new InputStreamReader(is);
			//BufferedReader in=new BufferedReader(isr);
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


