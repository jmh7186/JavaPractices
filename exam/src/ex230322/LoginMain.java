package ex230322;

import java.util.Scanner;

public class LoginMain {

	public static void main(String[] args) {
		
		/*
		Login login1=new Login();
		//login1.id="admin";
		login1.setId("admin");
		System.out.println(login1.getId());
		System.out.println(login1.toString());
		login1.setPassword("1234");
		System.out.println(login1.toString());
		
		if(login1.loginAccess("admin","1234")) {
			System.out.println("로그인 성공");
		}else {
			System.out.println("로그인 실패");
		}
		*/
		
		/*
		Login login2=new Login("user", "0000");
		System.out.println(login2.toString());
		*/
		
		/* 회원가입 */
		Scanner scan=new Scanner(System.in);
		System.out.println("회원가입");
		System.out.println("아이디를 입력하세요.");
		String id=scan.nextLine();
		System.out.println("패스워드를 입력하세요.");
		String password=scan.nextLine();
		
		Login login3=new Login(id, password);
		System.out.println("회원가입이 되셨습니다.");
		System.out.println(login3.toString());
		//필요한 사항?속성값이 비어있는 여부, 길이, 원하는 내용을 입력되었는가
		
	}

}
