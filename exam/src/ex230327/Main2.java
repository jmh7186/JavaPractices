package ex230327;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		//단. 데이터는 중복이 안된다고 가정함.
		String[] data= {"홍길동","박길동","이길동","여길동"};
		Scanner scan=new Scanner(System.in); 
		System.out.println("찾는 이름을 입력하세요.");
		String search=scan.nextLine();
		boolean flag=false;
		
		for(int i=0;i<data.length;i++) {
			if(data[i].equals(search)) {
				System.out.println("찾는 이름이 있습니다");
				flag=true;
				break;
			}
		}
		
		if(!flag) System.out.println("찾는 이름이 없습니다.");

	}

}
