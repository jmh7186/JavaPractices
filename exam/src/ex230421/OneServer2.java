package ex230421;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
//�������� ���� : �������� �۾��� ���ÿ� �����ϱ� ���� �ʿ���.
class ConnectionThread2 extends Thread{
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
				System.out.println("�����޽����� �Է��ϼ���.");
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
