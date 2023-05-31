package ex230421;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class LoginClient {

	public static void main(String[] args) {
		try {
		Socket socket=new Socket("192.168.0.10",9999);
		if(socket.isConnected()) System.out.println("서버에 접속 성공");
		else System.out.println("서버에 접속 실패");
		DataOutputStream out
		=new DataOutputStream(socket.getOutputStream());
		DataInputStream in
		=new DataInputStream(socket.getInputStream());
		/*
		 프로토콜 만들기
		 
		 인증요청 : 1 - 필요한 사항 (id(10), password(10))
		 로그아웃 : 2 - 로그아웃 성공하는 21, 실패하면 20
		 메시지 송신 : 3 - 메시지 길이는 무한이라고 가정함
		 메시지 수신 : 4
		 */
		
		//out.writeUTF("1admin     1234      ");
		while(true) {
		out.writeUTF(new Scanner(System.in).nextLine());
		out.flush();
		}
		
		//socket.close();
		}catch(Exception e) {}
	}

}
