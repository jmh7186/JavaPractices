package ex230419;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadServer {
public static void main(String[] args) throws IOException {
	ServerSocket server=new ServerSocket(9999);
	Socket[] client=new Socket[100];
	int count=0;
	SendMessage msg=new SendMessage(client, count);
	msg.start();
	
	while(true) {
	System.out.println("���� ���� �����.....");
	client[count]=server.accept();
	System.out.println(client[count].getInetAddress()+"����");
	count++;
	msg.setCount(count);
	}
}
}
