package ex230321;

import java.io.IOException;
import java.util.Scanner;

public class Main8 {

	public static void main(String[] args) throws IOException {
		Student s1=new Student();
		Scanner scan=new Scanner(System.in);
		
		while(true) {
		menu();
		int sel=System.in.read()-48;
		
		while(System.in.available()!=0) {
			System.in.read();
		}
		
		if(sel==1) {
			System.out.print("학번을 입력하세요.");
			String id=scan.nextLine();
			System.out.print("이름을 입력하세요.");
			String name=scan.nextLine();
			s1.setInfo(id, name);			
			System.out.println("학생정보가 입력되었습니다.");
		}else if(sel==2) {
			s1.info();
			System.out.println("학생정보가 출력되었습니다.");
		}else if(sel==3) {
			System.out.println("학생정보가 수정되었습니다.");
		}else if(sel==4) {
			System.out.println("학생정보가 삭제되었습니다.");
		}else {
			System.out.println("메뉴를 다시 선택하세요.");
		}
		
		
		
		System.in.read();
		System.in.read();		
		
		}
		
	}
	
	static void menu() {
		System.out.println("1. 학생정보 입력");
		System.out.println("2. 학생정보 출력");
		System.out.println("3. 학생정보 수정");
		System.out.println("4. 학생정보 삭제");
	}

}
