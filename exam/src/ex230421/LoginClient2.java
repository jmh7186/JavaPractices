package ex230421;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class LoginClient2 {

	public static void main(String[] args) {
		try {
			/*
		Socket socket=new Socket("192.168.0.10",9999);
		if(socket.isConnected()) System.out.println("서버에 접속 성공");
		else System.out.println("서버에 접속 실패");
		DataOutputStream out
		=new DataOutputStream(socket.getOutputStream());
		DataInputStream in
		=new DataInputStream(socket.getInputStream());
		*/
		String protocol="1";
		String id="admin";
		String password="5678";
		byte[] packet=new byte[100];
		//packet[0] : protocol
		//packet[1~10] : id
		//packet[11~20] : password
		packet[0]=protocol.getBytes()[0];
		//System.out.println((char)packet[0]);
		//System.out.println(id.getBytes().length);
		//바이트의 1~10까지길에 id바이트를 기록하는 방법을 찾으세요.
		byte[] b=id.getBytes();	//문자열->바이트
		
		for(int i=1;i<11;i++) {
			if(i<=b.length) packet[i]=b[i-1];
			else packet[i]=' ';
		}
		
		/*
		for(int i=1;i<=b.length;i++) {
			packet[i]=b[i-1];
		}
		*/
		System.out.println(new String(packet));
		
		byte[] pass=password.getBytes();
		System.out.println((char)pass[0]);
		for(int i=11;i<=(11+pass.length);i++) {
			packet[i]=pass[i-11];
		}
		System.out.println("check:"+(char)packet[11]);
		System.out.println(new String(packet));
		//System.out.println(new String(b)); //바이트->문자열
		//System.arraycopy(b, 0, packet, 1, 10);
		//System.out.println(packet[0]);
		//out.writeUTF();
		//out.flush();
		
		
		}catch(Exception e) {}
	}

}
