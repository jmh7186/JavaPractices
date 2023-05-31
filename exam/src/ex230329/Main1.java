package ex230329;

public class Main1 {

	public static void main(String[] args) {
		String[] lang= {"java","c","vb","javascript","html"};
		System.out.println(lang[0]);
		System.out.println(lang[1]);
		System.out.println(lang[2]);
		System.out.println(lang[3]);
		System.out.println(lang[4]);
		
		for(int i=0;i<lang.length;i++){
			System.out.println(lang[i]);
		}
		
		for(String imsi:lang) {
			System.out.println(imsi);
		}

	}

}
