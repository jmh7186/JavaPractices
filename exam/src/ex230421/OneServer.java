package ex230421;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
//�������� ���� : �������� �۾��� ���ÿ� �����ϱ� ���� �ʿ���.
/*
class ConnectionThread extends Thread{
	@Override
	public void run() {
		// while(true) { } �Ѹ� ������ �޴� �����̹Ƿ� �ݺ����� �ʿ����
		try {
		ServerSocket server=new ServerSocket(9999);
		System.out.println("���Ӵ����.....");
		Socket client=server.accept();
		System.out.println("Ŭ���̾�Ʈ ����");
		//���� �Ŀ� �����͸� ������(SendThread), 
		//������ �޴� �۾�(RecvThread)�� �̷�����Ƿ�
		//�̺κп��� Ŭ���̾�Ʈ ������ inputstream, outputstream��
		//�����忡�� �ѱ�鼭 �۾��� ���ؾ���.
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
				System.out.println("�����޽����� �Է��ϼ���.");
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
			System.out.println("���Ӵ����.....");
			Socket client=server.accept();
			System.out.println("Ŭ���̾�Ʈ ����");
			//Ŭ���̾�Ʈ ���� ���� �� ������ �ۼ����� ���� �۾��Ǿ����.
			new SendThread(client.getOutputStream()).start();
			new RecvThread(client.getInputStream()).start();
		}catch(Exception e) {}

	}

}
