package ex230321;

import java.io.IOException;

public class Main5 {

	public static void main(String[] args) throws IOException {
		/*
		Main5 main=new Main5();
		main.menu();
		*/
		while(true) {
		// 1)메뉴보여주기
		menu();
		// 2)메뉴선택
		int sel=System.in.read()-48;
		//sel=sel-48;
		//System.out.println(sel);
		// 3)어떤 메뉴가 선택되었는가를 확인 후 처리
		if(sel==1) {
			System.out.println("학생정보가 입력되었습니다.");
		}else if(sel==2) {
			System.out.println("학생정보가 출력되었습니다.");
		}else if(sel==3) {
			System.out.println("학생정보가 수정되었습니다.");
		}else if(sel==4) {
			System.out.println("학생정보가 삭제되었습니다.");
		}else {
			System.out.println("메뉴를 다시 선택하세요.");
		}
		
		while(System.in.available()!=0) {
			System.in.read();
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
