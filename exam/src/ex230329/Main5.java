package ex230329;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import ex230328.Phonebook;

public class Main5 {

	public static void main(String[] args) throws IOException {
		        //1) data.txt������ �����Ͽ� Phonebook��ü�� �����
				//2) data.txt���Ͽ��� �����͸� �о� 5���� Phonebook��ü�� �����Ͻÿ�.
				
				Phonebook[] pb=new Phonebook[100];
				
				FileReader in=new FileReader("data.txt");
				BufferedReader br=new BufferedReader(in);
				String data=null;
				int i=0;
				while((data=br.readLine())!=null) {
					String[] s=data.split(" ");
					pb[i++]=new Phonebook(s[0],s[1]);
					//i=i+1;
				}
								
				for(Phonebook p:pb) {
					if(p==null) break;
					System.out.println(p.toString());
				}
				br.close();
				in.close();

				System.out.println("��ȭ��ȣ�� �����͸� �߰��ϼ���.(�� ��μ� 010-6666-6666)");
				Scanner scan=new Scanner(System.in);
				String name=scan.next();
				String hp=scan.next();
				scan.nextLine();
				
				System.out.println(name);
				System.out.println(hp);
				pb[5]=new Phonebook(name, hp);
				
				//�޸𸮿� �߰��� phonebook�����͸� ���α׷��� �����Ѵٰ� �����ϰ�
				//���Ͽ� �����Ϸ��Ѵ�. 
				FileWriter fw=new FileWriter("data.txt");
				BufferedWriter bw=new BufferedWriter(fw);
				//pb�� �ִ� ��ü ��ȭ��ȣ�θ� ���Ͽ� �����Ͻÿ�.
				
				for(Phonebook p:pb) {
					if(p==null) break;
					bw.write(p.getName()+" "+p.getHp()+"\r\n");
				}
				//�������� ������ \r\n�� �����ϴ� ����� ���ϻ��¿��� �����ϴ� ���ã��
				//�������ٿ� ���� \r\n�� ������� �ʰ� if������ ó��
				bw.close();
				fw.close();
	}			

}
