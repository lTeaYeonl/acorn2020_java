package test.frame1;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame{
	// 생성자
	public MyFrame(String title) {
		super(title);
		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 프레임의 레이아웃 매니저를 사용하지 않기 때문에 UI를 절대 좌표에 직접 배치해야 한다.
		setLayout(null);
		
		JButton btn1=new JButton("버튼1");
		// 한번에 쓰려면 setbounds
		// 버튼의 위치
		btn1.setLocation(10, 10);
		// 버튼의 크기
		btn1.setSize(100, 30);
		// 프레임에 btn1 추가하기
		add(btn1);

		JButton btn2=new JButton("버튼2");
		// 버튼의 위치와 크기를 한번에 지정하기
		btn2.setBounds(120, 10, 100, 30);
		// 프레임에 btn2 추가하기
		add(btn2);

		JButton btn3=new JButton("버튼3");
		// 버튼의 위치와 크기를 한번에 지정하기
		btn3.setBounds(230, 10, 100, 30);
		// 프레임에 btn2 추가하기
		add(btn3);
		
		JButton btn4=new JButton("버튼4");
		// 버튼의 위치와 크기를 한번에 지정하기
		btn4.setBounds(340, 10, 100, 30);
		// 프레임에 btn2 추가하기
		add(btn4);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new MyFrame("나의 프레임!!!");
	}
}
