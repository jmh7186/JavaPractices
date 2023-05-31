package ex230427;

import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;

class MouseFrame3 extends Frame implements MouseMotionListener {
	int x;
	int y;

	public MouseFrame3() {
		setBounds(0, 0, 800, 600);
		setVisible(true);
		addMouseMotionListener(this);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// System.out.println(e);
		System.out.println(e.getX() + "," + e.getY());
		x = e.getX();
		y = e.getY();

	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}

public class Client2 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("192.168.0.30", 9999);
		if (!socket.isConnected()) {
			System.out.println("서버에 접속할 수 없습니다.");
			System.exit(0);
		}
		System.out.println("서버에 접속하였습니다.[클라이언트프로그램실행]");
		MouseFrame3 m = new MouseFrame3();
		int x = 0, y = 0, old_x = 0, old_y = 0;
		while (true) {
			x = m.getX();
			y = m.getY();

			if (!(x == old_x && y == old_y)) {

				byte[] data = new byte[8];

				byte[] imsi = ByteBuffer.allocate(4).putInt(x).array();
				System.arraycopy(imsi, 0, data, 0, 4);
				imsi = ByteBuffer.allocate(4).putInt(y).array();
				System.arraycopy(imsi, 0, data, 4, 4);

				socket.getOutputStream().write(data);
				socket.getOutputStream().flush();
				old_x = x;
				old_y = y;
			}
		}
		// System.out.println("클라이언트 전송완료");

	}

}
