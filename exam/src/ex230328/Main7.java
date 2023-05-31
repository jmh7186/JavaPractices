package ex230328;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Main7 {

	public static void main(String[] args) throws IOException {
		//�������� �⺻ �帧�� Stream
		//������ �����Ͽ� �޸𸮰� ������ �ȴ�.
		//��������� �޸𸮹������� �����Ͱ� �带 �� : InputStream
		//�޸𸮿��� ������ �������� �����Ͱ� �带 �� : OutputStream
		
		System.in.read();
		//���� �ڵ�� ����� �������� ��Ÿ�� ����
		//������� System.in(Ű���� �Է�), ������ �޸�(read())
		
		byte[] data= {97,98,99};
		System.out.write(data);
		//System.out(������, �����), write(�޸�->�����(�޸��ּ�))
		
		//1����Ʈ�� �޸� �Է��Ѵ�.(�ѱ�����x)
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
		//fileinputstream���� file�� �����(���Ͽ��� �����Ͱ� ���ͼ� �޸𸮿� �Է�(inputstream))
		//fileoutputstream���� file�� ������(�޸𸮿��� �����Ͱ� ���ͼ� ���Ͽ� ���(outputstream))		
		
		//2����Ʈ�� �޸� �Է��Ѵ�.(�ѱ�����)
		//Reader, Writer
		//FileReader�� File�� ����� �޸𸮷� Reader(�д´�)�Ѵ�.
		//FileWriter�� File�� ������ �޸𸮿��� ���Ϸ� Writer(����) �Ѵ�.

	}

}
