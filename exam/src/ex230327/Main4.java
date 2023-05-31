package ex230327;

import java.util.Scanner;

public class Main4 {

	public static void main(String[] args) {
		//단. 데이터는 중복이 안된다고 가정함.
		Phonebook[] pb=new Phonebook[100];
		pb[0]=new Phonebook("홍길동", "010-1111-1111");
		pb[1]=new Phonebook("박길동", "010-1111-2222");
		pb[2]=new Phonebook("이길동", "010-1111-3333");
		pb[3]=new Phonebook("여길동", "010-1111-4444");
		//int index=4;	
		Scanner scan=new Scanner(System.in); 
		System.out.println("찾는 이름을 입력하세요.");
		String search=scan.nextLine();
		boolean flag=false;
		
		for(int i=0;i<pb.length;i++) { //pb.length, index차이점을 확인
			if(pb[i].name.equals(search)) { //pb[i].getName().equals(search)
				System.out.println("찾는 전화번호는:"+pb[i].hp);
				flag=true;
				break;
			}
		}
		
		if(!flag) System.out.println("찾는 이름이 없습니다.");

	}

}
