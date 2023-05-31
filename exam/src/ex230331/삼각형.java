package ex230331;

public class 삼각형 implements 도형{

	@Override
	public float 넓이(float 가로, float 세로) {
		return 가로*세로/2;
	}

	@Override
	public float 둘레() {
		// TODO Auto-generated method stub
		return 0;
	}

}
