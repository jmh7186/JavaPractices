package ex230328;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main9 {

	public static void main(String[] args) throws IOException {
		//f.txt���� 1����Ʈ�� �����͸� ������ �ͼ� 1����Ʈ�� g.txt�� ���� ��� ����
		FileInputStream in=new FileInputStream("f.txt");
		FileOutputStream out=new FileOutputStream("g.txt");
		
		int data;
		
		while((data=in.read())!=-1) {
			out.write(data);
		}
		
		in.close();
		out.close();
		
		
	}

}
