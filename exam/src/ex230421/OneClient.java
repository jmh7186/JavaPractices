package ex230421;

import java.net.ServerSocket;
import java.net.Socket;

public class OneClient {

	public static void main(String[] args) {
		try {
			Socket socket=new Socket("192.168.0.10",9999);
			if(socket.isConnected()) System.out.println("서버에 접속 성공");
			else System.out.println("서버에 접속 실패");
			//클라이언트 소켓 생성 후 데이터 송수신이 같이 작업되어야함.
			new SendThread(socket.getOutputStream()).start();
			new RecvThread(socket.getInputStream()).start();
		}catch(Exception e) {}

	}

}
