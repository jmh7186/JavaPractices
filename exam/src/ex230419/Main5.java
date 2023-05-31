package ex230419;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main5 {

	public static void main(String[] args) throws IOException {
		//���ϰ�ü�� �����ϰ� ������ ���� �� ���̷� Ȯ���ϴ� ���
		File file=new File("index.html");
		System.out.println(file.length());
		
		
		//���� ����� �̸�(���ڿ�)���� Ȯ���ϴ� ���
		Path path=Paths.get("index.html");
		System.out.println(Files.size(path));
		
		//��Ʈ���ȿ� ��� �ִ� ������ ũ�⸦ Ȯ���ϹǷ�
		//�뷮�� ū ������ ��� buf�� �ִ밪�� �����Ƿ�
		//buf�� �ִ밪�� ũ��� ����� ��.
		FileInputStream in=new FileInputStream(file);
		System.out.println(in.available());

	}

}
