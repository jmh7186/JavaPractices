package ex230328;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main8 {

	public static void main(String[] args) throws IOException {
		//�޸�(����)�� �ִ� ������ ���Ͽ� ����ϴ� ���� �ǹ��� 
		//File�� ��ü�� ������ ��� ������ �������� ������ �ڵ����� ������ �ȵ�.
		//������ ���Ͻ�Ʈ���� �Է°����� ���ϸ� ������ ������ ���� ��� �ڵ� ����
		/*
		FileOutputStream fos=new FileOutputStream("c.txt");
		fos.write(97);
		fos.write('b');
		//fos.write({99,100,101,102}); //�����߻�
		byte[] data={99,100,101,102};
		fos.write(data);
		//���ڿ��� �Է¹޾� c.txt�� ���� �Է��ϼ���.
		//���ڿ�->����Ʈ�迭->write
		Scanner scan=new Scanner(System.in);
		String s=scan.nextLine();
		fos.write(s.getBytes());
		
		fos.flush();
		fos.close();
		*/
		//File(e.txt) -> memory -> File(f.txt)
		//File�� ���� �޸𸮷� ������ ��(FileInputStream)
		FileInputStream in=new FileInputStream("e.txt");
		//System.out.println((char)in.read());//Ȯ��
		//������ó�����-> 1����Ʈ�� �ű�� �۾�, �ѹ��� �޾Ƽ� �ű�� �۾�
		byte[] data=new byte[100];
		int len=0;
		if(in.available()>0) {
			len=in.read(data);
		}
		System.out.println(len);
		System.out.println(new String(data)); //����Ʈ�迭�� ���ڿ��� ����
		
		FileOutputStream out=new FileOutputStream("f.txt");
		out.write(data);
		
		in.close();
		out.close();
	}

}
