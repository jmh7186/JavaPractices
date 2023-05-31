package ex230419;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

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
		BufferedReader in
		=new BufferedReader(new InputStreamReader(client.getInputStream()));
		BufferedWriter out
		=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		int position=0;
		while(true) {
			//��û�� �����͸� ����
			String id=in.readLine(); 
			//�˻����Ͽ� ��ġȮ��
			for(int i=0;i<student.length;i++) {
				if(student[i].id.equals(id)) {
					position=i;
					break;
				}
			}
			//�����͸� ã������ �ش��ϴ� �迭 Ŭ���� ��ġ�� �����͸� ����
			ObjectOutputStream obj=
					new ObjectOutputStream(client.getOutputStream());
			obj.writeObject(student[position]);
			obj.flush();
		}

	}

}
