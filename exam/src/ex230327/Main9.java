package ex230327;

public class Main9 {

	public static void main(String[] args) {
		 int[][] m = {{1,10},{2,10},{3,10}};
		 //�ȿ� { }�� �� ����, �ۿ� { } ��ΰ�?
		 System.out.println(m[0]); //1��° ����
		 System.out.println(m[0][0]); //1��° ������ 1��° �� 
		 System.out.println(m[0][1]); //1��° ������ 2��° ��
		 
		 String[][] phonebook 
		 = {{"ȫ�浿","1111"},{"�ڱ浿","2222"},{"�̱浿","3333"}};
		 System.out.println(phonebook[0][0]); //1��° ������ 1��° �� 
		 System.out.println(phonebook[0][1]); //1��° ������ 2��° ��
		 
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
	        
	    
	      for(int i=0; i<3; i++) {     //��
	         for(int j=0; j<2;j++) {   //��
	            System.out.println("m[" + i + "]n[" + j + "]=" + m[i][j]);
	         }
	      }

	}

}
