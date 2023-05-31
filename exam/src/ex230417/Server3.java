package ex230417;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server3 {

	public static void main(String[] args) throws IOException {
		ServerSocket server=new ServerSocket(9999); 
		System.out.println("서버프로그램 실행중...(접속대기)");
		Socket client=server.accept();
		System.out.println("서버에 클라이언트 접속함");
		
		while(true) {
			//data send
			BufferedWriter out
			=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			System.out.print("클라이언트에게 보낼 메시지:");
			//성적프로그램에서 데이터 형태
			//학번 이름 국어 영어 수학
			//"20000101 홍길동 100 90 80"
			String id="20000101";
			String name="홍길동";
			int kor=100; int eng=90; int math=80;
			//String sdata=id+" "+name+" "+kor+" "+eng+" "+math+"\n";
			
			StringBuffer buf=new StringBuffer();
			buf.append(id);buf.append(" ");
			buf.append(name);buf.append(" ");
			buf.append(kor);buf.append(" ");
			buf.append(eng);buf.append(" ");
			buf.append(math);buf.append("\n");
			
			out.write(buf.toString());
			out.flush();
			//data recevice
			BufferedReader in
			=new BufferedReader(new InputStreamReader(client.getInputStream()));
			String data=in.readLine();
			System.out.println("클라이언트에서 보내온 메시지:"+data);
		}
		//System.out.println("클라이언트 소켓 연결 해제되었음.");
		

	}

}
//이 프로그램의 개선사항
/*
종료문제
반이중주상태(무전기), 양방향상태로 챗팅 안됨.
접속이 1:1통신만 되는 상태, 다대다통신 구현.
반드시 필요한 사항 : 쓰레드 구현
*/


