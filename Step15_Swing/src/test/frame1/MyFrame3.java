package test.frame1;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame3 extends JFrame{
	// 생성자
	public MyFrame3(String title) {
		super(title);
		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
		// 레이아웃 매니저를 GridLayout으로 지정하기 (2 행 2열)
		setLayout(new GridLayout(2, 2));
		
		JButton btn1=new JButton("버튼1");
		add(btn1);
		
		JButton btn2=new JButton("버튼2");
		add(btn2);
		
		JButton btn3=new JButton("버튼3");
		add(btn3);
		
		JButton btn4=new JButton("버튼4");
		add(btn4);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new MyFrame3("나의 프레임!!!");
	}
}
