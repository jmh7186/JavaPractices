package ex230420;

import java.awt.Label;
import java.io.DataInputStream;
import java.io.InputStream;

public class ClientRecvThread extends Thread{
	CClient client;
	public ClientRecvThread(CClient client) {
		this.client=client;
	}
	@Override
	public void run() {
		try {
		DataInputStream dis
		=new DataInputStream(client.socket.getInputStream());
				
			while(true) {
				String data=dis.readUTF()+"\r\n"+client.label.getText();
				client.label.setText(data);
				client.invalidate();

			}
		}catch(Exception e) {}
	}

}
