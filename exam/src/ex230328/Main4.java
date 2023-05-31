package ex230328;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main4 {

	public static void main(String[] args) throws IOException {
		//패키지, src가 기본경로 아니며 프로젝트명이 있는 파일이 기본경로임
		//File f=new File("a.txt");
		File f=new File("C:\\Users\\admin\\eclipse-workspace\\exam\\src\\ex230328\\b.txt");
		System.out.println(f.exists());
		
		FileInputStream fis=new FileInputStream(f);
		/*
		System.out.println((char)fis.read());
		System.out.println((char)fis.read());
		System.out.println((char)fis.read());
		System.out.println((char)fis.read());
		System.out.println((char)fis.read());
		System.out.println(fis.read());
		*/
		
		//System.out.println(fis.available());
		
		// 스트림을 통해 읽어온 내용을 확인하는 첫번째 방법
		/*
		while(fis.available()>0) {
			System.out.print((char)fis.read());
		}
		*/
		
		//2)두번째 방법
		/*
		while(true) {
			int c=fis.read();
			if(c==-1) break;
			System.out.print((char)c);
		}
		*/
		
		//3)String 변수에 파일에 있는 내용을 모두 저장하고 반복문이 끝난 후 출력
		String s="";
		while(true) {
			int c=fis.read();
			if(c==-1) break;
			s=s+String.valueOf((char)c); //int형을 문자열로 바꾸는 방법
		}
		System.out.println("s:"+s);
		
		//스페이스 구분하여 단어로 분리하시오.
		String[] ss=s.split(" ");
		System.out.println(ss[0]);
		System.out.println(ss[1]);
		System.out.println(ss[2]);
		
		//for문을 이용하여 처리
		for(int i=0;i<ss.length;i++) {
			System.out.println(ss[i]);
		}
		
		for(String imsi: ss) {
			System.out.println(imsi);
		}
		
		}

}
