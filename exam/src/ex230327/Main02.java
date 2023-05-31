package ex230327;

public class Main02 {

	public static void main(String[] args) {
		//상태변수를 활용하여 찾은 상태를 확인하는 방법
		int[] data= {100,200,36,100,125,324};
		int search=10;
		//상태변수만들기
		boolean flag=false;
		
		for(int i=0;i<data.length;i++) {
			if(search==data[i]) {
				System.out.println("값을 찾았습니다.");
				flag=true;
			}
		}
		
		if(!flag) System.out.println("찾는 값이 없습니다.");
		
	}

}
