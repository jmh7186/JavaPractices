package ex230412;

import java.io.FileInputStream;
import java.io.IOException;

public class Main6 {

	public static void main(String[] args) throws IOException {
		FileInputStream file=new FileInputStream("index.html");
		//����. index.html������ ������ �о�� ���ڿ������� �ְ� ����Ͻÿ�.
		String fdata=new String(file.readAllBytes());
		System.out.println(fdata);
		
	}

}
