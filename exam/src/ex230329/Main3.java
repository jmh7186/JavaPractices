package ex230329;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main3 {

	public static void main(String[] args) throws IOException {
		//BufferedInputStream bis=new BufferedInputStream(System.in);
		FileReader fr=new FileReader("data.txt");
		BufferedReader br=new BufferedReader(fr);
		/*
		System.out.println(br.readLine());
		System.out.println(br.readLine());
		System.out.println(br.readLine());
		System.out.println(br.readLine());
		System.out.println(br.readLine());
		System.out.println(br.readLine());
		*/
		//������ �Է¹޾� ������ ����ϴ� ����
		/*
		 String s;
		 
		while((s=br.readLine())!=null) {
			System.out.println(s);
		}
		*/
		//����.���پ� �������� ������ �����ؼ� �ѹ��� ����ϴ� ���α׷����ϼ���.
		String s;
		String data="";
		while((s=br.readLine())!=null) {
			data+="{"+s+"},"; //data=data+s
		}
		System.out.println(data);
		
		for(;(s=br.readLine())!=null;) {
			
		}
		
		

	}

}
