package ex230419;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class SendMessage extends Thread{
	Socket[] client;
	int count;
	
	public SendMessage(Socket[] client, int count) {
		this.client=client;
		this.count=count;
	}
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
		System.out.println(count);
	}



	@Override
	public void run() {
		System.out.println("보낼 데이터를 입력하세요.");
		String data=new Scanner(System.in).nextLine()+"\n";
		for(int i=0;i<count;i++) {
			try {
			BufferedWriter out=
			new BufferedWriter(
					new OutputStreamWriter(
							client[i].getOutputStream()));
			out.write(data);
			out.flush();
			//out.close();
			}catch(Exception e) {e.printStackTrace();}
		}
	}

}
