package ex230322_1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//�����ʹ� �Է�, ����� �����̴�.
		//������ �Է��� ������ ���������� Ŭ������ �ɹ�����(�Ӽ�)�� �����ϴ�.(Ŭ������ ������)
		//�� ���� �л��� ������� �Ҹ��� ������ �Է��� �� �� �ִ� ������ ������� �ϴ� �Ҹ��� ����.
		/*
		Student s1=new Student();//�����Ͱ� �� ����
		//����¿��� �����͸� �Է��ϱ� ���ؼ��� �Լ��� �̿��ؾ���.
		s1.setId("20000101");
		s1.setName("ȫ�浿");
		System.out.println(s1.toString());
		Score s = new Score(100,80,90);
		s1.setScore(s);
		System.out.println(s1.toString());
		System.out.println(s1.getScore().getKor());
		System.out.println(s1.score.getKor());
		*/
		
		String id = null;
		String name = null;
		Score score = null;
		Scanner scan=new Scanner(System.in);
		System.out.println("���̵� �̸� ���� ���� ���� ������ ���ʴ�� �Է��ϼ���.");
		//System.out.println(scan.next());
		//System.out.println(scan.next());
		id=scan.next();
		name=scan.next();
		int kor=scan.nextInt();
		int eng=scan.nextInt();
		int math=scan.nextInt();
		//score=new Score(kor, eng, math);
		//Student s1=new Student(id, name, score);
		Student s2=new Student(id, name, new Score(kor, eng, math));
		System.out.println(s2.toString());
		

	}

}
