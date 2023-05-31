package ex230328;

import java.io.IOException;
import java.io.InputStream;

public class Main3 {

	public static void main(String[] args) throws IOException {
		//System.in.read();
		/*
		InputStream in=System.in;
		
		int a=in.read();
		System.out.println(a);
		*/
		/* 
		 * 문자열을 추가하는 방법
		String s="a";
		System.out.println(s);
		s=s+"b";
		System.out.println(s);
		*/
		
		//char를 문자열에 추가하는 방법
		char c='a';
		String s=String.valueOf(c);
		c='b';
		s=s+String.valueOf(c);
		System.out.println(s);
		
		//byte를 char변환
		byte b=97;
		System.out.println((char)b);
		
		//바이트 배열을 문자열로 변환
		byte[] bs= {97,98,99,100};
		System.out.println(new String(bs));
		
		//문자열을 바이트 변환하는 방법
		s="abcd";
		System.out.println(s.getBytes()[0]);
		byte[] bs1=s.getBytes();
		System.out.println(bs1[0]);
		
	}

}
