package ex230327;

public class Main04 {

	public static void main(String[] args) {
		//상태변수를 활용하여 찾은 상태를 확인하는 방법
		int[] data= {100,200,36,100,125,324};
		int search=100;
		//상태변수만들기
		boolean flag=false;
		//몇개가 검색되었는지 확인(카운터 알고리즘)
		int cnt=0;
		
		for(int i=0;i<data.length;i++) {
			if(search==data[i]) {
				System.out.println(data[i]);
				cnt=cnt+1;
				flag=true;
			}
		}
		
		if(!flag) System.out.println("찾는 값이 없습니다.");
		System.out.println("찾은갯수:"+cnt);
		
	}

}
