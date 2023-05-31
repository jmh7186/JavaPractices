package ex230419;
class Gen{
	int start;
	int end;
	public Gen(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	public void start() {
		for(int i=start;i<=end;i++) {
			System.out.println(i);
		}
	}
}

class ThreadGen extends Thread{
	int start;
	int end;
	public ThreadGen(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	public void run() {
		for(int i=start;i<=end;i++) {
			System.out.println(i);
		}
	}
}
public class Main1 {

	public static void main(String[] args) {
		/*
		number1();
		number2();
		number3();
		*/
		/*
		Gen g1=new Gen(0, 100);
		Gen g2=new Gen(100, 200);
		Gen g3=new Gen(200, 300);
		g1.start();
		g2.start();
		g3.start();
		*/
		ThreadGen g1=new ThreadGen(0, 100);
		ThreadGen g2=new ThreadGen(100, 200);
		ThreadGen g3=new ThreadGen(200, 300);
		g1.start();
		g2.start();
		g3.start();
	}
	
	public static void number1() {
		for(int i=0;i<100;i++) {
			System.out.println(i);
		}
	}
	
	public static void number2() {
		for(int i=100;i<200;i++) {
			System.out.println(i);
		}
	}
	
	public static void number3() {
		for(int i=200;i<300;i++) {
			System.out.println(i);
		}
	}
}
