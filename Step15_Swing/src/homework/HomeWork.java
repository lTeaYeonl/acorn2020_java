package homework;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class HomeWork extends JFrame{
//	JTextField = 10
//	JButton = +-*/
//	= 20 = JLabel
//	10 +-*/ 10 = 20
	
	// default 생성자
	public HomeWork() {
		// 레이아웃 설정
		setLayout(new FlowLayout(FlowLayout.LEFT));
		// 문자열을 입력할 수 있는 JTextField
		JTextField inputNum1=new JTextField(10);
		JTextField inputNum2=new JTextField(10);
		// 연산 기능을 해줄 버튼 생성
		JButton addBtn=new JButton("+");
		JButton subBtn=new JButton("-");
		JButton timesBtn=new JButton("*");
		JButton dividedBtn=new JButton("/");
		// jLabel 객체 생성
		JLabel equals=new JLabel("=");
		JLabel answer=new JLabel("연산결과를 보여줄 jLabel");
		// 프레임에 담아준다.
		add(inputNum1);
		add(addBtn);
		add(subBtn);
		add(timesBtn);
		add(dividedBtn);
		add(inputNum2);
		add(equals);
		add(answer);
	}
	
	public static void main(String[] args) {
		// HomeWork 클래스를 이용해서 객체를 생성하고 참조값을 지역변수 HFrame 에 대입
		HomeWork HFrame=new HomeWork();
		// 프레임의 제목 설정
		HFrame.setTitle("산술연산을 할 수 있는 Frame.06.14 과제");
		// 프레임을 닫으면 자동으로 프로세스가 종료되도록 한다.
		HFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 프레임의 위치, 크기 지정
		HFrame.setBounds(300, 300, 700, 300);
		// 프레임이 보이도록 설정
		HFrame.setVisible(true);
	}
}
