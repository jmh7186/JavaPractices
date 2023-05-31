package ex230412;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client2 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		//System.out.println("서버에 접속할 주소를 입력하세요.");
		//String ip=new Scanner(System.in).nextLine();
		//int port=new Scanner(System.in).nextInt();
		
		Socket socket=new Socket("192.168.0.10", 5555);
		//Socket socket=new Socket(ip, port);
		//데이터전송 경로 만들어줌
		InputStream in=socket.getInputStream();
		OutputStream out=socket.getOutputStream();
		byte[] data=new byte[1024];
		in.read(data);
		System.out.print("서버에서 온 메시지:");
		System.out.println(new String(data));
		
		socket.close();
	}

}
