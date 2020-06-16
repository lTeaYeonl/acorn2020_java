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
import javax.swing.JTextField;

public class Quiz02 extends JFrame implements ActionListener{
	// 필드
	File memoFile=null;
	FileWriter fw=null;
	JTextField tf_msg=null;
	// 생성자
	public Quiz02() {
		setTitle("나의 프레임");
		
		setLayout(new BorderLayout());
		JPanel topPanel=new JPanel();
		tf_msg=new JTextField(10);
		
		JButton appendBtn=new JButton("추가하기");
		
		appendBtn.setActionCommand("append");
		appendBtn.addActionListener(this);
		
		topPanel.add(tf_msg);
		topPanel.add(appendBtn);
		add(topPanel, BorderLayout.NORTH);
		topPanel.setBackground(Color.ORANGE);
	}
	public static void main(String[] args) {
		Quiz02 f=new Quiz02();
		f.setBounds(100, 100, 500, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		memo_append();
	}
	public void memo_append() {
		memoFile=new File("c:/acorn2020/myFolder/quiz02.txt");
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
}
