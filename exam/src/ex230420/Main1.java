package ex230420;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class FlowFrame extends Frame{
	public FlowFrame() {
		//��ġȮ��, â�� ũ��
		setBounds(100, 100, 400, 400);
		//ȭ���� �����ֱ�
		setVisible(true);
		//â�ȿ� �������� ��ư, ����â, üũ���ڵ��� ������ ���� �帧
		setLayout(new FlowLayout());
		//��ư �߰�(������Ʈ �߰�)
		add(new Button("OK"));
	}
}

//����. ��ư�� 20�� �߰��� FlowFrame1Ŭ������ �ۼ��ϼ���.
class FlowFrame1 extends Frame{
	public FlowFrame1() {
		//��ġȮ��, â�� ũ��
		setBounds(100, 100, 400, 400);
		//ȭ���� �����ֱ�
		setVisible(true);
		//â�ȿ� �������� ��ư, ����â, üũ���ڵ��� ������ ���� �帧
		setLayout(new FlowLayout());
		//��ư �߰�(������Ʈ �߰�)
		for(int i=0;i<20;i++) {
		add(new Button("OK"));
		}
	}
}

class FlowFrame3 extends Frame{
	Button okbtn;
	public FlowFrame3() {
		//��ġȮ��, â�� ũ��
		setBounds(100, 100, 400, 400);
		//ȭ���� �����ֱ�
		setVisible(true);
		//â�ȿ� �������� ��ư, ����â, üũ���ڵ��� ������ ���� �帧
		setLayout(new FlowLayout());
		//��ư �߰�(������Ʈ �߰�)
		okbtn=new Button("OK");
		add(okbtn);
		//��ư�� � ������ �����ϱ� ���ؼ� ���۸����ʸ� ����ϴ� �۾�
		//(�߰������� ������ �����ϴ� �Լ��� ����)
		okbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("��ư����");
				System.out.println(e.getActionCommand());
				System.out.println(e.getID());
				System.out.println(e.getSource());
				System.exit(0);
				
			}
		});
	}
}

class FlowFrame4 extends Frame implements ActionListener{
	Button okbtn;
	public FlowFrame4() {
		//��ġȮ��, â�� ũ��
		setBounds(100, 100, 400, 400);
		//ȭ���� �����ֱ�
		setVisible(true);
		//â�ȿ� �������� ��ư, ����â, üũ���ڵ��� ������ ���� �帧
		setLayout(new FlowLayout());
		//��ư �߰�(������Ʈ �߰�)
		okbtn=new Button("OK");
		add(okbtn);
		//��ư�� � ������ �����ϱ� ���ؼ� ���۸����ʸ� ����ϴ� �۾�
		//(�߰������� ������ �����ϴ� �Լ��� ����)
		okbtn.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
		
	}
}

class FlowFrame5 extends Frame implements ActionListener{
	Button okbtn;
	Button exitbtn;
	public FlowFrame5() {
		//��ġȮ��, â�� ũ��
		setBounds(100, 100, 400, 400);
		//ȭ���� �����ֱ�
		setVisible(true);
		//â�ȿ� �������� ��ư, ����â, üũ���ڵ��� ������ ���� �帧
		setLayout(new FlowLayout());
		//��ư �߰�(������Ʈ �߰�)
		okbtn=new Button("OK");
		exitbtn=new Button("EXIT");
		add(okbtn);
		add(exitbtn);
		//��ư�� � ������ �����ϱ� ���ؼ� ���۸����ʸ� ����ϴ� �۾�
		//(�߰������� ������ �����ϴ� �Լ��� ����)
		okbtn.addActionListener(this);
		exitbtn.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		
		switch(e.getActionCommand()) {
		case "OK": System.out.println("OK ��ư Ŭ��"); break;
		case "EXIT": System.out.println("EXIT ��ư Ŭ��"); break;
		
		}
		
	}
}

//����. �ڹ��������� �̿��Ͽ� ũ��, cmdâ, ����, �ѱ��� �����ϴ� ���α׷��� �ۼ��ϼ���.
//Runtime.getRuntime().exec("");Ȱ��
class FlowFrame6 extends Frame implements ActionListener{
	
	Button cmdbtn;
	Button chromebtn;
	Button excelbtn;
	Button hwpbtn;
	
