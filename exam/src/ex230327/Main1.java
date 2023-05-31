package ex230327;

import java.io.IOException;
import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) throws IOException {
		Phonebook[] pb=new Phonebook[100];
		Scanner scan=new Scanner(System.in);
		int index=0;
		String name;
		String hp;
		String search;
		boolean flag;
		
		while(true) {
			
			
			switch(menu()) {
				
				case 1: //개별입력
					System.out.println("이름과 전화번호를 입력하세요.(예 홍길동 011-1111-1111");
					name=scan.next();
					hp=scan.next();
					pb[index]=new Phonebook(name, hp);
					index=index+1;
					System.out.println("전화번호부에 입력이 되었습니다.");
					System.out.println("(다음으로 넘기려면 엔터키를 쳐주세요.)");
					break;
				case 2:
					System.out.println("---------------");
					System.out.println("  이름  전화번호");
					System.out.println("---------------");
					for(int i=0;i<index;i++) {
						if(!(pb[i].name.equals("")))
						System.out.printf("%s %s\n",pb[i].name, pb[i].hp);
					}
					System.out.println("---------------"); 
					System.out.println("(다음으로 넘기려면 엔터키를 쳐주세요.)");
					break;
				case 3: // 찾기값입력-전체데이터를 찾는값과 비교를 하는것
					System.out.println("찾는 이름을 입력하세요.");
					search=scan.nextLine();
					flag=false;
					//pb.length사용할 경우 null이 있으면 오류발생
					for(int i=0;i<index;i++) { 
						if(pb[i].name.equals(search)) { 
							System.out.println("찾는 전화번호는:"+pb[i].hp);
							flag=true;
							break;
						}
						
					}
					
					if(!flag) System.out.println("찾는 이름이 없습니다.");
					break;
				case 4: //수정->찾기->index를 이용하여 수정 pb[index].hp변경
					System.out.println("수정할 이름을 입력하세요.");
					search=scan.nextLine();
					flag=false;
					
					for(int i=0;i<index;i++) { 
						if(pb[i].name.equals(search)) { 
							//변경사항을 입력받아 처리
							System.out.println("변경할 전화번호를 입력하세요.");
							hp=scan.nextLine();
							pb[i].hp=hp; //pb[i].setHp(hp);
							flag=true;
							System.out.println("정보가 수정되었습니다.");
							break;
						}
					}
					if(!flag) System.out.println("수정할 이름이 없습니다.");
					break;
					
				case 5://삭제->찾기->index를 이용하여 삭제
					   //1)pb[i]=null; 2)pb[i].name="", pb[i].hp=""
					System.out.println("삭제할 이름을 입력하세요.");
					search=scan.nextLine();
					flag=false;
					
					for(int i=0;i<index;i++) { 
						if(pb[i].name.equals(search)) { 
							//pb[i]=null;
							pb[i].hp="";
							pb[i].name="";
							flag=true;
							System.out.println("정보가 삭제되었습니다.");
							break;
						}
					}
					if(!flag) System.out.println("삭제할 이름이 없습니다.");
					break;
			}
			
			System.in.read();
			while(System.in.available()>0) {
				System.in.read();
			}
		
		}

	}

	static int menu() throws IOException {
		//전체에서 개별만을 처리하기위해서는 [찾기]
		System.out.println("-------------------");
		System.out.println("1.전화번호부 입력"); //개별입력
		System.out.println("2.전화번호부 전체 출력"); //전체출력, 개별출력
		System.out.println("3.전화번호부 개별 출력");
		System.out.println("4.전화번호부 수정"); //개별수정
		System.out.println("5.전화번호부 삭제"); //개별삭제
		System.out.println("-------------------");
		int sel=System.in.read()-48;
		while(System.in.available()>0) {
			System.in.read();
		}
		return sel;
	
	}
}
