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

public class Client2 {

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
		//data send
		//OutputStream os=socket.getOutputStream();
		//OutputStreamWriter osw=new OutputStreamWriter(os);
		//BufferedWriter out=new BufferedWriter(osw);
		BufferedWriter out
		=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		System.out.print("클라이언트에게 보낼 메시지:");
		out.write((new Scanner(System.in)).nextLine()+"\n");
		out.flush();
			
		}
		//System.out.println("연결이 종료되었습니다.");

	}

}
