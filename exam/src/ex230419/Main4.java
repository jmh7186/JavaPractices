package ex230419;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

class FileCopy implements Runnable{
	String source;
	String dest;
	public FileCopy(String source, String dest) {
		this.source = source;
		this.dest = dest;
	}
	
	public void run(){
		try {
		FileInputStream in=new FileInputStream(source);
		FileOutputStream out=new FileOutputStream(dest);
		long inlength=in.available();
		long outlength=0;
		while(in.available()>0) {
			int data=in.read();
			out.write(data);
			out.flush();
			outlength++;
			System.out.println(dest+":"+(outlength/inlength)*100+"%");
		}
		}catch(Exception e) {}
		
	}
}

class ThreadFileCopy extends Thread{
	String source;
	String dest;
	public ThreadFileCopy(String source, String dest) {
		this.source = source;
		this.dest = dest;
	}
	
	public void run(){
		try {
		FileInputStream file=new FileInputStream(source);
		FileOutputStream out=new FileOutputStream(dest);
		long filelength=file.available();
		long outlength=0;
		while(file.available()>0) {
			int data=file.read();
			out.write(data);
			out.flush();
			outlength++;
			System.out.println(dest+":"+(outlength/filelength)*100+"%");
		}
		}catch(Exception e) {}
		
	}
}

public class Main4 {

	public static void main(String[] args) throws IOException {
     //1)파일을 a.txt -> aa.txt복사하는 스트림명령을 수행하시오.
		//FileCopy copy=new FileCopy("a.txt", "aa.txt");
		//copy.run();
		
	 //2)여러개의 파일을 동시에 같이 복사하는 스레드 제작.
		/*
		ThreadFileCopy copy1=new ThreadFileCopy("eclipse.exe","eclipse1.exe");
		ThreadFileCopy copy2=new ThreadFileCopy("eclipse.exe","eclipse2.exe");
		ThreadFileCopy copy3=new ThreadFileCopy("eclipse.exe","eclipse3.exe");
		copy1.start();
		copy2.start();
		copy3.start();
		*/
	   //3)인터페이스 Runnable을 이용하는 방법
		Thread t1=new Thread(new FileCopy("a.txt","aa.txt"));
		Thread t2=new Thread(new FileCopy("a.txt","bb.txt"));
		Thread t3=new Thread(new FileCopy("a.txt","cc.txt"));
		
	}

}
