package ex230412;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Main4 {

	public static void main(String[] args) throws IOException {
		URL url=new URL("http://dwit.or.kr"); 
		//URL�� �ܼ��� ���ڿ�(�ּ�)�� �����ϴ� ������ �ϴ� Ŭ�����̴�.
		System.out.println(url.getProtocol());
		System.out.println(url.getHost());
		System.out.println(url.getPort());
		System.out.println(url.getPath());
		URLConnection con=url.openConnection(); //�ּҹ��ڿ��� �̿��Ͽ� ����Ʈ����
		//����Ʈ ������ �ߴٴ� �ǹ̴� ������ �Ǿ���(��ΰ� ����� ����)
		InputStream in=con.getInputStream();  //�������� ������ �����͸� �ޱ� ���� ���
		//con.getOutputStream(); //���������� �����͸� �����ϱ� ���� ���
		System.out.println(in.available());
		//System.out.println((char)in.read());
		while(true) {
			char c=(char)in.read();
			if(c<0) break;
			System.out.print(c);
		}
		System.out.println("�ý�������");
		
		
		
		
		
		

	}

}
