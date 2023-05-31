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
		System.out.printf("%d인치 %d컬러\n",size,color);
	}
}
