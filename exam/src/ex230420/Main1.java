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
		//위치확인, 창의 크기
		setBounds(100, 100, 400, 400);
		//화면을 보여주기
		setVisible(true);
		//창안에 여러개의 버튼, 편집창, 체크상자등을 행으로 나열 흐름
		setLayout(new FlowLayout());
		//버튼 추가(콤포넌트 추가)
		add(new Button("OK"));
	}
}

//문제. 버튼이 20개 추가된 FlowFrame1클래스를 작성하세요.
class FlowFrame1 extends Frame{
	public FlowFrame1() {
		//위치확인, 창의 크기
		setBounds(100, 100, 400, 400);
		//화면을 보여주기
		setVisible(true);
		//창안에 여러개의 버튼, 편집창, 체크상자등을 행으로 나열 흐름
		setLayout(new FlowLayout());
		//버튼 추가(콤포넌트 추가)
		for(int i=0;i<20;i++) {
		add(new Button("OK"));
		}
	}
}

class FlowFrame3 extends Frame{
	Button okbtn;
	public FlowFrame3() {
		//위치확인, 창의 크기
		setBounds(100, 100, 400, 400);
		//화면을 보여주기
		setVisible(true);
		//창안에 여러개의 버튼, 편집창, 체크상자등을 행으로 나열 흐름
		setLayout(new FlowLayout());
		//버튼 추가(콤포넌트 추가)
		okbtn=new Button("OK");
		add(okbtn);
		//버튼에 어떤 동작을 실행하기 위해선 동작리스너를 등록하는 작업
		//(추가적으로 동작을 실행하는 함수도 구현)
		okbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼실행");
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
		//위치확인, 창의 크기
		setBounds(100, 100, 400, 400);
		//화면을 보여주기
		setVisible(true);
		//창안에 여러개의 버튼, 편집창, 체크상자등을 행으로 나열 흐름
		setLayout(new FlowLayout());
		//버튼 추가(콤포넌트 추가)
		okbtn=new Button("OK");
		add(okbtn);
		//버튼에 어떤 동작을 실행하기 위해선 동작리스너를 등록하는 작업
		//(추가적으로 동작을 실행하는 함수도 구현)
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
		//위치확인, 창의 크기
		setBounds(100, 100, 400, 400);
		//화면을 보여주기
		setVisible(true);
		//창안에 여러개의 버튼, 편집창, 체크상자등을 행으로 나열 흐름
		setLayout(new FlowLayout());
		//버튼 추가(콤포넌트 추가)
		okbtn=new Button("OK");
		exitbtn=new Button("EXIT");
		add(okbtn);
		add(exitbtn);
		//버튼에 어떤 동작을 실행하기 위해선 동작리스너를 등록하는 작업
		//(추가적으로 동작을 실행하는 함수도 구현)
		okbtn.addActionListener(this);
		exitbtn.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		
		switch(e.getActionCommand()) {
		case "OK": System.out.println("OK 버튼 클릭"); break;
		case "EXIT": System.out.println("EXIT 버튼 클릭"); break;
		
		}
		
	}
}

//문제. 자바프레임을 이용하여 크롬, cmd창, 엑셀, 한글을 실행하는 프로그램을 작성하세요.
//Runtime.getRuntime().exec("");활용
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
	//액션리스너를 처리하는 함수 만들어준다.

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
//윈도우의 액션 리스너는 어떻게 추가하는가?
//(콤포넌트 즉 버튼, 텍스트상자는 ActionListener, 윈도우 닫기 처리는 WindowListener사용해함)
class FlowFrame7 extends Frame implements WindowListener{
	public FlowFrame7() {
		setBounds(100, 100, 400, 300);
		setVisible(true);
		//윈도우 액션리스트 추가
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


//버튼의 색깔등 속성에 대해 알아본다
class FlowFrame8 extends Frame implements WindowListener, ActionListener, MouseListener{
	
	Button btn;
	
	public FlowFrame8() {
		setBounds(100, 100, 300, 400);
		setVisible(true);
		addWindowListener(this);
		//frame에 속성 변경은 함수를 통해 이루어진다.
		setBackground(Color.cyan); //배경색 설정
		setTitle("내가 만든 윈도우");
		setSize(500, 500);
		
		btn=new Button("button");
		btn.setBackground(Color.GREEN);
		add(btn);
		setLayout(new FlowLayout());
		btn.setSize(100, 50); //레이아웃에 따라 변화므로 레이아웃 설정 후 사용
		btn.setLabel("출근");
		btn.addActionListener(this);
		btn.addMouseListener(this);
				
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("출근")) {
			btn.setLabel("퇴근");
			btn.setBackground(Color.RED);
		}else {
			btn.setLabel("출근");
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
		//기본적 설정(레이아웃설정, 윈도우 크기설정, 윈도우 보이기 설정, 윈도우 처리 설정)
		setLayout(new FlowLayout());
		setBounds(100, 100, 300, 400);
		setVisible(true);
		addWindowListener(this);
		
		//텍스트입력상자 부품 생성, 윈도우에 추가
		text=new TextField(20);
		add(text);
		
		//버튼상자 부품 생성, 윈도우에 추가, 실행처리
		btn=new Button("전송");
		add(btn);
		btn.addActionListener(this);
		
		//레이블 부품 생성, 사이즈, 값넣기, 윈도우에 추가
		label=new Label();
		label.setSize(300, 200);
		label.setText("여기가 레이블이에요");
		add(label);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("전송")){
			//전송버튼을 클릭하면 텍스트상자의 내용을 레이블에 표시하라
			label.setText(text.getText());
			//전송후에 text상자는 깨끗하게 만들기
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
