package ex230424;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main3 {

	public static void main(String[] args) {
		int protocol=1; //길이:1
		String id="admin"; //길이:10
		String pass="1234";//길이:10
		byte[] data=new byte[100];
		//위 변수의 내용을 data 배열에 입력하고 출력하시오.
		data[0]=(byte)protocol;
		System.arraycopy(id.getBytes(),0, data, 10, id.getBytes().length);
		System.arraycopy(pass.getBytes(),0, data, 20, pass.getBytes().length);
		System.out.println(Arrays.toString(data));
		System.out.println(new String(data));
		
		//data배열에 있는 내용을 protocol1, id1, pass1변수에 분리하여 입력하시오.
		int protocol1=0; //길이:1
		String id1=""; //길이:10
		String pass1="";//길이:10
		
		protocol1=data[0];
		System.out.println(protocol1);
		byte[] imsi=new byte[100];
		System.arraycopy(data,10, imsi,0,10); //id1복기
		id1=new String(imsi).trim();
		System.out.println(id1);
		
		//바이트 배열을 초기화 하는 방법
		Array.setByte(imsi, 0, (byte) 0);
		System.arraycopy(data,20, imsi,0,10); //id1복기
		pass1=new String(imsi).trim();
		System.out.println(pass1);

	}

}
