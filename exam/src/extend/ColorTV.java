package extend;

public class ColorTV extends TV {
	int color;
	public ColorTV() {
		// TODO Auto-generated constructor stub
	}
	public ColorTV(int size, int color) {
		this.color=color;
		this.size=size;
	}
	public void print() {
		System.out.printf("%d��ġ %d�÷�\n",size,color);
	}
}
