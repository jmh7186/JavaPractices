package ex230328;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main8 {

	public static void main(String[] args) throws IOException {
		//메모리(변수)에 있는 내용을 파일에 기록하는 것을 의미함 
		//File로 객체를 생성할 경우 파일이 존재하지 않으면 자동으로 생성이 안됨.
		//하지만 파일스트림에 입력값으로 파일명만 적으면 파일이 없을 경우 자동 생성
		/*
		FileOutputStream fos=new FileOutputStream("c.txt");
		fos.write(97);
		fos.write('b');
		//fos.write({99,100,101,102}); //오류발생
		byte[] data={99,100,101,102};
		fos.write(data);
		//문자열을 입력받아 c.txt에 값을 입력하세요.
		//문자열->바이트배열->write
		Scanner scan=new Scanner(System.in);
		String s=scan.nextLine();
		fos.write(s.getBytes());
		
		fos.flush();
		fos.close();
		*/
		//File(e.txt) -> memory -> File(f.txt)
		//File로 부터 메모리로 가져올 때(FileInputStream)
		FileInputStream in=new FileInputStream("e.txt");
		//System.out.println((char)in.read());//확인
		//데이터처리방식-> 1바이트씩 옮기는 작업, 한번에 받아서 옮기는 작업
		byte[] data=new byte[100];
		int len=0;
		if(in.available()>0) {
			len=in.read(data);
		}
		System.out.println(len);
		System.out.println(new String(data)); //바이트배열을 문자열로 변경
		
		FileOutputStream out=new FileOutputStream("f.txt");
		out.write(data);
		
		in.close();
		out.close();
	}

}
