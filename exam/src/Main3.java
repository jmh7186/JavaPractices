
public class Main3 {

	public static void main(String[] args) {
		Cal ȣ��=new Cal();
		Cal �μ�=new Cal();
		Cal ö��=new Cal();
		int s=ȣ��.add(10,20);
		System.out.println(s);
		
		System.out.println(�μ�.add(100,200));
		
		int a=20,b=30;
		s=ö��.add(a,b); //ö��.add(20,30)
		s=ö��.add(ȣ��.add(10,20), �μ�.add(30,40));
		System.out.println(s);
		

	}

}
