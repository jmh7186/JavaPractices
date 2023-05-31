package ex230419;
class ThreadOne implements Runnable {

	private int num;
    private String name;
    
    public ThreadOne(String name, int num) {
        this.name = name;
        this.num = num;
    }
    
    public void run(){
        for(int i=0; i<num; i++)
            System.out.println(name + " : " + i);
    }
    
}
public class Main3 {

	public static void main(String[] args) {
		 Thread t1 = new Thread(new ThreadOne("first", 1000));
		 Thread t2 = new Thread(new ThreadOne("twice",1000));
		 Thread t3 = new Thread(new ThreadOne("third",1000));
		 t1.start();
		 t2.start();
		 t3.start();
		 
	}

}
