package ex230502;

class ShareVar extends Thread{
	static int i = 0;
	String name;

	public ShareVar(String name) {
		this.name = name;
	}

	public void run() {
		for (int k = 0; k < 100; k++) {
			System.out.println(name+" : "+(i++));
		}
	}
}

public class Main1 {

	public static void main(String[] args) {
		ShareVar sv1 = new ShareVar("sv1");
		sv1.setPriority(1);
		ShareVar sv2 = new ShareVar("sv2");
		sv2.setPriority(10);
		sv1.start();
		sv2.start();

	}

}
