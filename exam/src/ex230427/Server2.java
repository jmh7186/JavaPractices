package ex230427;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;

public class Server2 {

	public static void main(String[] args) throws IOException, AWTException {
		Robot robot=new Robot();
		ServerSocket server=new ServerSocket(9999);
		Socket client=server.accept();
		if(!client.isConnected()) {
			System.out.println("Ŭ���̾�Ʈ ����");
			System.exit(0);
		}
		System.out.println("Ŭ���̾�Ʈ ����");
		
		//������ �����͸� �迭�� �Է�
		byte[] data=new byte[8];
		while(true) {
		client.getInputStream().read(data);
		
		//x,y���� ������ ��ȯ
		byte[] imsi=new byte[4];
		System.arraycopy(data, 0, imsi, 0, 4);
		ByteBuffer wrap1=ByteBuffer.wrap(imsi);
		int x=wrap1.getInt();
		System.out.println(x);
		
		System.arraycopy(data, 4, imsi, 0, 4);
		ByteBuffer wrap2=ByteBuffer.wrap(imsi);
		int y=wrap2.getInt();
		System.out.println(y);
		robot.mouseMove(x,y);
		}
		
	}

}
