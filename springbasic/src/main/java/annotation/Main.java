package annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("annotation/setting.xml");
		
		Student student=(Student)factory.getBean("student");
		student.score.kor=100;
		System.out.println(student.score.kor);
	}

}
