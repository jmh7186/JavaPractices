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
		 * ���ڿ��� �߰��ϴ� ���
		String s="a";
		System.out.println(s);
		s=s+"b";
		System.out.println(s);
		*/
		
		//char�� ���ڿ��� �߰��ϴ� ���
		char c='a';
		String s=String.valueOf(c);
		c='b';
		s=s+String.valueOf(c);
		System.out.println(s);
		
		//byte�� char��ȯ
		byte b=97;
		System.out.println((char)b);
		
		//����Ʈ �迭�� ���ڿ��� ��ȯ
		byte[] bs= {97,98,99,100};
		System.out.println(new String(bs));
		
		//���ڿ��� ����Ʈ ��ȯ�ϴ� ���
		s="abcd";
		System.out.println(s.getBytes()[0]);
		byte[] bs1=s.getBytes();
		System.out.println(bs1[0]);
		
	}

}
