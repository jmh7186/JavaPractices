package ex230328;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main9 {

	public static void main(String[] args) throws IOException {
		//f.txt에서 1바이트의 데이터를 가지고 와성 1바이트를 g.txt에 쓰는 방식 구현
		FileInputStream in=new FileInputStream("f.txt");
		FileOutputStream out=new FileOutputStream("g.txt");
		
		int data;
		
		while((data=in.read())!=-1) {
			out.write(data);
		}
		
		in.close();
		out.close();
		
		
	}

}
