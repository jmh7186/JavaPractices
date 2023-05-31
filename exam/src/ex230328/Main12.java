package ex230328;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main12 {

	public static void main(String[] args) throws IOException {
		//1) data.txt������ �����Ͽ� Phonebook��ü�� �����
		//2) data.txt���Ͽ��� �����͸� �о� 5���� Phonebook��ü�� �����Ͻÿ�.
		//�������(���å)100�� ����
		Phonebook[] pb=new Phonebook[100];
		//data.txt���Ͽ��� ���پ� �о�ͼ� ��ü����(�̸�, ��ȭ��ȣ ���)
		FileReader in=new FileReader("data.txt");
		char[] buf=new char[1024];
		int size=in.read(buf);
		//System.out.println(buf);
		//char[] -> String : char�迭�� ���� ���ڿ��� ��ȯ
		//String data=String.valueOf(buf); //bufũ���� �����ϴ� �κ��� ���ڿ��� ���
		String data=String.valueOf(buf, 0, size);//******�߿�*******
		//System.out.println(data);
		//���� ������ �о�� ��ü����, �� �� �и��� split�Լ��� �̿��Ͽ� ó��
		String[] read=data.split("\r\n");
		//read[0], read[1], read[2],.
		//System.out.println(read[1]);
		//���������� ������ �о�� ��ü�� �����ϰ� �Ǵµ� �ٽ� �и��۾��� �ʿ���(�����̽�)
		int i=0;
		for(String imsi:read) { 
			String[] s=imsi.split(" ");
			//System.out.println(s[0]+","+s[1]); //s[0]:name, s[1]:hp
			pb[i++]=new Phonebook(s[0],s[1]);
		}
		/*
		System.out.println(pb[0].toString());
		System.out.println(pb[1].toString());
		System.out.println(pb[2].toString());
		System.out.println(pb[3].toString());
		System.out.println(pb[4].toString());
		*/
		/*
		for(int k=0;k<i;k++){
			System.out.println(pb[k]);
		}
		*/
		
		for(Phonebook p:pb) {
			if(p==null) break;
			System.out.println(p.toString());
		}
		
		in.close();
		//���Ͼ���
		pb[5]=new Phonebook("���浿","011-6666-6666"); //�޸𸮿� �߰�
		
		//�߰��� ������ ���Ե� pb[0]~pb[5]������ data.txt���Ͽ� �ٽ� ���
		//FileWriter out=new FileWriter("data.txt");
		//��ü->���ڿ� pb[0].getName() pb[0].getHp()+"\r\n"
		
		String outs="";
		int cnt=0;
		for(Phonebook p:pb) {
			if(p==null) break;
			//System.out.println(p.getName()+" "+p.getHp()+"\r\n");
			outs+=p.getName()+" "+p.getHp()+"\r\n";
			cnt++;
		}
		outs+="end"; //outs=outs+"end"
		System.out.println(outs);
		System.out.println(cnt);
		//outs=outs.substring(0,outs.length()-2);
		
		//out.write(outs); //������ ������ �Է°����� \r\n����
		//out.close();

	}

}
