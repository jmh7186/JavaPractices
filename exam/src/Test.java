import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		/*
		Person p1=new Person();
		//p1.name="김영열";
		//p1.age=24;
		p1.setName("김영열");
		p1.setAge(24);
		System.out.println(p1.getName());
		System.out.println(p1.getAge());
		
		Person p2=new Person("김화영",26);
		System.out.println(p2.getName());
		System.out.println(p2.getAge());
		System.out.println(p2.toString());
		*/
		/*
		Person[] p=new Person[100];
		p[0]=new Person("김영열",24);
		p[1]=new Person("김화영",26);
		p[2]=new Person("김영열1",24);
		p[3]=new Person("김영열2",25);
		p[4]=new Person("김영열3",26);
		
		for(int i=0;i<5;i++) {
			System.out.println(p[i].toString());
		}
		*/
		
		//입력, 출력, 수정, 삭제
		//컴퓨터는 입력과 출력(기준 메모리-객체를 생성하는것-메모리에 저장(입력))
		Person[] p=new Person[100];
		Scanner scan=new Scanner(System.in); //입력받기 위한 도구 생성
		//도구사용
		//for(int i=0;i<3;i++) {
		System.out.println("이름과 나이를 입력하세요.");
		String str=scan.nextLine();
		System.out.println(str);
		String[] imsi=str.split(" ");
		System.out.println(imsi[0]);
		System.out.println(imsi[1]);
		
		/* String name=scan.next();
		int age=scan.nextInt();
		scan.nextLine();
		p[i]=new Person(name,age);
		System.out.println(p[i].toString());
				}*/
		
	}

}
