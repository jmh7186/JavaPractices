package ex230331;


public class Main4 {

	public static void main(String[] args) {
		//��1�� ����
		/*
		Car car=new Car("sonata",2000,2022);
		car.controllerAcc();
		car.controllerBreak();
		car.movehandle();
		car.controllerWindow();
		System.out.println(car.toString());
		*/
		
		//�� 10�븦 �����ϼ���.
		Car[] car=new Car[10];
		String[] cname= {"sonata","�ƹ���","��Ÿ��","sonata","�ƹ���","��Ÿ��","sonata","�ƹ���","��Ÿ��","���׽ý�"};
		int[] cc= {2000,1600,2000,2000,1600,2000,2000,1600,2000,3000};
		int[] year= {2021,2022,2023,2020,2019,2023,2023,2023,2023,2023};
		
		for(int i=0;i<car.length;i++) {
			car[i]=new Car(cname[i],cc[i],year[i]);
		}
		
		for(Car c:car) System.out.println(c.toString());
		
	}

}
