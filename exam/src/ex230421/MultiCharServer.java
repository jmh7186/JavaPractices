package ex230421;

import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

//1.클라이언트 접속하면 클라이언트 소켓을 계속 생성하는 작업 쓰레드 생성
//2.클라이언트에서 보내온 메시지를 받는 쓰레는 생성(개별생성)
//3.클라이언트에게 보내는 메시지를 처리하는 쓰레드 생성
//(생성된 모든 클라이언트 소켓에 보내기)
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
			System.out.println("접속대기중.....");
			client[count]=server.accept();
			System.out.println
			(client[count].getInetAddress()+"클라이언트 접속");
			count++; //접속이 될때 마다 1이 증가하고
			//숫자는 0부터 시작하므로 count는 현재 접속자 수이며
			//count값을 다음 클라이언트의 객체를 생성하는 위치가 됨.
			System.out.println("현재 접속자수:"+count);
			//환영메시지(192.168.0.69님이 입장하셨습니다.)
			//for문을 사용하여 접속된 client count만큼 보낼경우 
			//메시지를 다 보내기전까지는 서버에 새로운 클라이언트 접속할 수 없는 문제 발생
			//이를 해결하기 위해서 별도의 작업을 실행을 해야함(thread)
			//보내는 작업을 할 때 필요한 사항(전체클라이언트소켓, count)
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
			out.writeUTF(socket[count].getInetAddress()+"님이 입장하셨습니다.");
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
