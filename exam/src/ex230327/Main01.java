package ex230327;

public class Main01 {

	public static void main(String[] args) {
		// 찾기알고리즘
		//1. 숫자찾기
		//준비사항 : 여러개의 데이터 필요, 찾을 값(검색값), 데이터 전체 반복
		int[] data= {100,200,36,100,125,324};
		int search=10;
				
		for(int i=0;i<data.length;i++) {
			if(search==data[i]) {
				System.out.println("값을 찾았습니다.");
				}
		}
		
		//고려사항
		//데이터중복(데이터가 중복된 데이인가 아닌가에 따라 코드 달라짐)
		//찾는 값중 비슷한 값을 처리해할 경우
		//값을 못찾을 경우 어떻게 처리할 것인가?

	}

}
