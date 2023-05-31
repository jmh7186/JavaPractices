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
		        //1) data.txt파일을 참고하여 Phonebook객체를 만들고
				//2) data.txt파일에서 데이터를 읽어 5명의 Phonebook객체를 생성하시오.
				
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

				System.out.println("전화번호에 데이터를 추가하세요.(예 김민수 010-6666-6666)");
				Scanner scan=new Scanner(System.in);
				String name=scan.next();
				String hp=scan.next();
				scan.nextLine();
				
				System.out.println(name);
				System.out.println(hp);
				pb[5]=new Phonebook(name, hp);
				
				//메모리에 추가된 phonebook데이터를 프로그램이 종료한다고 가정하고
				//파일에 저장하려한다. 
				FileWriter fw=new FileWriter("data.txt");
				BufferedWriter bw=new BufferedWriter(fw);
				//pb에 있는 전체 전화번호부를 파일에 쓰기하시오.
				
				for(Phonebook p:pb) {
					if(p==null) break;
					bw.write(p.getName()+" "+p.getHp()+"\r\n");
				}
				//마지막에 파일의 \r\n을 제거하는 방법을 파일상태에서 변경하는 방법찾기
				//마지막줄에 대해 \r\n을 사용하지 않게 if문으로 처리
				bw.close();
				fw.close();
	}			

}
