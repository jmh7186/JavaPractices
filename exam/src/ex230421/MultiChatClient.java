package ex230421;

import java.io.DataInputStream;
import java.net.Socket;

public class MultiChatClient {

	public static void main(String[] args) {
		try {
		Socket socket=new Socket("192.168.0.10",9999);
		DataInputStream in=new DataInputStream(socket.getInputStream());
		while(true) {
			System.out.println(in.readUTF());
		}
		}catch(Exception e) {}

	}

}
