package ex230330;

class Pay{
	int ppp;
	public void payRefer(Pay p){ //1000����
		p.ppp = p.ppp + 2000;
	}
	public void payValue(int i){
		i = i + 2000;
	}
}


public class Main2{

	public static void main(String[] args) {
		Pay p = new Pay(); //1000����
		p.ppp = 10;
		
		int i = 10;
		
		p.payRefer(p); //1000����	//call by reference�� ����
		p.payValue(i);	//call by value�� ����
		
		System.out.println(p.ppp); //��ü�� ����Ǽ� 2010
		System.out.println(i);//10
	}
	

}