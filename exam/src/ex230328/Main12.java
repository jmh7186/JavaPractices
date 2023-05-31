package ex230328;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main12 {

	public static void main(String[] args) throws IOException {
		//1) data.txt파일을 참고하여 Phonebook객체를 만들고
		//2) data.txt파일에서 데이터를 읽어 5명의 Phonebook객체를 생성하시오.
		//저장공간(빈공책)100개 생성
		Phonebook[] pb=new Phonebook[100];
		//data.txt파일에서 한줄씩 읽어와서 객체생성(이름, 전화번호 기록)
		FileReader in=new FileReader("data.txt");
		char[] buf=new char[1024];
		int size=in.read(buf);
		//System.out.println(buf);
		//char[] -> String : char배열의 값을 문자열로 변환
		//String data=String.valueOf(buf); //buf크기의 사용안하는 부분이 문자열로 기록
		String data=String.valueOf(buf, 0, size);//******중요*******
		//System.out.println(data);
		//한줄 한줄을 읽어와 객체생성, 한 줄 분리를 split함수를 이용하여 처리
		String[] read=data.split("\r\n");
		//read[0], read[1], read[2],.
		//System.out.println(read[1]);
		//실질적으로 한줄을 읽어와 객체를 생성하게 되는데 다시 분리작업이 필요함(스페이스)
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
		//파일쓰기
		pb[5]=new Phonebook("여길동","011-6666-6666"); //메모리에 추가
		
		//추가된 내용이 포함된 pb[0]~pb[5]까지를 data.txt파일에 다시 기록
		//FileWriter out=new FileWriter("data.txt");
		//객체->문자열 pb[0].getName() pb[0].getHp()+"\r\n"
		
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
		
		//out.write(outs); //문제점 마지막 입력값에서 \r\n삭제
		//out.close();

	}

}
