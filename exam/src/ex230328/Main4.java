package ex230328;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main4 {

	public static void main(String[] args) throws IOException {
		//��Ű��, src�� �⺻��� �ƴϸ� ������Ʈ���� �ִ� ������ �⺻�����
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
		
		// ��Ʈ���� ���� �о�� ������ Ȯ���ϴ� ù��° ���
		/*
		while(fis.available()>0) {
			System.out.print((char)fis.read());
		}
		*/
		
		//2)�ι�° ���
		/*
		while(true) {
			int c=fis.read();
			if(c==-1) break;
			System.out.print((char)c);
		}
		*/
		
		//3)String ������ ���Ͽ� �ִ� ������ ��� �����ϰ� �ݺ����� ���� �� ���
		String s="";
		while(true) {
			int c=fis.read();
			if(c==-1) break;
			s=s+String.valueOf((char)c); //int���� ���ڿ��� �ٲٴ� ���
		}
		System.out.println("s:"+s);
		
		//�����̽� �����Ͽ� �ܾ�� �и��Ͻÿ�.
		String[] ss=s.split(" ");
		System.out.println(ss[0]);
		System.out.println(ss[1]);
		System.out.println(ss[2]);
		
		//for���� �̿��Ͽ� ó��
		for(int i=0;i<ss.length;i++) {
			System.out.println(ss[i]);
		}
		
		for(String imsi: ss) {
			System.out.println(imsi);
		}
		
		}

}
