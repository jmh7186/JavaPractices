package myprotocol;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
class FrameAgent extends Frame implements WindowListener, ActionListener{
	Button slogbtn;
	TextArea view;
	//�ʿ��� ����
	//������ �̺�Ʈ ���(�ݱ�) : WindowListener / addWindowListener(this);
	//��ư�̺�Ʈ ��� : ActionListener / slogbtn.addActionListener(this);
	//��ư�� Ŭ���ϸ� �����αױ�� ���
	public FrameAgent() {
		setBounds(100,100,400,500);
		setLayout(new FlowLayout());
		setBackground(Color.GRAY);
		slogbtn=new Button("���� ���۽ð� �α���ȸ");
		view=new TextArea(20,50);
		view.setEditable(false);
		add(slogbtn);
		add(view);
		setVisible(true);
		addWindowListener(this);
		slogbtn.addActionListener(this);
	}
	
	
	public String[] serverLogList() {
		String[] result=new String[100];
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn
			=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
			Statement stmt=conn.createStatement();
			String sql="select * from logtable where kind='server'";
			ResultSet rs=stmt.executeQuery(sql);
			
			int i=0;
			while(rs.next()) {
				result[i++]=rs.getString("contime");
			}
			rs.close();
			stmt.close();
			conn.close();
			return result;
		}catch(Exception e) {return result;}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("���� ���۽ð� �α���ȸ")) {
			//view.setText("test");
			for(String imsi:serverLogList()) {
				if(imsi==null) break;
				view.setText(view.getText()+"\r\n"+imsi);
			}
		}
		
	}


	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
		
	}


	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
public class FrameMain {

	public static void main(String[] args) {
		new FrameAgent();
		/*
		FrameAgent agent=new FrameAgent();
		String[] result=agent.serverLogList();
		
		int i=0;
		while(true) {
			if(result[i]==null) break;
			System.out.println(result[i]);
			i++;
		}
		*/

	}

}
