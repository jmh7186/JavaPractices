package ex230328;

public class Main11 {

	public static void main(String[] args) {
//		숫자-문자
		int i=97;
		System.out.println((char)i);
		char c=(char)i;
		System.out.println(c);
		
//		문자-문자열
		String s=String.valueOf(c);
		System.out.println(s);
		
//		?숫자-문자열(한번에 바꾸는 방법은 없음)
		System.out.println(String.valueOf(97));
		System.out.println(String.valueOf((char)97));
		
//		한문자를 합치면 배열(문자열)
		char[] cs=new char[100];
		cs[0]='a';
		cs[1]='b';
		cs[2]='c';
		
		System.out.println(cs);
		
//		한문자를 합치면 문자열
		String ss="asdf";

//		배열을 문자열
		//ss=cs;//오류
		String sss=String.valueOf(cs);
		System.out.println(sss);
//문자열을 숫자로
		int j=Integer.parseInt("123");
		System.out.println(j);
		
		byte b=97;
		int k;
		k=b;
		System.out.println(k);
		b=(byte)k;
		char cc='f';
		System.out.println(cc);
		cc=97; //char형도 숫자가 입력되나 한문자를 정의한 한 변수이므로 ' '로 정의
		System.out.println(cc);
	}

}
