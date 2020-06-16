package test.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Quiz03 extends JFrame implements ActionListener{
	// 필드
	File memoFile=null;
	FileWriter fw=null;
	JTextField tf_msg=null;
	JTextArea area=null;
	// 생성자
	public Quiz03() {
		setTitle("나의 프레임");
		
		setLayout(new BorderLayout());
		JPanel topPanel=new JPanel();
		tf_msg=new JTextField(10);

		JButton appendBtn=new JButton("추가하기");
		JButton loadBtn=new JButton("로드");

		appendBtn.setActionCommand("append");
		appendBtn.addActionListener(this);
		
		loadBtn.setActionCommand("load");
		loadBtn.addActionListener(this);
		
		topPanel.add(tf_msg);
		topPanel.add(appendBtn);
		topPanel.add(loadBtn);
		add(topPanel, BorderLayout.NORTH);
		topPanel.setBackground(Color.ORANGE);
		
		// JTextArea
		area=new JTextArea();
		// 프레임의 가운데에 JTextArea 배치하기
		add(area, BorderLayout.CENTER);
		
	}
	public static void main(String[] args) {
		Quiz03 f=new Quiz03();
		f.setBounds(100, 100, 500, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// 눌러진 버튼의 액션 command 읽어오기
		String command=e.getActionCommand();
		if (command.equals("append")) { // 저장하기 버튼을 눌렀을 때
			append();
		} else if(command.equals("load")) { // 불러오기 버튼을 눌렀을 때
			load();
		}
	}
	public void append() {
		memoFile=new File("c:/acorn2020/myFolder/quiz03.txt");
		try {
			if(!memoFile.exists()) {
				memoFile.createNewFile();
			}
			fw=new FileWriter(memoFile, true);
			fw.append(tf_msg.getText()+"\r\n");
			fw.close();
			tf_msg.setText("");
			JOptionPane.showMessageDialog(this, "저장했습니다!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void load() {
		// 1. 파일에서 문자열을 읽어와서
		// 2. JTextArea에 붙여넣기
		File memoFile=new File("c:/acorn2020/myFolder/quiz03.txt");
		// 필요한 객체의 참조값을 담을 지역변수를 미리 만든다.
		FileReader fr=null;
		BufferedReader br=null;
		try {
			if(!memoFile.exists()) {
				System.out.println("파일이 존재하지 않습니다 !");
				return; // 메소드 끝내기
			}
			// 파일에서 문자열을 읽어들일 객체
			fr=new FileReader(memoFile);
			br=new BufferedReader(fr);
			area.setText(""); // 초기화
			while(true) {
				// 반복문 돌면서 문자열을 줄단위로(개행기호 기준) 읽어오기
				String line=br.readLine();
				if(line==null) { // 더이상 읽을 문자열이 없으면
					break; // 반복문 탈출
				}
				// 읽은 문자열 JTextArea에 출력하기
				area.append(line);
				area.append("\r\n"); // 개행기호도 출력
				}
			} catch (IOException e) {
			e.printStackTrace();
		} finally { // 예외가 발생하던 안하던 반드시 실행되는 블럭
			// 마무리 작업을 한다 (보통 열었던 스트림 객체를 닫는 작업을 한다)
			try {
				// null 체크를 한 다음에 메소드를 호출해서 마무리 작업을 한다.
				if(fr!=null)fr.close();
				if(br!=null)br.close();
			} catch (IOException ie) {
				
			}
		}
	}
}
