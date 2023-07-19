package multiconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import multiconfig.student.Student;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext factory = new AnnotationConfigApplicationContext(SettingConfig.class);
		Student std = (Student) factory.getBean("student");
		System.out.println(std.toString());
	}

}
