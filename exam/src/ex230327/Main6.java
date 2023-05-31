package ex230327;

import java.util.Scanner;

public class Main6 {

	public static void main(String[] args) {
		Member[] member=new Member[100];
		Scanner scan=new Scanner(System.in);
		int index=0;
		while(true) {
			System.out.println("회원가입을 원하시면 \"회원가입\", 회원정보 전체출력이면 \"전체출력\"이라고 입력하세요.");
			String command=scan.nextLine();
			
			if(command.equals("회원가입")) {
				System.out.println("회원정보를 입력하세요.(아이디 패스워드 이메일)");
				String id=scan.next();
				String password=scan.next();
				String email=scan.next();
				scan.nextLine();
				member[index++]=new Member(id, password, email);
				System.out.println("회원이 가입 되었습니다.");
			}else if(command.equals("전체출력") || command.equals("전체 출력")) {
				for(int i=0;i<index;i++) 
					System.out.println(member[i].toString());
			}
		}
	}

}
