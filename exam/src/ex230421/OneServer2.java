package ex230421;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
//쓰레드의 목적 : 여러개의 작업을 동시에 수행하기 위해 필요함.
class ConnectionThread2 extends Thread{
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
		new SendThread2(client.getOutputStream()).start();
		new RecvThread2(client.getInputStream()).start();
		}catch(Exception e) {}
		
	}
}

class RecvThread2 extends Thread{
	InputStream is;
	public RecvThread2(InputStream is) {
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

class SendThread2 extends Thread{
	OutputStream os;
	public SendThread2(OutputStream os) {
		this.os=os;
	}
	@Override
	public void run() {
		//OutputStream os=null;
		DataOutputStream out=new DataOutputStream(os);
		
		while(true) {
			try {
				System.out.println("보낼메시지를 입력하세요.");
				String msg=new Scanner(System.in).nextLine();
				out.writeUTF(msg);
				out.flush();
			}
			catch(Exception e) {}
		}
	}
}
public class OneServer2 {

	public static void main(String[] args) {
		new ConnectionThread2().start();
	}

}
