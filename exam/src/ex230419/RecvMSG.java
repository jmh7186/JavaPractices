package ex230419;

import java.io.DataInputStream;
import java.io.InputStream;

public class RecvMSG extends Thread{
	InputStream in;
	String kind;
	public RecvMSG(InputStream inputStream, String kind) {
		in=inputStream;
		this.kind=kind;
	}
	@Override
	public void run() {
		while(true) {
		try {
		DataInputStream recv=new DataInputStream(in);
		System.out.println(kind+":"+recv.readUTF());
		}catch(Exception e) {}
		}
	}

}
