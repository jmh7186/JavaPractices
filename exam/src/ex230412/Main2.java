package ex230412;

import java.io.IOException;
import java.io.InputStream;

public class Main2 {

	public static void main(String[] args) throws IOException {
		InputStream in=new InputStream() {
			//source(keyboard���)
			//byte[] b= {1,2,3,4,5};
			byte[] b;
					
			int index=0;
			public int read() throws IOException {
				// TODO Auto-generated method stub
				return b[index++];
			}
		};
		
		//b�� �޸��̸� �����̸� ��Ʈ���� �޸��̴�. 
		//read()�Լ��� ȣ�������μ� ���ڰ� �޸𸮿��� ���������� ��ó�� ���̰� �ȴ�. 
		in.b[0]='a';
		in.b[1]='b';
		in.b[2]='c';
		
		
		System.out.println(in.read());
		System.out.println(in.read());
		System.out.println(in.read());
		

	}

}
