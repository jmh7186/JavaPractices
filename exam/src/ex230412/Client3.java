package ex230412;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client3 {

	public static void main(String[] args) throws UnknownHostException, IOException {
				
		Socket socket=new Socket("192.168.0.10", 5555);
		
		//데이터전송 경로 만들어줌
		InputStream in=socket.getInputStream();
		OutputStream out=socket.getOutputStream();
		
		//서버->클라이언트가 받아 처리
		byte[] data=new byte[1024];
		in.read(data);
		System.out.print("서버에서 온 메시지:");
		System.out.println(new String(data));
		
		//클라이언트->서버에게 데이터를 보내야함.
		//out.write("hello server".getBytes()); //보내는 데이터가 고정
		//out.flush();
		
		//1.변수에 있는 값으로 보내는 방법(서버에게 전송)->서버에서는 클라이언트 결과출력
		//String senddata="hello server";
		//out.write(senddata.getBytes()); //보내는 데이터가 고정
		//out.flush();
		
		//2.키보드를 부터 입력받아 보내는 방법->서버에서는 클라이언트 결과출력(변수에 저장)
		//String senddata=new Scanner(System.in).nextLine();
		//out.write(senddata.getBytes()); //보내는 데이터가 고정
		//out.flush();
		
		//3.파일로부터 데이터를 가지고 와서 보내는 방법->서버에서는 클라이언트 결과출력(파일에 저장)
		FileInputStream file=new FileInputStream("a.txt"); 
		String senddata=new String(file.readAllBytes());
		out.write(senddata.getBytes()); //보내는 데이터가 고정
		out.flush();
		
		
	}

}
