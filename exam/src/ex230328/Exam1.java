package ex230328;

public class Exam1 {
	public static void main(String[] args){
		StructNumber sn=new StructNumber();
		sn.su1=Integer.parseInt(args[0]);
		sn.su2=Integer.parseInt(args[1]);
		int sum=sn.su1+sn.su2;
		System.out.println("°á°ú:"+sn.su1+sn.su2);
		}
}
