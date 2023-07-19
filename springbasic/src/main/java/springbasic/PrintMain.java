package springbasic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PrintMain {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("springbasic/printsetting.xml");
		Print prn = (Print) factory.getBean("consoleprint");
		prn.print();
		prn = (Print) factory.getBean("gridprint");
		prn.print();
	}
}