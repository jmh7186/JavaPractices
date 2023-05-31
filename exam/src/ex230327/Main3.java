package ex230327;

import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) {
		//단. 데이터는 중복이 안된다고 가정함.
		String[] name= {"홍길동","박길동","이길동","여길동"};
		String[] hp= {"010-1111-1111","010-1111-2222","010-1111-3333","010-1111-4444"};
		Scanner scan=new Scanner(System.in); 
		System.out.println("찾는 이름을 입력하세요.");
		String search=scan.nextLine();
		boolean flag=false;
		
		for(int i=0;i<name.length;i++) {
			if(name[i].equals(search)) {
				System.out.println("찾는 전화번호는:"+hp[i]);
				flag=true;
				break;
			}
		}
		
		if(!flag) System.out.println("찾는 이름이 없습니다.");

	}

}
