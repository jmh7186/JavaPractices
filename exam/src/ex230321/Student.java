package ex230321;

public class Student {
	//�냽�꽦
	String id;
	String name;
	int kor;
	int eng;
	int math;
	int total;
	float avg;
	
	public Student() {
		
	}
	
	public Student(String id, String name) {
		this.id=id;
		this.name=name;
	}
	
	void setInfo(String id, String name) {
		this.id=id;
		this.name=name;
	}
	
	void info() {
		System.out.println("id:"+id);
		System.out.println("name:"+name);
	}
	
	//국어, 영어, 수학을 입력하는 함수(setSubject)를 만드세요.
	void setSubject(int kor, int eng, int math) {
		this.kor=kor;
		this.eng=eng;
		this.math=math;
		total=kor+eng+math;
		avg=(float)total/3;
	}
	
	//국어, 영어, 수학을 출력하는 함수(printSubject)를 만드세요.
	void printSubject() {
		System.out.println("kor:"+kor);
		System.out.println("eng:"+eng);
		System.out.println("math:"+math);
		System.out.println("합계:"+total);
		System.out.println("평균:"+avg);
	}
	
	//모든 정보를 테이블로 출력
	void printAll() {
		System.out.println("--------------------------------------------");
		System.out.println("|학번     | 이름 | 국어 | 영어 | 수학 | 합계 | 평균 |");
		System.out.println("--------------------------------------------");
		System.out.printf("|%5s| %-3s | %d | %d | %d | %d | %.2f |\n"
				,id, name,kor,eng,math,total,avg);
		System.out.println("--------------------------------------------");
	}
	
	/*
	void imsi() {
		System.out.println("�씠由꾩�"+name);
		System.out.println("�씠由꾩�"+this.name);
	}
	
	void imsi1(String name) {
		System.out.println("�씠由꾩�"+name);
	}
	
	void imsi2(String name) {
		System.out.println("�씠由꾩�"+name);
		System.out.println("�씠由꾩�"+this.name);
	}
	*/
	// 아이디, 이름 입력, 출력
	// 성적에 대한 입출력
	// 모든데이터는 입력, 출력, 수정, 삭제
	// 수정, 삭제는 입력에 분류되는 기능
	
	
}
