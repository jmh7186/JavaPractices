package ex230321;

public class Cal {
	//int su1;
	//int su2;
	
	//두 수를 입력받아 더하는 기능
	int add(int su1, int su2){
		int result=su1+su2;
		return result;
	}
	
	//두 수를 빼는 기능
	int minus(int su1, int su2) {
		return su1-su2;
	}
	
	//두 수를 곱하는 기능
	int mux(int su1, int su2) {
		return su1*su2;
	}
	
	float div(int su1, int su2) {
		return (float)su1/su2;
	}
	
}
