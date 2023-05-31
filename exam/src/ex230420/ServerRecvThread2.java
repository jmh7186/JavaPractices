package ex230420;

import java.awt.Label;
import java.io.DataInputStream;
import java.io.InputStream;

public class ServerRecvThread2 extends Thread{
	CServer2 server;
	public ServerRecvThread2(CServer2 server) {
		this.server=server;
	}
	@Override
	public void run() {
		try {
		DataInputStream dis
		=new DataInputStream(server.client.getInputStream());
				
			while(true) {
			
				String data=dis.readUTF()+"\r\n"+server.label.getText();
				server.label.setText(data);
				server.invalidate();
			}
		}catch(Exception e) {}
	}

}
