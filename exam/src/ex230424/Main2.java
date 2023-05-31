package ex230424;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class Main2 {

	public static void main(String[] args) {
		int protocol=1;
		char msg1='a';
		String msg2="bcdef";
		byte[] data=new byte[100];
		//변수에 있는 데이터를 byte배열에 각각 입력
		//b[0]=protocol;
		//b[10]=msg1
		//b[20]=msg2;
		//System.arraycopy(protocol,0,data,0,1); //int형을 배열리스트(바이트)로 변경
		System.arraycopy
		(ByteBuffer.allocate(4).putInt(protocol).array(),0,data,0,4);
		//System.arraycopy(intToByteArray(protocol),0,data,0,4);
		System.out.println(Arrays.toString(data));
		//System.out.println(Arrays.toString(data));
		byte[] p=new byte[100];
		p[0]=data[3];
		System.out.println(p[0]);
		
		//실제 사용할 코드 ****
		data[0]=(byte) protocol;
		System.out.println(data[0]);
		
		//data[10]=msg1인 한문자를 넣어 전송
		data[10]=(byte) msg1;
		System.out.println(new String(data));
		
		//data[20]=msg2인 문자열을 넣어 전송
		//msg2(문자열을)를 바이트 배열로 바꾸는 방법
		System.out.println(msg2.getBytes()[0]);
		System.out.println(msg2.getBytes().length);
		System.arraycopy(msg2.getBytes(),0, data, 20, msg2.getBytes().length);
		System.out.println(Arrays.toString(data));
		
		//요약
		/* 일반적으로 데이터는 변수에 입력이 되어 있고
		 * 변수에 있는 내용을 바이트배열의 특정위치에 값을 입력하게 됩니다.
		 * 바이트 배열을 네트워크로 흘려보내게 됩니다.
		 */
		
	}
	public static byte[] intToByteArray(int value) {
		byte[] byteArray = new byte[4];
		byteArray[0] = (byte)(value >> 24);
		byteArray[1] = (byte)(value >> 16);
		byteArray[2] = (byte)(value >> 8);
		byteArray[3] = (byte)(value);
		return byteArray;
	}
}
