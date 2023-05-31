package ex230418;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		//db����
		String[] id= {"20000101","20000102","20000103","20000104","20000105"};
		String[] name= {"ȫ�浿","�̱浿","�ڱ浿","���浿","���浿"};
		int[] kor= {100,90,80,70,60};
		int[] eng= {100,90,80,70,60};
		int[] math= {100,90,80,70,60};
		int position=0;
		
		ServerSocket server=new ServerSocket(9999);
		while(true) {
		System.out.println("Ŭ���̾�Ʈ ���� �����(�������α׷�)");
		Socket client=server.accept();
		System.out.println("���� ���α׷�");
		
		while(true) {
			BufferedReader in=
			new BufferedReader(new InputStreamReader(client.getInputStream()));
			String _id=in.readLine(); //���۵� �����͸� ����
			
			if(_id.equals("exit")) {
				client.close();
				System.out.println("Ŭ���̾�Ʈ ��������");
				break;
			}
			
			//�˻����Ͽ� ��ġȮ��
			for(int i=0;i<id.length;i++) {
				if(id[i].equals(_id)) {
					position=i;
					break;
				}
			}
			
			//�ش��ϴ� ��ġ�� �����͸� ���������� ������ ��.
			StringBuffer buf=new StringBuffer();
			buf.append(id[position]); buf.append(" ");
			buf.append(name[position]); buf.append(" ");
			buf.append(kor[position]); buf.append(" ");
			buf.append(eng[position]); buf.append(" ");
			buf.append(math[position]); buf.append("\n");
			
			//��û�� ������ ����
			BufferedWriter out
			=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			out.write(buf.toString());
			out.flush();
			
			
		}
		
		}

	}

}
