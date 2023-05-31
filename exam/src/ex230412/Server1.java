package ex230412;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {

	public static void main(String[] args) throws IOException {
		ServerSocket server=new ServerSocket(5555);
		System.out.println("서버프로그램 시작");
		Socket client=server.accept();//대기
		System.out.println(client.getInetAddress()+"클라이언트가 접속하였습니다.");
		//데이터 전송
		
		client.close();
		server.close();

	}

}
