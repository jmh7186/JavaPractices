package ex230328;

public class Main11 {

	public static void main(String[] args) {
//		����-����
		int i=97;
		System.out.println((char)i);
		char c=(char)i;
		System.out.println(c);
		
//		����-���ڿ�
		String s=String.valueOf(c);
		System.out.println(s);
		
//		?����-���ڿ�(�ѹ��� �ٲٴ� ����� ����)
		System.out.println(String.valueOf(97));
		System.out.println(String.valueOf((char)97));
		
//		�ѹ��ڸ� ��ġ�� �迭(���ڿ�)
		char[] cs=new char[100];
		cs[0]='a';
		cs[1]='b';
		cs[2]='c';
		
		System.out.println(cs);
		
//		�ѹ��ڸ� ��ġ�� ���ڿ�
		String ss="asdf";

//		�迭�� ���ڿ�
		//ss=cs;//����
		String sss=String.valueOf(cs);
		System.out.println(sss);
//���ڿ��� ���ڷ�
		int j=Integer.parseInt("123");
		System.out.println(j);
		
		byte b=97;
		int k;
		k=b;
		System.out.println(k);
		b=(byte)k;
		char cc='f';
		System.out.println(cc);
		cc=97; //char���� ���ڰ� �Էµǳ� �ѹ��ڸ� ������ �� �����̹Ƿ� ' '�� ����
		System.out.println(cc);
	}

}
