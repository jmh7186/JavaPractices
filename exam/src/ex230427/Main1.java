package ex230427;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class Main1 {

	public static void main(String[] args) {
		
		//������ 4����Ʈ�����ͷ� ��ȯ
		int su=128;
		//allocate(4)�� 4�ڸ� �迭�� ����ڴٴ� �ǹ�
		byte[] arrayb=ByteBuffer.allocate(4).putInt(su).array();
		System.out.println(Arrays.toString(arrayb));
		System.out.println(arrayb.length);
		//4����Ʈ �����͸� ������ ��ȯ
		ByteBuffer wrap=ByteBuffer.wrap(arrayb);
		su=wrap.getInt();
		System.out.println(su);
		
		//����. x=200, y=300���� 8����Ʈ �迭�� x, y�� ���ʷ� �Է��Ͻÿ�.
		int x=200;
		int y=300;
		byte[] data=new byte[8];
		byte[] imsi=ByteBuffer.allocate(4).putInt(x).array();
		System.arraycopy(imsi, 0, data, 0, 4);
		imsi=ByteBuffer.allocate(4).putInt(y).array();
		System.arraycopy(imsi, 0, data, 4, 4);
		System.out.println(Arrays.toString(data));

		//data�迭�� ������ �����Ͻÿ�.(8byte: ����4����Ʈ, ����4����Ʈ �и�)
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
