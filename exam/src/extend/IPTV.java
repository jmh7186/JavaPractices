package extend;

public class IPTV extends ColorTV {
	String ip;
	public IPTV(String ip,int size,int color) {
		this.ip=ip;
		this.size=size;
		//super(size,color); //���࿡ �θ�Ŭ������ �⺻�����ڰ� ���� ��� super()�Լ��� �̿��Ͽ� ó���ؾ���
		this.color=color;
		//Ŭ������ ���� �� �ݵ�� �⺻�����ڴ� ����� �����ϴ� ������ �淯����.
	}
	@Override
	public void print() {
		System.out.printf("ip�ּ�:%s, %d��ġ, %d�÷�\n",ip, size, color);
	}
	
}
