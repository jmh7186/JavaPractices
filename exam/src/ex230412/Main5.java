package ex230412;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main5 {

	public static void main(String[] args) throws IOException {
		//������ ��Ʈ��ũ ��ǻ�Ͱ��� �����͸� �̵��ϴ� ����̴�.
		//��PC(192.168.0.10)�� ��Ʈ��ũ���α׷�(��Ʈ80)�� ����δ� �����̴�.
		//��Ʈ��ũ ��ǻ���߿�(192.168.0.30)�� ��ǻ�Ͱ� ������ �ϱ����ؼ��� ���α׷��� �ʿ��ϰ�
		//�� ���α׷� ���� ������ �ʿ���. ������ �ʿ��ϴٴ� �ǹ̴� ��Ʈ�� �ʿ��ϴٴ� �ǹ�
		ServerSocket server=new ServerSocket(80);
		int i=0;
		while(true) {
		System.out.println("���� ���Ӵ����...... ");
		Socket client=server.accept();
		//�޸𸮿� ������ �����͸� �����
		String senddata=
		"HTTP/1.1 200 OK Content-Type:text/html;charset=utf-8\r\n\n";

		//������ �ִ� ������ ��� ���� �����͸� �̿��� ��� ��� �� ���ΰ�?
		//senddata+="<h1 style='color:green'>teacher com�� Ŭ���̾�Ʈ ����</h1>"+(i++);
		FileInputStream file=new FileInputStream("index.html");
		String fdata=new String(file.readAllBytes());
		senddata+=fdata;
		client.getOutputStream().write(senddata.getBytes());
		client.getOutputStream().flush();
		client.close();
		}
	}

}
