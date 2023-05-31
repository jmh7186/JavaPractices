package extend;

public class IPTV extends ColorTV {
	String ip;
	public IPTV(String ip,int size,int color) {
		this.ip=ip;
		this.size=size;
		//super(size,color); //만약에 부모클래스가 기본생성자가 없을 경우 super()함수를 이용하여 처리해야함
		this.color=color;
		//클래스를 만들 때 반드시 기본생성자는 만들고 시작하는 습관을 길러야함.
	}
	@Override
	public void print() {
		System.out.printf("ip주소:%s, %d인치, %d컬러\n",ip, size, color);
	}
	
}
