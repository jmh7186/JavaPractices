import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		/*
		Person p1=new Person();
		//p1.name="�迵��";
		//p1.age=24;
		p1.setName("�迵��");
		p1.setAge(24);
		System.out.println(p1.getName());
		System.out.println(p1.getAge());
		
		Person p2=new Person("��ȭ��",26);
		System.out.println(p2.getName());
		System.out.println(p2.getAge());
		System.out.println(p2.toString());
		*/
		/*
		Person[] p=new Person[100];
		p[0]=new Person("�迵��",24);
		p[1]=new Person("��ȭ��",26);
		p[2]=new Person("�迵��1",24);
		p[3]=new Person("�迵��2",25);
		p[4]=new Person("�迵��3",26);
		
		for(int i=0;i<5;i++) {
			System.out.println(p[i].toString());
		}
		*/
		
		//�Է�, ���, ����, ����
		//��ǻ�ʹ� �Է°� ���(���� �޸�-��ü�� �����ϴ°�-�޸𸮿� ����(�Է�))
		Person[] p=new Person[100];
		Scanner scan=new Scanner(System.in); //�Է¹ޱ� ���� ���� ����
		//�������
		//for(int i=0;i<3;i++) {
		System.out.println("�̸��� ���̸� �Է��ϼ���.");
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
