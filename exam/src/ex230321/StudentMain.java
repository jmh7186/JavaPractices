package ex230321;

public class StudentMain {

	public static void main(String[] args) {
		Student s1=new Student();
		s1.name="홍길동";
		s1.info();
		s1.id="20000202";
		s1.info();
				
				
		Student s2=new Student();
		s2.setInfo("20000101","김길동");
		s2.info();
		
		Student s3=new Student("20000102","박길동");
		s3.info();
		
		//s4객체를 만들고 생성시 id, name을 입력하고
		//국어,영어, 수학 성적을 입력 후 
		//모든 정보를 확인하시오.
		Student s4=new Student("20000302","유길동");
		s4.setSubject(100, 80, 70);
		s4.info();
		s4.printSubject();
		s4.printAll();
		
		//s1.imsi();
		//s1.imsi1("김개똥");
		//s1.imsi2("박개똥");
		

	}

}
