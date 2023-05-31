package ex230322_1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//데이터는 입력, 출력이 전부이다.
		//데이터 입력은 변수도 가능하지만 클래스의 맴버변수(속성)도 가능하다.(클래스를 만들어라)
		//한 명의 학생을 만들어라는 소리는 데이터 입력을 할 수 있는 공간을 만들어라고 하는 소리랑 같다.
		/*
		Student s1=new Student();//데이터가 빈 상태
		//빈상태에서 데이터를 입력하기 위해서는 함수를 이용해야함.
		s1.setId("20000101");
		s1.setName("홍길동");
		System.out.println(s1.toString());
		Score s = new Score(100,80,90);
		s1.setScore(s);
		System.out.println(s1.toString());
		System.out.println(s1.getScore().getKor());
		System.out.println(s1.score.getKor());
		*/
		
		String id = null;
		String name = null;
		Score score = null;
		Scanner scan=new Scanner(System.in);
		System.out.println("아이디 이름 국어 영어 수학 점수를 차례대로 입력하세요.");
		//System.out.println(scan.next());
		//System.out.println(scan.next());
		id=scan.next();
		name=scan.next();
		int kor=scan.nextInt();
		int eng=scan.nextInt();
		int math=scan.nextInt();
		//score=new Score(kor, eng, math);
		//Student s1=new Student(id, name, score);
		Student s2=new Student(id, name, new Score(kor, eng, math));
		System.out.println(s2.toString());
		

	}

}
