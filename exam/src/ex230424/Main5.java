package ex230424;

import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class Main5 {

	public static void main(String[] args) {
		int su=10;
		byte[] data=new byte[4];
		System.arraycopy
		(ByteBuffer.allocate(4).putInt(su).array(),0,data,0,data.length);
		System.out.println(Arrays.toString(data));

		byte[] p=new byte[100];
		System.arraycopy(data, 0, p, 0, data.length);
		System.out.println(Arrays.toString(p));
		
		//�ݴ�� �����͸� �����ϴ� ����� �����ؾ��մϴ�.
		//p-> ���������� ��ȯ(int i)
		//data�� 4����Ʈ �迭
		//Array.setByte(data, 0, (byte) 0);
		byte[] inte=new byte[4];
		System.out.println(Arrays.toString(inte));
		System.arraycopy(p, 0, inte, 0,inte.length);
		System.out.println(Arrays.toString(inte));
		//inte����Ʈ �迭�� ������ �����Ͻÿ�.
		int i=ByteBuffer.wrap(inte).getInt();
		System.out.println(i);
	}

}
