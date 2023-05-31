package ex230322;

public class Cal {
	int su1;
	int su2;
	
	int add(int su1, int su2){
		int result=su1+su2;
		return result;
	}
	
	int minus(int su1, int su2) {
		return su1-su2;
	}
	
	int mux(int su1, int su2) {
		return su1*su2;
	}
	
	float div(int su1, int su2) {
		return (float)su1/su2;
	}
	
}
