package ex230331;

import java.util.Scanner;

abstract class Taja{
	String buf;
	
	public void input() {
		Scanner scan=new Scanner(System.in);
		System.out.println("버퍼에 들어갈 내용을 입력하세요.");
		buf=scan.nextLine();
	}
	
	public abstract void output();
}

class NewTaja extends Taja{

	@Override
	public void output() {
		System.out.println("***************");
		System.out.println(buf);
		System.out.println("***************");
		
	}
	public void ai() {
		System.out.println("AI기능");
	}
	
}

public class Main1 {

	public static void main(String[] args) {
		/*
		//Taja t=new Taja();
		NewTaja t=new NewTaja();
		t.input();
		t.output();
		t.ai();
		
		Taja t1=new NewTaja();
		t1.input();
		t1.output();
		*/
		Taja t=new Taja(){
	
			public void output() {
				System.out.println("^^^^^^^^^^");
				System.out.println(buf);
				System.out.println("^^^^^^^^^^");
			}
		};
		
		t.input();
		t.output();
		

	}

}
