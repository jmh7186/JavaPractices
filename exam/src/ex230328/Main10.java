package ex230328;

//import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main10 {

	public static void main(String[] args) throws IOException {
		//h.txt���� 2����Ʈ�� �����͸� ������ �ͼ� 2����Ʈ�� i.txt�� ���� ��� ����
		FileReader in=new FileReader("h.txt");
		//System.out.println(in.read());
		//���ڸ� ���ڿ��� �ٲٴ� ���(����-����-���ڿ�)
		//System.out.println(String.valueOf((char)in.read()));
		FileWriter out=new FileWriter("g.txt");
		
		/*
		int data;
		while((data=in.read())!=-1) {
			//out.write(String.valueOf((char)data));
			out.write(data);
		}
		*/
		char[] buf=new char[100];
		in.read(buf);
		System.out.println(buf);
		
		//out.write(buf, 0, 2);
		
		//char[] -> ���ڿ��� �ٲٴ� ��� Ȯ��
		out.write(Stri	ng.valueOf(buf), 0, 1);
		
		in.close();
		out.close();
	}

}
