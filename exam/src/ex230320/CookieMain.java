package ex230320;

public class CookieMain{
 public static void main(String[] args) throws InterruptedException{
	/*
	Cookie c1=new Cookie();
	c1.name="맛있는 쿠키";
	c1.go();
	c1.back();
	*/
	
	/* 추가한 go기능 실행하기*/
	/*
	Cookie c1=new Cookie();
	c1.name="jeon 쿠키";
	c1.go(20);
	c1.go(10);
	c1.go(0);
	*/

	/* go기능 반복하기 */
	Cookie c1=new Cookie();
	c1.name="jeon 쿠키";
	
	//Runtime.getRuntime().exec("cmd /c cls");
	//https://202psj.tistory.com/1506 


	for(int step=0;step<30;step++){
		c1.go(step);
		Thread.sleep(100);
	}
 }
}