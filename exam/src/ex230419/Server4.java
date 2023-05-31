package ex230419;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server4 {

	public static void main(String[] args) throws IOException {
		//아래의 기능을 분류하세요. 
		/*
		1)접속(소켓생성) -> main()함수
		2)메시지 보내는 기능(송신) -> SendMSG class
		3)메시지 받는 기능(수신) ->RecvMSG class
		*/
		ServerSocket server=new ServerSocket(9999);
		System.out.println("서버대기중.....");
		Socket client=server.accept();
		System.out.println(client.getInetAddress()+":챗팅서버시작.....");
		//메시지를 보내고 받을 때 꼭 필요한 사항
		SendMSG send=new SendMSG(client.getOutputStream());
		RecvMSG recv=new RecvMSG(client.getInputStream(),"클라이언트");
		send.start();
		recv.start();

	}

}