	public FlowFrame6() {
		setBounds(100, 100, 400, 300);
		setVisible(true);
		setLayout(new FlowLayout());
		cmdbtn=new Button("CONSOLE");
		chromebtn=new Button("CHROME");
		excelbtn=new Button("EXCEL");
		hwpbtn=new Button("HWP");
		add(cmdbtn); add(chromebtn); add(excelbtn);add(hwpbtn);
		cmdbtn.addActionListener(this);
		chromebtn.addActionListener(this);
		excelbtn.addActionListener(this);
		hwpbtn.addActionListener(this);
	}
	//�׼Ǹ����ʸ� ó���ϴ� �Լ� ������ش�.

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd="";
		switch(e.getActionCommand()) {
		case "CONSOLE" : cmd="cmd /c start"; break;
		case "CHROME" : cmd="C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe"; break;
		case "EXCEL" : cmd="C:\\Program Files (x86)\\Microsoft Office\\root\\Office16\\EXCEL.EXE"; break;
		case "HWP" : cmd="C:\\Program Files (x86)\\Hnc\\Office NEO\\HOffice96\\Bin\\Hwp.exe"; break;
		}
		
		try {
		Runtime.getRuntime().exec(cmd);
		}catch(Exception ex) {}
	}
	
}
//�������� �׼� �����ʴ� ��� �߰��ϴ°�?
//(������Ʈ �� ��ư, �ؽ�Ʈ���ڴ� ActionListener, ������ �ݱ� ó���� WindowListener�������)
class FlowFrame7 extends Frame implements WindowListener{
	public FlowFrame7() {
		setBounds(100, 100, 400, 300);
		setVisible(true);
		//������ �׼Ǹ���Ʈ �߰�
		addWindowListener(this);
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


//��ư�� ����� �Ӽ��� ���� �˾ƺ���
class FlowFrame8 extends Frame implements WindowListener, ActionListener, MouseListener{
	
	Button btn;
	
	public FlowFrame8() {
		setBounds(100, 100, 300, 400);
		setVisible(true);
		addWindowListener(this);
		//frame�� �Ӽ� ������ �Լ��� ���� �̷������.
		setBackground(Color.cyan); //���� ����
		setTitle("���� ���� ������");
		setSize(500, 500);
		
		btn=new Button("button");
		btn.setBackground(Color.GREEN);
		add(btn);
		setLayout(new FlowLayout());
		btn.setSize(100, 50); //���̾ƿ��� ���� ��ȭ�Ƿ� ���̾ƿ� ���� �� ���
		btn.setLabel("���");
		btn.addActionListener(this);
		btn.addMouseListener(this);
				
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("���")) {
			btn.setLabel("���");
			btn.setBackground(Color.RED);
		}else {
			btn.setLabel("���");
			btn.setBackground(Color.GREEN);
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

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		btn.setBackground(Color.orange);
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		btn.setBackground(Color.pink);
		
	}

	
	
}

class FlowFrame9 extends Frame implements WindowListener, ActionListener{
	TextField text;
	Button btn;
	Label label;
	public FlowFrame9() {
		//�⺻�� ����(���̾ƿ�����, ������ ũ�⼳��, ������ ���̱� ����, ������ ó�� ����)
		setLayout(new FlowLayout());
		setBounds(100, 100, 300, 400);
		setVisible(true);
		addWindowListener(this);
		
		//�ؽ�Ʈ�Է»��� ��ǰ ����, �����쿡 �߰�
		text=new TextField(20);
		add(text);
		
		//��ư���� ��ǰ ����, �����쿡 �߰�, ����ó��
		btn=new Button("����");
		add(btn);
		btn.addActionListener(this);
		
		//���̺� ��ǰ ����, ������, ���ֱ�, �����쿡 �߰�
		label=new Label();
		label.setSize(300, 200);
		label.setText("���Ⱑ ���̺��̿���");
		add(label);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("����")){
			//���۹�ư�� Ŭ���ϸ� �ؽ�Ʈ������ ������ ���̺� ǥ���϶�
			label.setText(text.getText());
			//�����Ŀ� text���ڴ� �����ϰ� �����
			text.setText("");
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


public class Main1 {

	public static void main(String[] args) {
		new FlowFrame9();
	}
}
