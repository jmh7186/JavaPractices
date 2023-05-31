package ex230321;

import java.io.IOException;

public class Main6 {

	public static void main(String[] args) throws IOException {
		/*
		Main5 main=new Main5();
		main.menu();
		*/
		int sel;
		// 1)메뉴보여주기
		//sel=menu();
		sel=menu();
		// 2)메뉴선택
		//int sel=System.in.read()-48;
		//sel=sel-48;
		//System.out.println(sel);
		

	}
	
	static int menu() throws IOException {
		System.out.println("1. 학생정보 입력");
		System.out.println("2. 학생정보 출력");
		System.out.println("3. 학생정보 수정");
		System.out.println("4. 학생정보 삭제");
		int sel=System.in.read()-48;
		return sel;
		
	}

}
