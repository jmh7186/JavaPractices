import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		Sungjuk sj=new Sungjuk();
		System.out.println(sj.toString());
		//입력, 출력, 수정, 삭제기능(학생, 성적) 8개의 기능을 이용해보자(test)
		sj.infoInsert("2001001","홍길동"); //함수의 기능을 이용하여 입력
		sj.scoreInsert(100, 90, 80);
		sj.infoSelect();
		sj.scoreSelect();
		sj.infoUpdate("홍기동");
		sj.scoreUpdate(100, 100, 80);
		sj.infoDelete();
		sj.scoreDelete();
		System.out.println(sj.toString());
		*/
		Scanner scan=new Scanner(System.in);
		Sungjuk[] sj=new Sungjuk[100];
		int index=0;
		String id="";
		String name="";
		
		FileReader in=new FileReader("data.txt");
		BufferedReader br=new BufferedReader(in);
		String data=null;
		
		while((data=br.readLine())!=null) {
			String[] s=data.split(" ");
			sj[index++]=new Sungjuk(s[0],s[1],Integer.parseInt(s[2]),Integer.parseInt(s[3]),Integer.parseInt(s[4]));
		}
		br.close();
		in.close();
		
		for(Sungjuk imsi:sj) {
			if(imsi==null)break;
			System.out.println(imsi.toString());
		}
		System.out.println(index); //파일에서 데이터를 읽어오고 나서 다음 입력할 번호
		
		while(true) {
		System.out.println("-------------------");
		System.out.println("1.학생정보 입력"); 
		System.out.println("2.학생정보 출력"); 
		System.out.println("3.학생정보 수정"); 
		System.out.println("4.학생정보 삭제"); 
		System.out.println("0.프로그램 종료"); 
		System.out.println("-------------------");
		
		int sel=System.in.read()-48; //메뉴선택
		while(System.in.available()>0) {
			System.in.read();
		}
		
		switch(sel) {
		//학생정보입력
		case 1: 
			
			System.out.println("학번을 입력하세요.");
			id=scan.nextLine();
			System.out.println("이름을 입력하세요.");
			name=scan.nextLine();
			//sj[index]=new Sungjuk(); //or 
			sj[index++]=new Sungjuk(id, name);
			//sj[index++].infoInsert(id, name); 
			break;
		//학생정보출력
		case 2: 
			for(int i=0;i<index;i++) {
			sj[i].infoSelect(); 
			}
			break;
		//학생정보수정(학번을 찾고, 수정할 값을 입력받아 처리)
		case 3: 
			System.out.println("찾을 학번을 입력하세요.");
			id=scan.nextLine();
			for(int i=0;i<index;i++) {
				if(sj[i].getId().equals(id)) {
					System.out.println("이름을 입력하세요.");
					name=scan.nextLine();
					sj[i].infoUpdate(name); 
					System.out.println("이름이 수정되었습니다.");
				}
			}
			break;
		//학생정보삭제
		//case 4: sj[index].infoDelete();; break;
		}
		}
		
	}

}
