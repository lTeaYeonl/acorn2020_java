package test2.main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AcornFrame extends JFrame implements ActionListener {
	// final
	static final String COMMNAD_SEND="send";
	// 필드
	JButton btn=null;
	// 생성자
	public AcornFrame() {
		setLayout(new BorderLayout());
		btn=new JButton("전송");
		btn.addActionListener(this);
		btn.setActionCommand("send");
		add(btn, BorderLayout.NORTH);
	}
	
	public static void main(String[] args) {
		AcornFrame f=new AcornFrame();
		f.setTitle("acorn");
		f.setBounds(100, 100, 400, 400);
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command=btn.getActionCommand();
		if(command.equals(COMMNAD_SEND)) {
			JOptionPane.showMessageDialog(this, "전송합니다");
		} else {
			return;
		}
	}
}
