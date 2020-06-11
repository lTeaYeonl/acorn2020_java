package test.frame1;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame2 extends JFrame{
	// 생성자
	public MyFrame2(String title) {
		super(title);
		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
		// 레이아웃 매니저를 BorderLayout으로 지정하기
		setLayout(new BorderLayout());
		
		JButton btn1=new JButton("버튼1");
		add(btn1, BorderLayout.NORTH);
		
		JButton btn2=new JButton("버튼2");
		add(btn2, BorderLayout.WEST);
		
		JButton btn3=new JButton("버튼3");
		add(btn3, BorderLayout.EAST);
		
		JButton btn4=new JButton("버튼4");
		add(btn4, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new MyFrame2("나의 프레임!!!");
	}
}
