package ex230320;

import java.util.Scanner;
public class First{
 public static void main(String[] args){
	String name;
	Scanner scan=new Scanner(System.in);
	
	System.out.print("당신의 이름은 어떻게 되나요?");
	name=scan.nextLine();
	System.out.printf("당신의 이름은 %s입니다.",name);
 }
}