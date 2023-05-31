package ex230421;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
//쓰레드의 목적 : 여러개의 작업을 동시에 수행하기 위해 필요함.
/*
class ConnectionThread extends Thread{
	@Override
	public void run() {
		// while(true) { } 한명에 접속을 받는 사항이므로 반복문이 필요없음
		try {
		ServerSocket server=new ServerSocket(9999);
		System.out.println("접속대기중.....");
		Socket client=server.accept();
		System.out.println("클라이언트 접속");
		//접속 후에 데이터를 보내고(SendThread), 
		//데이터 받는 작업(RecvThread)이 이루어지므로
		//이부분에서 클라이언트 소켓의 inputstream, outputstream을
		//쓰레드에서 넘기면서 작업을 실해야함.
		}catch(Exception e) {}
		
	}
}
*/
class RecvThread extends Thread{
	InputStream is;
	public RecvThread(InputStream is) {
		this.is=is;
	}
	@Override
	public void run() {
		//InputStream is=null;
		DataInputStream in=new DataInputStream(is);
		
		while(true) {
			try {System.out.println(in.readUTF());}
			catch(Exception e) {}
		}
	}
}

class SendThread extends Thread{
	OutputStream os;
	public SendThread(OutputStream os) {
		this.os=os;
	}
	@Override
	public void run() {
		while(true) {
			try {
				DataOutputStream out=new DataOutputStream(os);
				System.out.println("보낼메시지를 입력하세요.");
				String msg=new Scanner(System.in).nextLine();
				out.writeUTF(msg);
				out.flush();
			}
			catch(Exception e) {}
		}
	}
}
public class OneServer {

	public static void main(String[] args) {
		try {
			ServerSocket server=new ServerSocket(9999);
			System.out.println("접속대기중.....");
			Socket client=server.accept();
			System.out.println("클라이언트 접속");
			//클라이언트 소켓 생성 후 데이터 송수신이 같이 작업되어야함.
			new SendThread(client.getOutputStream()).start();
			new RecvThread(client.getInputStream()).start();
		}catch(Exception e) {}

	}

}
