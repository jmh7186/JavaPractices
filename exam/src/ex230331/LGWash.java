package ex230331;

public class LGWash implements Wash{
	int speed;
	
	public LGWash() {
		speed=60;
	}
	@Override
	public void startButton() {
		System.out.println("LG¼¼Å¹±â ½ÃÀÛ");
		
	}

	@Override
	public void stopButton() {
		System.out.println("LG¼¼Å¹±â Á¤Áö");
		
	}

	@Override
	public void pauseButton() {
		System.out.println("LG¼¼Å¹±â ÀÏ½ÃÁ¤Áö");
		
	}

	@Override
	public void changeButton(int speed) {
		if(speed>=10 && speed<=100)	this.speed=speed;
		else this.speed=60;
		System.out.println("LG¼¼Å¹±â ¼Óµµ:"+this.speed+"º¯°æ");
	}
	
	public void dry() {
		System.out.println("LG¼¼Å¹±â °ÇÁ¶");
	}
	

}
