package ex230418;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client2 {
	public static void main(String[] args) throws UnknownHostException, IOException {
	Socket socket=new Socket("192.168.0.10",9999);
	System.out.println("클라이언트 프로그램");
	while(true) {
		System.out.println("가져올 데이터의 학번을 입력하세요.(종료:exit)");
		String _id=(new Scanner(System.in)).nextLine();
				
		BufferedWriter out
		=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		out.write(_id+"\n");
		out.flush();
		
		if(_id.equals("exit")) {
			break;
		}
		
		BufferedReader in
		=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String[] data=in.readLine().split(" ");
		String id=data[0];
		String name=data[1];
		int kor=Integer.parseInt(data[2]);
		int eng=Integer.parseInt(data[3]);
		int math=Integer.parseInt(data[4]);
		int total=kor+eng+math;
		float avg=(float)total/3;
		System.out.println("-----------------------------");
		System.out.println("학번     :  "+id);
		System.out.println("이름     :  "+name);
		System.out.printf
		("성적:%d(국어) %d(영어) %d(수학) %d(합계) %.2f(평균)\n"
				,kor, eng, math, total, avg);
		System.out.println("-----------------------------");	
	}
	
	socket.close();
	System.out.println("클라이언트 프로그램 종료");
	}
	
}
