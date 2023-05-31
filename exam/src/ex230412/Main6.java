package ex230412;

import java.io.FileInputStream;
import java.io.IOException;

public class Main6 {

	public static void main(String[] args) throws IOException {
		FileInputStream file=new FileInputStream("index.html");
		//문제. index.html파일의 내용을 읽어와 문자열변수에 넣고 출력하시오.
		String fdata=new String(file.readAllBytes());
		System.out.println(fdata);
		
	}

}
