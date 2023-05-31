package ex230412;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main3 {

	public static void main(String[] args) throws IOException {
		//연속적인 바이트를 inputstream통로에 값을 넣는다.(통로로 입력)
		//이 스트림에 필요로 하는 것은 byte의 연속적인 값이다.
		byte[] data= {1,2,3,4,5};
		ByteArrayInputStream bi=new ByteArrayInputStream(data);
		System.out.print(bi.read());
		System.out.print(bi.read());
		System.out.print(bi.available());
		
		//연속적인 바이트를 입력받는 outputstream통로를 만든다.(입력은 되지만 나가는 방향임)
		//연속적인 바이트를 통로에 입력하면 연속적인 바이트가 통로에 입력되어 다시 출력되는 형태
		ByteArrayOutputStream bo=new ByteArrayOutputStream();
		//통로를 만들어 다시 연속적인 바이트를 받을 수 있는 상태
		bo.write(data); //통로에 연속적인 바이트로 입력하는 상태
		//bo는 통로를 가지고 있으며 안에는 연속적인 바이트를 간직하고 있다.
		//이데이터를 밖으로 빼기 위해서는 bo객체(출력스트림)를 활용하면 됨.
		System.out.println(bo.size());
		System.out.println(bo.toByteArray()[2]);
		for(byte b:bo.toByteArray()) {
			System.out.print(b);
		}
		
		//FileInputStream, FileOutputStream
		//파일로부터 데이터를 읽어와 통로에 값을 넣는 형태
		FileInputStream fi=new FileInputStream("data.txt");
		//입력되는 데이터는 아직 정해지지 않았지만
		//dataout.txt라는 파일에 통로를 이용하여 쓰는 작업
		FileOutputStream fo=new FileOutputStream("dataout.txt"); 
		
		
		
		
		
		

	}

}
