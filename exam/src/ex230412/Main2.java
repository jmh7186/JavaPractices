package ex230412;

import java.io.IOException;
import java.io.InputStream;

public class Main2 {

	public static void main(String[] args) throws IOException {
		InputStream in=new InputStream() {
			//source(keyboard상상)
			//byte[] b= {1,2,3,4,5};
			byte[] b;
					
			int index=0;
			public int read() throws IOException {
				// TODO Auto-generated method stub
				return b[index++];
			}
		};
		
		//b는 메모리이며 버퍼이며 스트림의 메모리이다. 
		//read()함수를 호출함으로서 한자가 메모리에서 빠져나가는 것처럼 보이게 된다. 
		in.b[0]='a';
		in.b[1]='b';
		in.b[2]='c';
		
		
		System.out.println(in.read());
		System.out.println(in.read());
		System.out.println(in.read());
		

	}

}
