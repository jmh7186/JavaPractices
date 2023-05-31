package ex230320;

public class Cookie{
 String name;
 
 public void go(){
System.out.println("            O");
System.out.println("            ^");
System.out.print("            |");
System.out.println("["+name+"]");
System.out.println("            ^");
 }
 public void back(){
System.out.println("O");
System.out.println("^");
System.out.print("|");
System.out.println("["+name+"]");
System.out.println("^");
 }

 public void go(int step){
 	for(int i=0;i<step;i++){
 		System.out.print(" ");
 	}
	System.out.println("O");
	
	for(int i=0;i<step;i++){
 	System.out.print(" ");
 	}
	System.out.println("^");
	
	for(int i=0;i<step;i++){
 	System.out.print(" ");
 	}
	System.out.print("|");
	System.out.println("["+name+"]");

	for(int i=0;i<step;i++){
	 System.out.print(" ");
 	}
	System.out.println("^");
 }
}









