
public class Main3 {

	public static void main(String[] args) {
		Cal �ㄤ�=new Cal();
		Cal 團熱=new Cal();
		Cal 繹熱=new Cal();
		int s=�ㄤ�.add(10,20);
		System.out.println(s);
		
		System.out.println(團熱.add(100,200));
		
		int a=20,b=30;
		s=繹熱.add(a,b); //繹熱.add(20,30)
		s=繹熱.add(�ㄤ�.add(10,20), 團熱.add(30,40));
		System.out.println(s);
		

	}

}
