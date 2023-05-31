package ex230327;

public class Main9 {

	public static void main(String[] args) {
		 int[][] m = {{1,10},{2,10},{3,10}};
		 //안에 { }는 한 묶음, 밖에 { } 몇개인가?
		 System.out.println(m[0]); //1번째 묶음
		 System.out.println(m[0][0]); //1번째 묶음의 1번째 값 
		 System.out.println(m[0][1]); //1번째 묶음의 2번째 값
		 
		 String[][] phonebook 
		 = {{"홍길동","1111"},{"박길동","2222"},{"이길동","3333"}};
		 System.out.println(phonebook[0][0]); //1번째 묶음의 1번째 값 
		 System.out.println(phonebook[0][1]); //1번째 묶음의 2번째 값
		 
		 int[][] xy = {{10,0},{30,0},{50,0}};
		 for(int i=0;i<3;i++)
		  System.out.println(xy[i][0]);
		 
		 int[][] m2 = new int[3][2];
		 m2[0][0] = 10;
	     m2[0][1] = 20;
	     m2[1][0] = 30;
	     m2[1][1] = 40;
	     m2[2][0] = 50;
	     m2[2][1] = 60;
	        
	    
	      for(int i=0; i<3; i++) {     //행
	         for(int j=0; j<2;j++) {   //열
	            System.out.println("m[" + i + "]n[" + j + "]=" + m[i][j]);
	         }
	      }

	}

}
