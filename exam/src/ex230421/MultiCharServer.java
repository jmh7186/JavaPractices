package ex230421;

import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

//1.Ŭ���̾�Ʈ �����ϸ� Ŭ���̾�Ʈ ������ ��� �����ϴ� �۾� ������ ����
//2.Ŭ���̾�Ʈ���� ������ �޽����� �޴� ������ ����(��������)
//3.Ŭ���̾�Ʈ���� ������ �޽����� ó���ϴ� ������ ����
//(������ ��� Ŭ���̾�Ʈ ���Ͽ� ������)
class MultiConnectionThread extends Thread{
	Socket[] client;
	int count;
	
	public MultiConnectionThread(int length) {
		client=new Socket[length];
	}
	
	@Override
	public void run() {
		try {
			ServerSocket server=new ServerSocket(9999);
			while(true) {
			System.out.println("���Ӵ����.....");
			client[count]=server.accept();
			System.out.println
			(client[count].getInetAddress()+"Ŭ���̾�Ʈ ����");
			count++; //������ �ɶ� ���� 1�� �����ϰ�
			//���ڴ� 0���� �����ϹǷ� count�� ���� ������ ���̸�
			//count���� ���� Ŭ���̾�Ʈ�� ��ü�� �����ϴ� ��ġ�� ��.
			System.out.println("���� �����ڼ�:"+count);
			//ȯ���޽���(192.168.0.69���� �����ϼ̽��ϴ�.)
			//for���� ����Ͽ� ���ӵ� client count��ŭ ������� 
			//�޽����� �� �������������� ������ ���ο� Ŭ���̾�Ʈ ������ �� ���� ���� �߻�
			//�̸� �ذ��ϱ� ���ؼ� ������ �۾��� ������ �ؾ���(thread)
			//������ �۾��� �� �� �ʿ��� ����(��üŬ���̾�Ʈ����, count)
			new MultiChatSendThread(client,count).start();
			}
		}catch(Exception e) {}
	}
}


class MultiChatSendThread extends Thread{
	Socket[] socket;
	int count;
	
	public MultiChatSendThread
	(Socket[] socket, int count) {
		this.socket=socket;
		this.count=count;
	}
	@Override
	public void run() {
		for(int i=0;i<count;i++) {
			try {
			DataOutputStream out
			=new DataOutputStream(socket[i].getOutputStream());
			out.writeUTF(socket[count].getInetAddress()+"���� �����ϼ̽��ϴ�.");
			out.flush();
			}catch (Exception e) {e.printStackTrace();}
		}
	
	}
}

public class MultiCharServer {

	public static void main(String[] args) {
		new MultiConnectionThread(100).start();

	}

}
