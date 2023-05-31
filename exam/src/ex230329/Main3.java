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
		//한줄을 입력받아 한줄을 출력하는 형태
		/*
		 String s;
		 
		while((s=br.readLine())!=null) {
			System.out.println(s);
		}
		*/
		//문제.한줄씩 받지말고 한줄을 누적해서 한번에 출력하는 프로그래밍하세요.
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
