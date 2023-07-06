package springbasic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		// Score는 Student의 멤버변수로서 만들어졌으며 아래 주석처럼 별도로 사용될 일이 없다. (종속적)
//		Score sc = new Score();

//		Student std = new Student();
//		std.setScore(new Score());
//		std.score.kor = 100;
		
		//Student 클래스에서 Score 객체를 생성 (new Score) 하지 않고 아래 코드 실행 시 NullPointer 예외 발생
		//생성자 함수에서 객체를 생성하거나, 객체 정의에 객체 생성을 해도 됨. 또는 set함수로 구현해도 가능
//		System.out.println(std.score.kor);
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("springbasic/setting.xml");
		Score sc = (Score) factory.getBean("score1");
		sc.eng = 100;
		System.out.println(sc.eng);
		sc = (Score) factory.getBean("score2");
		System.out.println(sc.toString());
		sc = (Score) factory.getBean("score3");
		System.out.println(sc.toString());
	}

}
