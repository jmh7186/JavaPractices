package ex230328;

//import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main10 {

	public static void main(String[] args) throws IOException {
		//h.txt에서 2바이트의 데이터를 가지고 와서 2바이트를 i.txt에 쓰는 방식 구현
		FileReader in=new FileReader("h.txt");
		//System.out.println(in.read());
		//숫자를 문자열로 바꾸는 방법(숫자-문자-문자열)
		//System.out.println(String.valueOf((char)in.read()));
		FileWriter out=new FileWriter("g.txt");
		
		/*
		int data;
		while((data=in.read())!=-1) {
			//out.write(String.valueOf((char)data));
			out.write(data);
		}
		*/
		char[] buf=new char[100];
		in.read(buf);
		System.out.println(buf);
		
		//out.write(buf, 0, 2);
		
		//char[] -> 문자열을 바꾸는 방법 확인
		out.write(Stri	ng.valueOf(buf), 0, 1);
		
		in.close();
		out.close();
	}

}
