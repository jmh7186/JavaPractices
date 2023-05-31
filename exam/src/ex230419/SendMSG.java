package ex230419;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class SendMSG extends Thread{
	OutputStream out;
	public SendMSG(OutputStream outputStream) {
		out=outputStream;
	}
	@Override
	public void run() {
		while(true) {
		DataOutputStream send=new DataOutputStream(out);
		try {
		send.writeUTF(new Scanner(System.in).nextLine());
		send.flush();
		}catch(Exception e) {}
		}
	}
}
