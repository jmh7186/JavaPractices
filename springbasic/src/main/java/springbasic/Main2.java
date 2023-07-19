package springbasic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main2 {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("springbasic/setting3.xml");
		String[] arr = (String[]) factory.getBean("arr");
		for(String s:arr) {
			System.out.println(s);
		}
	}

}
