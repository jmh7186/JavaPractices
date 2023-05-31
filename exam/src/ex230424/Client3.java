package ex230424;

import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class Client3 {
	public static void main(String[] args) {
		
		try {
			Socket socket=new Socket("192.168.0.10",9999);
			
			ObjectOutputStream out
			=new ObjectOutputStream(socket.getOutputStream());
			
			//전송할 데이터는 저장할 클래스
			NewProtocol data=new NewProtocol();
			//각각의 문자열을 byte배열에 입력해줌 
			String id="admin";
			String pass="1234";
			//int len=id.length()+pass.length();
			
			System.arraycopy
			(id.getBytes(),0, data.packet, 0, id.length());
			System.arraycopy
			(pass.getBytes(),0, data.packet, 10, pass.length());
			
						
			out.writeObject(data);
			out.flush();
			//데이터전송시 시스템지연을 통해 데이터가 수신할 시간을 제공해야함.
			Thread.sleep(1000);//******************
			System.out.println("데이터전송완료");
		}catch(Exception e) {}
		

	}

}
