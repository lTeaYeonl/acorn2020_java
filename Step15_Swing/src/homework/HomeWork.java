package homework;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class HomeWork extends JFrame implements ActionListener{
//	JTextField = 10
//	JButton = +-*/
//	= 20 = JLabel
//	10 +-*/ 10 = 20
	
	// static final 상수
	static final String COMMAND_ADDITION="add";
	static final String COMMAND_SUBTRACTION="sub";
	static final String COMMAND_MULTIPLICATION="times";
	static final String COMMAND_DIVISION="divided";
	
	// 필드
	JTextField inputNum1;
	JTextField inputNum2;
	int num1;
	int num2;
	JLabel answer;
	String convert_sum;
	int sum;
	
	// default 생성자
	public HomeWork() {
		// 레이아웃 설정
		setLayout(new FlowLayout(FlowLayout.LEFT));
		// 문자열을 입력할 수 있는 JTextField
		inputNum1=new JTextField(10);
		inputNum2=new JTextField(10);
		// 연산 기능을 해줄 버튼 생성
		JButton addBtn=new JButton("+");
		// 버튼 액션 커맨드 지정
		addBtn.setActionCommand(COMMAND_ADDITION);
		addBtn.addActionListener(this);
		JButton subBtn=new JButton("-");
		subBtn.setActionCommand(COMMAND_SUBTRACTION);
		subBtn.addActionListener(this);
		JButton timesBtn=new JButton("*");
		timesBtn.setActionCommand(COMMAND_MULTIPLICATION);
		timesBtn.addActionListener(this);
		JButton dividedBtn=new JButton("/");
		dividedBtn.setActionCommand(COMMAND_DIVISION);
		dividedBtn.addActionListener(this);
		// jLabel 객체 생성
		JLabel equals=new JLabel("=");
		answer=new JLabel("연산결과를 보여줄 jLabel");
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

	// 버튼을 눌렀을때 실행되어질 메소드
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String command=e.getActionCommand();
			if(command.equals(COMMAND_ADDITION)) { // 덧셈
				convert();
				sum=num1+num2;
				convert2();
				reset();			
			} else if(command.equals(COMMAND_SUBTRACTION)) { // 뺼셈
				convert();
				sum=num1-num2;
				convert2();
				reset();	
			} else if(command.equals(COMMAND_MULTIPLICATION)) { // 곱셈
				convert();
				sum=num1*num2;
				convert2();
				reset();	
			} else if(command.equals(COMMAND_DIVISION)) { // 나눗셈
				convert();
				sum=num1/num2;
				convert2();
				reset();	
			}
		} catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(this, "숫자만 입력해 주세요!");
			// 예외 정보 콘솔창에 출력
			nfe.printStackTrace();
			reset();
		} catch (ArithmeticException ae) {
			JOptionPane.showMessageDialog(this, "어떤 수를 0으로 나눌 수는 없어요!");
			ae.printStackTrace();
			reset();
		} catch (Exception e1 ) {
			JOptionPane.showMessageDialog(this, "Exception이 발생했습니다!");
			reset();
		}
	}
	
	
	// JTextfield에 입력된 값을 int 타입으로 변환해주는 메소드
	public void convert() {
		if (inputNum1.getText().isEmpty() && inputNum1.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "값을 입력해 주세요!");
			reset();
			answer.setText("0");
			return;
		} else {
			String text1=inputNum1.getText();
			num1=Integer.parseInt(text1);
			String text2=inputNum2.getText();
			num2=Integer.parseInt(text2);
			}
	}
	// 컨버팅 2
	public void convert2() {
		convert_sum=String.valueOf(sum);
		answer.setText(convert_sum);
	}
	// 입력한 값을 초기화 해주는 메소드
	public void reset() {
		inputNum1.setText("");
		inputNum2.setText("");
	}
	
}