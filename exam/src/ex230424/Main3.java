package ex230424;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main3 {

	public static void main(String[] args) {
		int protocol=1; //����:1
		String id="admin"; //����:10
		String pass="1234";//����:10
		byte[] data=new byte[100];
		//�� ������ ������ data �迭�� �Է��ϰ� ����Ͻÿ�.
		data[0]=(byte)protocol;
		System.arraycopy(id.getBytes(),0, data, 10, id.getBytes().length);
		System.arraycopy(pass.getBytes(),0, data, 20, pass.getBytes().length);
		System.out.println(Arrays.toString(data));
		System.out.println(new String(data));
		
		//data�迭�� �ִ� ������ protocol1, id1, pass1������ �и��Ͽ� �Է��Ͻÿ�.
		int protocol1=0; //����:1
		String id1=""; //����:10
		String pass1="";//����:10
		
		protocol1=data[0];
		System.out.println(protocol1);
		byte[] imsi=new byte[100];
		System.arraycopy(data,10, imsi,0,10); //id1����
		id1=new String(imsi).trim();
		System.out.println(id1);
		
		//����Ʈ �迭�� �ʱ�ȭ �ϴ� ���
		Array.setByte(imsi, 0, (byte) 0);
		System.arraycopy(data,20, imsi,0,10); //id1����
		pass1=new String(imsi).trim();
		System.out.println(pass1);

	}

}
