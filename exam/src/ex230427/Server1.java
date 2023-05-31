package ex230427;

import java.awt.Robot;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;

public class Server1 {

	public static void main(String[] args) {
		try {
			ServerSocket socket = new ServerSocket(9999);
			Socket client = socket.accept();
			if(client.isConnected()) System.out.println("클라이언트 접속: "+client.getInetAddress());
			ByteBuffer wrap = ByteBuffer.wrap(b);
			
			
			byte[] arraysu = new byte[4];
			
			System.arraycopy(arrayb,0,arraysu,0,4);
			wrap = ByteBuffer.wrap(arraysu);
			int x=wrap.getInt();
			System.out.println(x);
			
			System.arraycopy(arrayb,4,arraysu,0,4);
			wrap = ByteBuffer.wrap(arraysu);
			int y=wrap.getInt();
			System.out.println(y);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
