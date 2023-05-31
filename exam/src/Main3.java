
public class Main3 {

	public static void main(String[] args) {
		Cal È£µ¿=new Cal();
		Cal ¹Î¼ö=new Cal();
		Cal Ã¶¼ö=new Cal();
		int s=È£µ¿.add(10,20);
		System.out.println(s);
		
		System.out.println(¹Î¼ö.add(100,200));
		
		int a=20,b=30;
		s=Ã¶¼ö.add(a,b); //Ã¶¼ö.add(20,30)
		s=Ã¶¼ö.add(È£µ¿.add(10,20), ¹Î¼ö.add(30,40));
		System.out.println(s);
		

	}

}
