package ex230427;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class Main1 {

	public static void main(String[] args) {
		
		//정수를 4바이트데이터로 변환
		int su=128;
		//allocate(4)는 4자리 배열로 만들겠다는 의미
		byte[] arrayb=ByteBuffer.allocate(4).putInt(su).array();
		System.out.println(Arrays.toString(arrayb));
		System.out.println(arrayb.length);
		//4바이트 데이터를 정수로 변환
		ByteBuffer wrap=ByteBuffer.wrap(arrayb);
		su=wrap.getInt();
		System.out.println(su);
		
		//문제. x=200, y=300값을 8바이트 배열에 x, y를 차례로 입력하시오.
		int x=200;
		int y=300;
		byte[] data=new byte[8];
		byte[] imsi=ByteBuffer.allocate(4).putInt(x).array();
		System.arraycopy(imsi, 0, data, 0, 4);
		imsi=ByteBuffer.allocate(4).putInt(y).array();
		System.arraycopy(imsi, 0, data, 4, 4);
		System.out.println(Arrays.toString(data));

		//data배열의 내용을 복원하시오.(8byte: 상위4바이트, 하위4바이트 분리)
		System.arraycopy(data, 0, imsi, 0, 4);
		ByteBuffer wrap1=ByteBuffer.wrap(imsi);
		x=wrap1.getInt();
		System.out.println(x);
		
		System.arraycopy(data, 4, imsi, 0, 4);
		ByteBuffer wrap2=ByteBuffer.wrap(imsi);
		y=wrap2.getInt();
		System.out.println(y);
		
	}

}
