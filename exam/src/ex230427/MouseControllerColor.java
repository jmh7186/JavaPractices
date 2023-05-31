package ex230427;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MouseControllerColor {
	static boolean pstate = true;
	static int datax = 0;
	static int datay = 0;

	// static boolean sendstate=false;
	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		// "x:30 y:100"문자열을 데이터 소켓으로 전송
		// 데이터를 보내는 쪽으로 클라이언트 역할
		System.out.println("클라이언트");
		Socket socket = new Socket("192.168.0.30", 55000);
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		Frame f = new Frame("client");
		f.setBounds(100, 100, 400, 200);
		f.setBackground(Color.cyan);
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				pstate = false;
				System.exit(0);
			}
		});
		f.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
//			//System.out.println(e.getX()+" "+e.getY());
//				//datax=e.getX();
//				//datay=e.getY();
//				try {
//					out.write("x:"+e.getX()+" y:"+e.getY()+"\n");
//					out.flush();
//					Thread.sleep(10);
//				} catch (IOException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}//sendstate=true;
//				catch (InterruptedException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				try {
					out.write("x:" + e.getX() + " y:" + e.getY() + "\n");
					out.flush();
					Thread.sleep(10);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} // sendstate=true;
				catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		f.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(e.getButton());
				try {
					out.write(String.valueOf(e.getButton()) + "\n");
					out.flush();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		while (pstate) {
			// out.write("x:30 y:100\n");
			// if(sendstate) {
			// sendstate=false;
			// out.write("x:"+datax+" y:"+datay+"\n");
			// out.flush();
			// }
			// Thread.sleep(1000);
		}
		socket.shutdownOutput();
		socket.close();
		System.exit(0);
	}

}
