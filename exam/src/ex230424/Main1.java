package ex230424;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class Main1 {

	public static void main(String[] args) {
		byte[] b=new byte[100];
		b[0]=1;//'A' -> 숫자 1을 입력 : 아스키코드 49
		b[10]=66; //'B'
		System.out.println(b);
		System.out.println(new String(b));
		b[20]=67;//'C'
		b[21]=68;//'D'
		System.out.println(new String(b));
		
		//배열의 위치마다 다른데이터를 분리
		byte[] p=new byte[100];
		//b[0]:숫자 분리, b[10]째에 있는 문자 분리, b[20]문자열을 분리
		System.arraycopy(b, 0, p, 0, 1); 
		//b안에는 여러 데이터가 존재를 하고 
		//b의 0번째 부터 p의 0번째에 1자를 복사를 한다.
		int protocol=p[0]; //아스크코드 1(soh)을 int형으로 저장하면 숫자1이 저장
		System.out.println(protocol);//숫자 1을 의미
		System.out.println((char)protocol); //soh

		System.arraycopy(b, 10, p, 0, 10); 
		//b의 10번째부터 p의 0번째로 복사, b의 10번재부터 10자를 가지고옴
		System.out.println(new String(p));
		
		//b의 20번째 10자를 p에 복사하세요.
		System.arraycopy(b, 20, p, 0, 10); 
		System.out.println(new String(p));
		
		byte[] barray= {0x44,0x43,0x42,0x41}; //128이상의 아스키코드를 입력시 에러발생
		//barray[0]=0x00,barray[1]=0x00,barray[2]=0x00,barray[3]=0x01
		//int i=barray;//배열을 숫자로 바꾸는 형태는 오류발생
		//int i=barray[3];//하나의 바이트를 숫자로 변경하는 것은 오류발생안함
		//int i=ByteBuffer.wrap(barray).getInt();
		//System.out.println(i);
		System.out.println(Arrays.toString(barray));
		System.out.println(new String(barray));
		
	}

}
