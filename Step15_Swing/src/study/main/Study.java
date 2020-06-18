package study.main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Study extends JFrame implements ActionListener { // 상속 // ActionListener
	// 필드
	JButton sendBtn=null;
	// 생성자
	public Study () {
		setLayout(new FlowLayout(FlowLayout.LEFT)); // 레이아웃
		JTextField tf=new JTextField(10); // 텍스트필드
		add(tf);
		sendBtn=new JButton("앙버튼띠"); // 버튼
		sendBtn.addActionListener(this); // ActionListener
		sendBtn.setActionCommand("send"); // ActionCommand
		add(sendBtn, BorderLayout.SOUTH); // BorderLayout
	}
	
	public static void main(String[] args) {
		Study f=new Study(); // 생성자의 객체를 받는 지역변수 생성
		f.setTitle("제목"); // 제목
		f.setBounds(100, 100, 500, 500); // 위치, 크기
		f.setDefaultCloseOperation(EXIT_ON_CLOSE); // 종료
		f.setVisible(true); // 보여지게
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command=sendBtn.getActionCommand();
		if(command.equals("send")) {
			JOptionPane.showMessageDialog(this, "send버튼을 눌렀네용");
		}
	}
}
