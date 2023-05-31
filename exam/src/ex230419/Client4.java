package ex230419;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client4 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket=new Socket("192.168.0.10",9999);
		
		if(!socket.isConnected()) {
			System.out.println("접속오류!!!");
			System.exit(0);
		}
		System.out.println("클라이언트 시작");
		//메시지를 보내고 받을 때 꼭 필요한 사항
		SendMSG send=new SendMSG(socket.getOutputStream());
		RecvMSG recv=new RecvMSG(socket.getInputStream(),"서버");
		send.start();
		recv.start();

	}

}
