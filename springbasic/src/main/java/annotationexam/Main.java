package annotationexam;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
    	//작업사항) 자바 설정파일로 bean을 생성하고 설정된 bean을 이용하여 bean을 교체하면서 테스트
    	AnnotationConfigApplicationContext factory = new AnnotationConfigApplicationContext(Setting.class);
    	Print p = (Print) factory.getBean("consolePrint");
    	p.print("홍길동", 10, 20, 30);
    	p = (Print) factory.getBean("gridPrint");
    	p.print("홍길동", 100, 20, 30);
    }
}
