package ex230331;

 //�ڵ����� �Ӽ��� �ڵ�����, CC, ����� �ְ� ����� ������ ����� �������� �մϴ�.
//CarŬ������ ���弼��. 
//�� ����� System.out.println�� ����Ͽ� ���ڿ��� �ڵ������� ��� "�ڵ�����"�̶�� ������ ��µǰ� �մϴ�. �ٸ� ��� ���� �̿� ���� �����ϸ� �˴ϴ�.
//
//�ڵ��� ��ü�� ����� �Ӽ����� ������ ���� �Է��ϴ� �����ڸ� ����ϴ�.
public class Car implements CarInter{
	String name;
	int cc;
	int year;
	public Car() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Car(String name, int cc, int year) {
		this.name = name;
		this.cc = cc;
		this.year = year;
	}


	@Override
	public void movehandle() {
		System.out.println("�ڵ�����");
		
	}
	@Override
	public void controllerAcc() {
		System.out.println("��������������");
		
	}
	@Override
	public void controllerBreak() {
		System.out.println("�극��ũ����");
		
	}
	@Override
	public void controllerWindow() {
		System.out.println("â������");	
	}
	
	@Override
	public String toString() {
		return "Car [name=" + name + ", cc=" + cc + ", year=" + year + "]";
	}
	
	
	
}

