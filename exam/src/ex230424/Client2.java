package ex230424;

import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class Client2 {
	public static void main(String[] args) {
		
		try {
			Socket socket=new Socket("192.168.0.10",9999);
			ObjectOutputStream out
			=new ObjectOutputStream(socket.getOutputStream());
			Protocol data=new Protocol(1,"admin1234");
			out.writeObject(data);
			out.flush();
			//데이터전송시 시스템지연을 통해 데이터가 수신할 시간을 제공해야함.
			Thread.sleep(1000);//******************
			System.out.println("데이터전송완료");
		}catch(Exception e) {}
		

	}

}
