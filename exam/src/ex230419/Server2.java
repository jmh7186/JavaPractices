package ex230419;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {

	public static void main(String[] args) throws IOException {
		//������ �غ�
		Student[] student=new Student[5];
		student[0]=new Student("20000101","ȫ�浿", 100, 100, 100);
		student[1]=new Student("20000102","���浿", 90, 90, 90);
		student[2]=new Student("20000103","�̱浿", 80, 80, 80);
		student[3]=new Student("20000104","�ڱ浿", 70, 70, 70);
		student[4]=new Student("20000105","���浿", 60, 60, 60);
				
		ServerSocket server=new ServerSocket(9999);
		System.out.println("���������.....");
		Socket client=server.accept();
		System.out.println(client.getInetAddress()+"Ŭ���̾�Ʈ ����");
		//������ ���� �Էµǰ� ��µǴ� ��θ� �̸� ����
		DataInputStream in
		=new DataInputStream(client.getInputStream());
		DataOutputStream out
		=new DataOutputStream(client.getOutputStream());
		int position=0;
		while(true) {
			//���Ӱ� ���ÿ� �޴��� Ŭ���̾�Ʈ���� ����
			String menu="1.�Է�\n2.��ü���\n3.����\n4.����\n";
			out.writeUTF(menu);
			out.flush();
			
			//�޴���ȣ�� ����
			String select=in.readUTF();
					
			switch(select) {
			case "1" : System.out.println("1������մϴ�."); break;
			case "2" : System.out.println("2������մϴ�."); break;
			case "3" : System.out.println("3������մϴ�."); break;
			case "4" : System.out.println("4������մϴ�."); break;
			}
		}	

	}

}
