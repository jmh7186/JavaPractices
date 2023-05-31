package ex230327;

import java.io.IOException;

public class Main5 {
public static void main(String[] args) throws IOException {
	char a=(char)System.in.read();
	char aa=(char)System.in.read();
	System.out.println((char)System.in.read());
	System.out.println(System.in.read());
	System.out.println(System.in.read());
	System.out.println("a값:"+a);
	System.out.println("aa값:"+aa);
	//버퍼의 들어있는 내용이 몇개인지 확인하는 함수
	System.in.available();
}
	
	
}
