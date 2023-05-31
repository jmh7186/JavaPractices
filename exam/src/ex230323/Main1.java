package ex230323;

public class Main1 {

	public static void main(String[] args) {
	System.out.println(Integer.toBinaryString(8));
	System.out.println(Integer.toBinaryString(15));
	System.out.println(8&15);
	System.out.println(Integer.toBinaryString(8&15));
	System.out.println(Integer.toBinaryString(8|15));
	System.out.println(Integer.toBinaryString(8>>2));
	System.out.println(Integer.toBinaryString(1<<2));
	System.out.println(8^12);
	System.out.println(~12);
	
	int temp = -1 >>> 1; 
    System.out.println(temp); 
    System.out.println(Integer.toBinaryString(temp)); 
   
    
	
	}

}
