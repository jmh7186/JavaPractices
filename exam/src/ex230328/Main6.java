package ex230328;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class Main6 {

	public static void main(String[] args) throws IOException {
		//Main5���� �ۼ��� ���� �� �ѱ�ó���κп� ���� �ҽ��ڵ�
		File f=new File("sungjuk.txt");
		System.out.println(f.exists());
		
		FileReader is=new FileReader(f);
		String s="";
		int data;
		while((data=is.read())!=-1) {
			s=s.concat(String.valueOf((char)data));
		}
		//System.out.print(s);
		//3.���ڿ��� �и��ϴ� �۾�
		String[] read=s.split(" ");
		String name=read[0];
		int kor=Integer.parseInt(read[1]);
		int eng=Integer.parseInt(read[2]);
		int math=Integer.parseInt(read[3]);
		System.out.printf("%s���� ����:%d ����:%d ����:%d �հ�:%d ���:%.2f �Դϴ�.",
				name, kor, eng, math, (kor+eng+math),(float)(kor+eng+math)/3);
	}

}
