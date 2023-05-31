package ex230330;

class Pay{
	int ppp;
	public void payRefer(Pay p){ //1000번지
		p.ppp = p.ppp + 2000;
	}
	public void payValue(int i){
		i = i + 2000;
	}
}


public class Main2{

	public static void main(String[] args) {
		Pay p = new Pay(); //1000번지
		p.ppp = 10;
		
		int i = 10;
		
		p.payRefer(p); //1000번지	//call by reference로 전달
		p.payValue(i);	//call by value로 전달
		
		System.out.println(p.ppp); //객체가 변경되서 2010
		System.out.println(i);//10
	}
	

}