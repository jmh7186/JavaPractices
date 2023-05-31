package ex230419;
class Job extends Thread{
	String name;
	public Job(String name) {
		this.name=name;
	}
	
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println(name+":"+i);
		}
	}
}
public class Main2 {

	public static void main(String[] args) {
		Job j1=new Job("È«±æµ¿");
		Job j2=new Job("±è¹Î¼ö");
		Job j3=new Job("ÀÌÈÄ³ª");
		j1.start();
		j2.start();
		j3.start();
	}

}
