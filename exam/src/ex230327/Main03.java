package ex230327;

public class Main03 {

	public static void main(String[] args) {
		//상태변수를 활용하여 찾은 상태를 확인하는 방법
		int[] data= {100,200,36,100,125,324};
		int search=324;
		
		int i;
		
		for(i=0;i<data.length;i++) {
			if(search==data[i]) {
				System.out.println("값을 찾았습니다.");
				break;//단일값일 때 사용
			}
		}
		
		if(i==6) {System.out.println("찾는값이 없습니다.");}
		
		
		
	}

}
