import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		Sungjuk sj=new Sungjuk();
		System.out.println(sj.toString());
		//�Է�, ���, ����, �������(�л�, ����) 8���� ����� �̿��غ���(test)
		sj.infoInsert("2001001","ȫ�浿"); //�Լ��� ����� �̿��Ͽ� �Է�
		sj.scoreInsert(100, 90, 80);
		sj.infoSelect();
		sj.scoreSelect();
		sj.infoUpdate("ȫ�⵿");
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
		System.out.println(index); //���Ͽ��� �����͸� �о���� ���� ���� �Է��� ��ȣ
		
		while(true) {
		System.out.println("-------------------");
		System.out.println("1.�л����� �Է�"); 
		System.out.println("2.�л����� ���"); 
		System.out.println("3.�л����� ����"); 
		System.out.println("4.�л����� ����"); 
		System.out.println("0.���α׷� ����"); 
		System.out.println("-------------------");
		
		int sel=System.in.read()-48; //�޴�����
		while(System.in.available()>0) {
			System.in.read();
		}
		
		switch(sel) {
		//�л������Է�
		case 1: 
			
			System.out.println("�й��� �Է��ϼ���.");
			id=scan.nextLine();
			System.out.println("�̸��� �Է��ϼ���.");
			name=scan.nextLine();
			//sj[index]=new Sungjuk(); //or 
			sj[index++]=new Sungjuk(id, name);
			//sj[index++].infoInsert(id, name); 
			break;
		//�л��������
		case 2: 
			for(int i=0;i<index;i++) {
			sj[i].infoSelect(); 
			}
			break;
		//�л���������(�й��� ã��, ������ ���� �Է¹޾� ó��)
		case 3: 
			System.out.println("ã�� �й��� �Է��ϼ���.");
			id=scan.nextLine();
			for(int i=0;i<index;i++) {
				if(sj[i].getId().equals(id)) {
					System.out.println("�̸��� �Է��ϼ���.");
					name=scan.nextLine();
					sj[i].infoUpdate(name); 
					System.out.println("�̸��� �����Ǿ����ϴ�.");
				}
			}
			break;
		//�л���������
		//case 4: sj[index].infoDelete();; break;
		}
		}
		
	}

}
