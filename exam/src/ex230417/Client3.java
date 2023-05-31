package ex230417;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client3 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket=new Socket("192.168.0.10",9999);
		//socket.connect(null);
		if(socket.isConnected()) {
			System.out.println("서버에 접속되었음.");
		}
		while(true) {
		//data receive
		BufferedReader in
		=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String data=in.readLine(); //줄을 바꾸는 기호 "\n"
		System.out.println("서버에서 보내온 메시지:"+data);
		String[] buf=data.split(" ");
		String id=buf[0];
		String name=buf[1];
		int kor=Integer.parseInt(buf[2]);
		int eng=Integer.parseInt(buf[3]);
		int math=Integer.parseInt(buf[4]);
		System.out.printf("학번:%s 이름:%s\n",id, name);
		System.out.printf("국어:%d 영어:%d 수학:%d\n",kor,eng,math);
		System.out.printf("합계:%d 평균:%.2f\n",kor+eng+math,(float)(kor+eng+math)/3);
		//data send
		BufferedWriter out
		=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		System.out.print("클라이언트에게 보낼 메시지:");
		out.write((new Scanner(System.in)).nextLine()+"\n");
		out.flush();
			
		}
		//System.out.println("연결이 종료되었습니다.");

	}

}
