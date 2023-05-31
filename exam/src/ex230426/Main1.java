package ex230426;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println("�����ͺ��̽��� ������ �� �����ϴ�.");
		//����Ŭ DB�����ϱ� ���� �غ����
		//1.����̹����ϱ�(���̺귯��)
		//C:\app\admin\product\21c\dbhomeXE\jdbc\lib\ojdbc8.jar ������ �����Ͽ�
		//��Ŭ������ lib������ �ٿ��ֱ� �Ѵ�.
		//���̺귯�� ���(������Ʈ �������콺 Ŭ��-build path-configure build path/���̺귯�� ���)
				
		//2.���α׷����� ����̹� �ε�
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//3.�����ͺ��̽� ����(�ʿ��ѻ���:�ּ�, �����, ��й�ȣ)
		Connection conn
		=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
		System.out.println(conn);
		if(conn==null) {
			System.exit(0);
		}
		
		//4.�����ͺ��̽� ���
		Statement stat=conn.createStatement();
		/* ���̺� ���� */
		//String sql="create table TimeWrite(condate varchar2(50))";
		//stat.execute(sql);
		//conn.commit(); //�ڵ� commit�̹Ƿ� ������ �ʿ䰡 ����
		
		/* ���̺� �Է� */
		//stat.execute("insert into TimeWrite values('2023-04-26:10:24:15')");
		
		/* ���̺� ��� */
		ResultSet rs=stat.executeQuery("select * from timewrite");
		while(rs.next()) {
			String condate=rs.getString("condate");
			System.out.println(condate);
		}
			
		
		
		
	}

}
