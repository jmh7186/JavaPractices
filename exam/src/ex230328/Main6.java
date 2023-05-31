package ex230328;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class Main6 {

	public static void main(String[] args) throws IOException {
		//Main5에서 작성한 파일 중 한글처리부분에 대한 소스코드
		File f=new File("sungjuk.txt");
		System.out.println(f.exists());
		
		FileReader is=new FileReader(f);
		String s="";
		int data;
		while((data=is.read())!=-1) {
			s=s.concat(String.valueOf((char)data));
		}
		//System.out.print(s);
		//3.문자열을 분리하는 작업
		String[] read=s.split(" ");
		String name=read[0];
		int kor=Integer.parseInt(read[1]);
		int eng=Integer.parseInt(read[2]);
		int math=Integer.parseInt(read[3]);
		System.out.printf("%s님의 국어:%d 영어:%d 수학:%d 합계:%d 평균:%.2f 입니다.",
				name, kor, eng, math, (kor+eng+math),(float)(kor+eng+math)/3);
	}

}
