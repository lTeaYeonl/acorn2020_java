package test.frame8;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener {
	// 필드 정의
	JTextField inputMsg;
	
	// default 생성자
	public MyFrame() {
		setLayout(new FlowLayout());
		inputMsg=new JTextField(10);
		add(inputMsg);
		
		JButton sendBtn=new JButton("전송");
		sendBtn.addActionListener(this);
		add(sendBtn);
		
	}
	
	public static void main(String[] args) {
		// MyFrame 클래스를 이용해서 객체 생성하고 참조값을 지역변수 frame 에 담기
		MyFrame frame=new MyFrame();
		// 창을 닫으면 자동으로 프로세스가 종료 되도록 한다.
		// 프레임의 제목 설정
		frame.setTitle("나의 프레임");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 500, 500);
		frame.setVisible(true);
	}
	// ActionListener 인터페이스를 구현해서 강제 오버라이드 된 메소드
	@Override
	public void actionPerformed(ActionEvent e) {
		String tmp = inputMsg.getText();
		JOptionPane.showMessageDialog(this, tmp );
	}
}
