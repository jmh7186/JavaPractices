package annotation4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		
//		ApplicationContext factory = new ClassPathXmlApplicationContext("annotation3/setting.xml");
		AnnotationConfigApplicationContext factory = new AnnotationConfigApplicationContext(SettingConfig.class);
		
		Student student=(Student)factory.getBean("s");
		System.out.println(student.toString());
	}

}
