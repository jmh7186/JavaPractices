package ex230331;

public class SamsungWash implements Wash{
	int speed;
	
	public SamsungWash() {
		speed=50;
	}
	@Override
	public void startButton() {
		System.out.println("Samsung¼¼Å¹±â ½ÃÀÛ");
		
	}

	@Override
	public void stopButton() {
		System.out.println("Samsung¼¼Å¹±â Á¤Áö");
		
	}

	@Override
	public void pauseButton() {
		System.out.println("Samsung¼¼Å¹±â ÀÏ½ÃÁ¤Áö");
		
	}

	@Override
	public void changeButton(int speed) {
		if(speed>=10 && speed<=100)	this.speed=speed;
		else this.speed=50;
		System.out.println("Samsung¼¼Å¹±â ¼Óµµ:"+this.speed+"º¯°æ");
	}
	
	public void dry() {
		System.out.println("Samsung¼¼Å¹±â °ÇÁ¶");
	}
	
	public void clean() {
		System.out.println("Samsung¼¼Å¹±â ¼¼Ã´");
	}

}
