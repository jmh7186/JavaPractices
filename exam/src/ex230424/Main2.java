package ex230424;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class Main2 {

	public static void main(String[] args) {
		int protocol=1;
		char msg1='a';
		String msg2="bcdef";
		byte[] data=new byte[100];
		//������ �ִ� �����͸� byte�迭�� ���� �Է�
		//b[0]=protocol;
		//b[10]=msg1
		//b[20]=msg2;
		//System.arraycopy(protocol,0,data,0,1); //int���� �迭����Ʈ(����Ʈ)�� ����
		System.arraycopy
		(ByteBuffer.allocate(4).putInt(protocol).array(),0,data,0,4);
		//System.arraycopy(intToByteArray(protocol),0,data,0,4);
		System.out.println(Arrays.toString(data));
		//System.out.println(Arrays.toString(data));
		byte[] p=new byte[100];
		p[0]=data[3];
		System.out.println(p[0]);
		
		//���� ����� �ڵ� ****
		data[0]=(byte) protocol;
		System.out.println(data[0]);
		
		//data[10]=msg1�� �ѹ��ڸ� �־� ����
		data[10]=(byte) msg1;
		System.out.println(new String(data));
		
		//data[20]=msg2�� ���ڿ��� �־� ����
		//msg2(���ڿ���)�� ����Ʈ �迭�� �ٲٴ� ���
		System.out.println(msg2.getBytes()[0]);
		System.out.println(msg2.getBytes().length);
		System.arraycopy(msg2.getBytes(),0, data, 20, msg2.getBytes().length);
		System.out.println(Arrays.toString(data));
		
		//���
		/* �Ϲ������� �����ʹ� ������ �Է��� �Ǿ� �ְ�
		 * ������ �ִ� ������ ����Ʈ�迭�� Ư����ġ�� ���� �Է��ϰ� �˴ϴ�.
		 * ����Ʈ �迭�� ��Ʈ��ũ�� ��������� �˴ϴ�.
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
