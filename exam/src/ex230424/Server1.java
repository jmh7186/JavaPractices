package ex230424;

import java.io.DataInputStream;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class Server1 {

	public static void main(String[] args) {
		try {
			System.out.println("서버실행 ");

			ServerSocket server=new ServerSocket(9999);
			Socket client=server.accept();
			if(client.isConnected()) {
				System.out.println("클라이언트 접속");
			}
			DataInputStream in
			=new DataInputStream(client.getInputStream());
			//byte[] data=new byte[100];
			//byte[]  data=in.readAllBytes(); //오류발생
			//첫번째방법
			byte[] data=in.readNBytes(100); //몇바이트가 전송되는지 확인을 해야함
			
			//두번째 방법
			//byte[] data=new byte[100];
			//int len=in.read(data);
			//System.out.println(len);
			
			System.out.println(Arrays.toString(data));
			
			int protocol=data[0];
			byte[] imsi=new byte[100];
			System.arraycopy(data, 10, imsi, 0, 10);
			String id=new String(imsi).trim();
			
			Array.setByte(imsi, 0, (byte) 0);
			System.arraycopy(data, 20, imsi, 0, 10);
			String pass=new String(imsi).trim();;
			
			System.out.println("protocol:"+protocol);
			System.out.println("id:"+id);
			System.out.println("password:"+pass);
			System.out.println("서버종료");
		}catch(Exception e) {e.printStackTrace();}

	}

}
