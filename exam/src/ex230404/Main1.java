package ex230404;

import java.util.Arrays;

public class Main1 {

	public static void main(String[] args) {
		// int-byte
		/*
		int jumsu=100;
		byte b=(byte) jumsu;
		System.out.println(b);
		System.out.println(Integer.toBinaryString(b));
		System.out.println(Integer.toBinaryString(jumsu));
		*/
		
		String s="abc123";
		byte[] b1=s.getBytes();
		for(byte b:b1) {
			System.out.println(b);
		}
		String s1=b1.toString();
		System.out.println(s1);
		//byte[] -> String
		String s2=new String(b1);
		System.out.println(s2);
		
		//byte[] b2= {0x66,0x67,0x68}; //16진수
		//byte[] b2= {'f','g','h'}; //char
		byte[] b2= {102,103,104}; //10진수
		System.out.println(new String(b2));
		
		byte[] b3= {0x66,0x67,0x68,0x69};
		System.out.println(new String(b3));
		String s3=Arrays.toString(b3); //배열에 있는 10진수를 문자화시키는 작업
		System.out.println(s3);
		System.out.println(s3.charAt(0));
		System.out.println(s3.charAt(1));
		System.out.println(s3.charAt(2));
		
		String ip="255.168.0.1"; //->4byte 11000000 . 1
		String[] buf=ip.split("\\."); // .은 정규식 표현을 사용해야함.
		System.out.println(buf.length);
		System.out.println(buf[0]);
		System.out.println(Integer.parseInt(buf[0]));
		System.out.println(Integer.toBinaryString(Integer.parseInt(buf[0])));
		byte[] b4=new byte[4];
		b4[0]=(byte) Integer.parseInt(buf[0]);
	}

}
