package ex230328;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class Main5 {

	public static void main(String[] args) throws IOException {
		//File에 sungjuk.txt를 만들고
		//파일 내용은 "홍길동 10 20 30" 으로 기록한다.
		//파일에서 변수로 각각의 내용을 분리하시오.(문자열분리)
		// 숫자는 별도로 int kor, eng, math에 저장하는 프로그램을 작성하시오.
		//1.파일을 오픈
		File f=new File("sungjuk.txt");
		System.out.println(f.exists());
		//FileReader is=new FileReader(f);
		//2.데이터흐름->메모리가는 데이터 흐름
		FileInputStream is=new FileInputStream(f);
		String s="";
		while(is.available()>0) {
			//System.out.print((char)is.read());
			//System.out.println(String.valueOf((char)is.read()));
			//한문자를 문자열로 누적시키는 작업
			s=s.concat(String.valueOf((char)is.read()));
			//s=s+String.valueOf((char)is.read());
			//System.out.println(s);
		}
		System.out.print(s);
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
