package ex230412;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main3 {

	public static void main(String[] args) throws IOException {
		//�������� ����Ʈ�� inputstream��ο� ���� �ִ´�.(��η� �Է�)
		//�� ��Ʈ���� �ʿ�� �ϴ� ���� byte�� �������� ���̴�.
		byte[] data= {1,2,3,4,5};
		ByteArrayInputStream bi=new ByteArrayInputStream(data);
		System.out.print(bi.read());
		System.out.print(bi.read());
		System.out.print(bi.available());
		
		//�������� ����Ʈ�� �Է¹޴� outputstream��θ� �����.(�Է��� ������ ������ ������)
		//�������� ����Ʈ�� ��ο� �Է��ϸ� �������� ����Ʈ�� ��ο� �ԷµǾ� �ٽ� ��µǴ� ����
		ByteArrayOutputStream bo=new ByteArrayOutputStream();
		//��θ� ����� �ٽ� �������� ����Ʈ�� ���� �� �ִ� ����
		bo.write(data); //��ο� �������� ����Ʈ�� �Է��ϴ� ����
		//bo�� ��θ� ������ ������ �ȿ��� �������� ����Ʈ�� �����ϰ� �ִ�.
		//�̵����͸� ������ ���� ���ؼ��� bo��ü(��½�Ʈ��)�� Ȱ���ϸ� ��.
		System.out.println(bo.size());
		System.out.println(bo.toByteArray()[2]);
		for(byte b:bo.toByteArray()) {
			System.out.print(b);
		}
		
		//FileInputStream, FileOutputStream
		//���Ϸκ��� �����͸� �о�� ��ο� ���� �ִ� ����
		FileInputStream fi=new FileInputStream("data.txt");
		//�ԷµǴ� �����ʹ� ���� �������� �ʾ�����
		//dataout.txt��� ���Ͽ� ��θ� �̿��Ͽ� ���� �۾�
		FileOutputStream fo=new FileOutputStream("dataout.txt"); 
		
		
		
		
		
		

	}

}
