package ex230417;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket=new Socket("192.168.0.10",9999);
		//socket.connect(null);
		if(socket.isConnected()) {
			System.out.println("서버에 접속되었음.");
		}
		while(socket.isConnected()) {
		//data receive
		BufferedReader in
		=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String data=in.readLine(); //줄을 바꾸는 기호 "\n"
		System.out.println("서버에서 보내온 메시지:"+data);
		//data send
			
		}
		System.out.println("연결이 종료되었습니다.");

	}

}
