package ex230331;

public class LGWash implements Wash{
	int speed;
	
	public LGWash() {
		speed=60;
	}
	@Override
	public void startButton() {
		System.out.println("LG��Ź�� ����");
		
	}

	@Override
	public void stopButton() {
		System.out.println("LG��Ź�� ����");
		
	}

	@Override
	public void pauseButton() {
		System.out.println("LG��Ź�� �Ͻ�����");
		
	}

	@Override
	public void changeButton(int speed) {
		if(speed>=10 && speed<=100)	this.speed=speed;
		else this.speed=60;
		System.out.println("LG��Ź�� �ӵ�:"+this.speed+"����");
	}
	
	public void dry() {
		System.out.println("LG��Ź�� ����");
	}
	

}
