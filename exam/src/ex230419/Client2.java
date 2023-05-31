package ex230419;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client2 {

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		Socket socket=new Socket("192.168.0.10",9999);
		
		if(!socket.isConnected()) {
			System.out.println("접속오류!!!");
			System.exit(0);
		}
		//소켓을 통해 입력되고 출력되는 통로를 미리 생성
		DataInputStream in
		=new DataInputStream(socket.getInputStream());
		DataOutputStream out
		=new DataOutputStream(socket.getOutputStream());
		
		System.out.println("클라이언트 프로그램 동작중!!!");
		//while(true) {
			//메뉴가 화면에 나타나도록 함.
			//서버에서 보내온 메뉴를 읽은 후 화면에 표시
		while(true) {
			System.out.println(in.readUTF());
			out.writeUTF(new Scanner(System.in).nextLine());
			out.flush();
		}
		

	}

}
