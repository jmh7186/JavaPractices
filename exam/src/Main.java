import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		FileReader in=new FileReader("data3.txt");
		BufferedReader br=new BufferedReader(in);
		/*
		for(int i=0;i<5;i++) {
		String data=br.readLine();
		System.out.println(data);
		}
		*/
		Person[] p=new Person[100];
		
		/*
		String data=br.readLine();
		System.out.println(data);
		String[] s=data.split(" ");
		System.out.println(s[0]);
		System.out.println(s[1]);
		p[0]=new Person(s[0],Integer.parseInt(s[1]));
		System.out.println(p[0].toString());
		*/
		
		String data=null;
		int index=0;
		while((data=br.readLine())!=null) {
			String[] s=data.split(" ");
			p[index]=new Person(s[0],Integer.parseInt(s[1]));
			index=index+1;
		}
		
				
		for(int i=0;i<index;i++) {
			System.out.println(p[i].toString());
		}
		br.close();

	}

}
