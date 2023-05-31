package ex230412;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Main4 {

	public static void main(String[] args) throws IOException {
		URL url=new URL("http://dwit.or.kr"); 
		//URL은 단순히 문자열(주소)을 관리하는 역할을 하는 클래스이다.
		System.out.println(url.getProtocol());
		System.out.println(url.getHost());
		System.out.println(url.getPort());
		System.out.println(url.getPath());
		URLConnection con=url.openConnection(); //주소문자열을 이용하여 사이트접속
		//사이트 접속을 했다는 의미는 연결이 되었다(통로가 만들어 졌다)
		InputStream in=con.getInputStream();  //서버에서 보내는 데이터를 받기 위한 통로
		//con.getOutputStream(); //서버쪽으로 데이터를 전송하기 위한 통로
		System.out.println(in.available());
		//System.out.println((char)in.read());
		while(true) {
			char c=(char)in.read();
			if(c<0) break;
			System.out.print(c);
		}
		System.out.println("시스템종료");
		
		
		
		
		
		

	}

}
