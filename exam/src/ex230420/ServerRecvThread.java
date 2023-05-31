package ex230420;

import java.awt.Label;
import java.io.DataInputStream;
import java.io.InputStream;

public class ServerRecvThread extends Thread{
	CServer server;
	public ServerRecvThread(CServer server) {
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
