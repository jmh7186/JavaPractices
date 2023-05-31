package ex230328;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Main7 {

	public static void main(String[] args) throws IOException {
		//데이터의 기본 흐름은 Stream
		//방향이 존재하여 메모리가 기준이 된다.
		//출발지에서 메모리방향으로 데이터가 흐를 때 : InputStream
		//메모리에서 도착지 방향으로 데이터가 흐를 때 : OutputStream
		
		System.in.read();
		//위의 코드는 출발지 목적지가 나타나 있음
		//출발지는 System.in(키보드 입력), 도착지 메모리(read())
		
		byte[] data= {97,98,99};
		System.out.write(data);
		//System.out(목적지, 모니터), write(메모리->모니터(메모리주소))
		
		//1바이트를 메모리 입력한다.(한글지원x)
		//inputstream, outputstream
		byte[] bytes = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
		InputStream is=new InputStream() {	
			@Override
			public int read() throws IOException {
				return 0;
			}
		};
		
		OutputStream os=new OutputStream() {
			@Override
			public void write(int b) throws IOException {
			
			}
		};
		
		FileInputStream fis=new FileInputStream(new File("a.txt"));
		FileOutputStream fos=new FileOutputStream(new File("a.txt"));
		//fileinputstream에서 file은 출발지(파일에서 데이터가 나와서 메모리에 입력(inputstream))
		//fileoutputstream에서 file은 목적지(메모리에서 데이터가 나와서 파일에 출력(outputstream))		
		
		//2바이트를 메모리 입력한다.(한글지원)
		//Reader, Writer
		//FileReader는 File이 출발지 메모리로 Reader(읽는다)한다.
		//FileWriter는 File이 목적지 메모리에서 파일로 Writer(쓴다) 한다.

	}

}
