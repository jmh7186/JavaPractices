package ex230331;

public class SamsungWash implements Wash{
	int speed;
	
	public SamsungWash() {
		speed=50;
	}
	@Override
	public void startButton() {
		System.out.println("Samsung��Ź�� ����");
		
	}

	@Override
	public void stopButton() {
		System.out.println("Samsung��Ź�� ����");
		
	}

	@Override
	public void pauseButton() {
		System.out.println("Samsung��Ź�� �Ͻ�����");
		
	}

	@Override
	public void changeButton(int speed) {
		if(speed>=10 && speed<=100)	this.speed=speed;
		else this.speed=50;
		System.out.println("Samsung��Ź�� �ӵ�:"+this.speed+"����");
	}
	
	public void dry() {
		System.out.println("Samsung��Ź�� ����");
	}
	
	public void clean() {
		System.out.println("Samsung��Ź�� ��ô");
	}

}
