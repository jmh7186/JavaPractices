package ex230419;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		Socket socket=new Socket("192.168.0.10",9999);
		
		if(!socket.isConnected()) {
			System.out.println("접속오류!!!");
			System.exit(0);
		}
		//소켓을 통해 입력되고 출력되는 통로를 미리 생성
		//BufferedReader in
		//=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		BufferedWriter out
		=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		
		System.out.println("클라이언트 프로그램 동작중!!!");
		while(true) {
			//서버에 요청
			System.out.println("가져올 데이터의 학번을 입력하세요.(종료:exit)");
			String id=(new Scanner(System.in)).nextLine();
			out.write(id+"\n");
			out.flush();
			//요청한 데이터를 수신
			ObjectInputStream obj=new ObjectInputStream(socket.getInputStream());
			Student s=(Student)obj.readObject();
			//수신된 데이터를 출력
			System.out.println(s.toString());
		}

	}

}
