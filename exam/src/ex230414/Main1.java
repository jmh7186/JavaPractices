package ex230414;

import java.util.StringTokenizer;

public class Main1 {

	public static void main(String[] args) {
		//���ڿ� ó���ϱ�
		String s="hello java";
		char c=s.charAt(0);
		char c1="hello java".charAt(0);
		System.out.println(c);
		System.out.println(c1);
		System.out.println(s.charAt(0));
		
		//���ڴ� �ϼ��� ���ڿ��� �Ϻθ� �������� �Լ�(�Ϻ�����)
		//charAt : ��ġ��ȣ�� ������ �ѹ��ڸ� �����ϴ� �Լ�
		//������ ���õ� �����͸� �����ϼ���? ������ �����͸� �̿��Ͽ� ����, ���ڷ� ǥ���ϼ���.
		System.out.println("820305-2234567".charAt(7));
		char gen="820305-2234567".charAt(7);
		if(gen=='1') System.out.println("����");
		else System.out.println("����");
		
		String jumin="820305-2234567";
		gen=jumin.charAt(7);
		if(gen=='1') System.out.println("����");
		else System.out.println("����");
		
		//substring : ���ڿ��� �Ϻθ� �����ϴ� �Լ�
		//(*���ڿ� ��ġ�� 0���ͽ���, �ڿ� �ε����� ��ȣ ������ ����� ��)
		System.out.println(jumin.substring(0));
		System.out.println(jumin.substring(0,2));
		System.out.println(jumin.substring(2,4));
		
		//�Ϻ��� ���ڸ� ���ļ� �ϼ��� ���ڷ� ����� �Լ�(���ڿ���ġ��)
		//concat:���ڿ��� ���ϴ� ���
		System.out.println("java".concat("hello"));
		//�ֹε�Ϲ�ȣ���� ���� �����Ͽ� 1982�� ���弼��.?
		jumin="820305-2234567";		
		System.out.println("19".concat(jumin.substring(0,2)));
		//1982��03��05�Ϸ� ���ڿ��� ���弼��
		"19".concat(jumin.substring(0,2));
		jumin.substring(2,4);
		jumin.substring(4,6);
		
		int f=0, t=2;
		for(int i=0;i<3;i++) {
			System.out.println(jumin.substring(f,t));
			f=f+2;
			t=t+2;
		}
		
		for(int i=0;i<=4;i=i+2) {
			System.out.println(jumin.substring(i,i+2));
		}
		
		for(int i=0;i<3;i++) {
			System.out.println(jumin.substring(2*i,2*i+2));
		}
		//���ڿ��� ���� Ȯ��
		jumin="820305-2234567";
		System.out.println(jumin.length());
		
		//��ġ�� ã���ִ� �Լ�
		String filename="aaaaa.html";
		System.out.println(filename.indexOf('.'));
		//���� ������ index�� html�� �и��Ͻÿ�.
		System.out.println(filename.substring(0,filename.indexOf('.')));
		System.out.println(filename.substring(filename.indexOf('.')+1,filename.length()));
		//split :���ڿ� �и�
		String[] imsi=filename.split("\\."); //* ���Խ��� \\�� �����Ͽ� �����Ǹ� Ư�����ڿ� ����
		System.out.println(imsi[0]);
		System.out.println(imsi[1]);
		
		//���� �����ϴ� �Լ�
		System.out.println("hello java".replace(' ',':'));
		System.out.println("hello java 100~200".replace(' ',':'));
		System.out.println("hello java".replace("java","html"));
		
		//lastindexof
		String content="seoulseoulseoul";
		System.out.println(content.indexOf("seoul"));
		System.out.println(content.indexOf("seoul", 5));//5��°���� seoul�� ã�ƶ�
		System.out.println(content.indexOf("seoul", content.indexOf(' ')));
		System.out.println(content.lastIndexOf("seoul"));
		
		//content�� �ִ� seoul�� �ܾ ��� �������� �м��Ͻÿ�.
		//��Ʈ:������ ��ü ���̸� Ȯ���ϰ� �ݺ����� ������.
		//�ݺ����� �����ϱ��� ���� �� �˻��� ��ġ(������)�� 0���� �����Ѵ�.
		//count�˰����� ����
		content="seoulaaaa seoul seoulbbb seoul ";
		System.out.println(content.indexOf("seoul ",20));
		//�˻��ϴ� ���� �������� ���� ��� -1�� ����� ���
		
		String search="seoul ";
		int result=-1;
		int count=0;
		for(int point=0;point<content.length();) {
			result=content.indexOf(search,point);
			if(result>-1) {
				System.out.println("���:"+result);
				//ã�Ҵ�.
				count++;
				point=point+search.length();
			}else {
				count--;
				break;
			}
		}
		System.out.println("�˻�Ƚ��:"+count);
		
		//contains: ���ԵǴ�(��� true, false)
		content="i live seoul";
		System.out.println(content.contains("seoul"));
		if(content.contains("pusan")) {
			System.out.println("�˻����ڰ� ���ԵǾ� �ֽ��ϴ�.");
		}else {
			System.out.println("�˻����ڰ� �����ϴ�.");
		}
		
		//��������
		System.out.println("     hello      ".trim());
		
		//��ҹ���ó��
		content="i live seoul";
		System.out.println(content.toUpperCase());
		System.out.println(content.toUpperCase().toLowerCase());
		
		for(String ss:content.split(" ")) {
			System.out.println(ss);
		}
		
		//� ���忡�� �ش��ϴ� ������ ī���͸� �����մϴ�.
		content="i live seoul. Are you in seoul";
		//seoul�̶�� �ܾ ��� ��Ÿ���°�?
		count=0;
		for(String ss:content.split(" ")) {
			//if(ss.equals("seoul")) count++; //���ڿ��� ������ ��ġ�ϴ� ���
			if(ss.contains("seoul")) count++; //���ڿ��� ���Ե� ���
		}
		System.out.println(count);
		
		
		//���ڿ� �񱳿� ��ü��
		String insa="hello";
		System.out.println(insa.equals("hello"));
		System.out.println("hello".equals(insa));
		if(insa.equals("hello")) {
			System.out.println("��ġ");
		}else {
			System.out.println("����ġ");
		}
		
		System.out.println(insa=="hello");
		
		Test t1=new Test();
		Test t2=new Test();
		System.out.println(t1==t2); //�� ��ü�� �������� �ʴ�.
		Test t3=t1;
		System.out.println(t1==t3); //������ ��ü�� ����Ű�� ����
		//* ���ǻ��� == �Ϲݺ������� ���� ���ٶ�� ǥ��������
		// ��ü������ ������ ��ü�� ����Ű�� �ִ��� Ȯ���ϴ� �������̴�.
		
		//compareTo : �ƽ�Ű�ڵ尪 ��
		System.out.println((byte)'a'); //�ƽ�Ű�ڵ� 97
		System.out.println((byte)'c'); //�ƽ�Ű�ڵ� 99
		System.out.println("a".compareTo("d")); //�� �ƽ�Ű�ڵ带 ���Ͽ� ���̰� ���
		//System.out.println("hello".compareTo("o")); //���ڿ��񱳰� �ƴ�
		
		//StringTokenizer : ��ū
		StringTokenizer token=new StringTokenizer("010-1111-2222");
		System.out.println(token.nextToken("-")); //-�� ã�´�(�帧)
		System.out.println(token.nextToken("-"));
		System.out.println(token.nextToken("-"));
		
		
		
		
	}

}
