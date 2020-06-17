package test.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

public class Quiz08 extends JFrame implements ActionListener{
	// 필드
	JColorChooser jc=null;
	JTextArea area=null;
	JLabel label=null;
	Container contentPane;
	//생성자
	public Quiz08() {
		
		setTitle("나의 파일");
		setLayout(new BorderLayout());
		//메뉴 아이템 3개 만들기 
		JMenuItem item_new=new JMenuItem("New");
		JMenuItem item_open=new JMenuItem("Open");
		JMenuItem item_save=new JMenuItem("Save");
		JMenuItem item_color=new JMenuItem("Color");
		
		item_new.setActionCommand("new");
		item_new.addActionListener(this);
		
		item_color.setActionCommand("color");
		item_color.addActionListener(this);
		
		//메뉴에 아이템 추가 
		JMenu menu1=new JMenu("File");
		menu1.add(item_new);
		menu1.add(item_open);
		menu1.add(item_save);
		menu1.add(item_color);
		//메뉴바에 메뉴 추가 
		JMenuBar mb=new JMenuBar();
		mb.add(menu1);
		//프레임에 메뉴바 장착
		setJMenuBar(mb);
		
		//텍스트 area 를 프레임의 가운데에 배치 
		area=new JTextArea();
		add(area, BorderLayout.CENTER);
		area.setBackground(Color.BLACK);
		area.setVisible(false);
		
		contentPane=getContentPane();
		
		label=new JLabel();
		area.add(label);
		
		// 컬러 다이얼로그 생성
		jc=new JColorChooser();
	}
	
	public static void main(String[] args) {
		Quiz08 f=new Quiz08();
		f.setBounds(100, 100, 500, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String command=arg0.getActionCommand();
		if(command.equals("color")) { // 컬러 메뉴 선택시
			// 컬러 다이얼로그 출력 후, 사용자가 선택한 색을 알아옴
			Color selectedColor=jc.showDialog(this, "선택한 색상을 배경색으로 지정하는 메서드", null);
			
			// 사용자가 취소버튼을 누르거나 그냥 닫을경우 color 는 null
			if(selectedColor != null)
				area.setVisible(true);
				label.setForeground(selectedColor); // 사용자가 선택한 색을 문자열 색으로 변경함
				area.setBackground(selectedColor);
		} else {
			// 오픈했을때 기본경로 지정
			JFileChooser fc=new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			fc.setDialogTitle("양 금모띠");
			
			int result=fc.showOpenDialog(this);
			if(result == JFileChooser.APPROVE_OPTION) {
				System.out.println(fc.getSelectedFile().getPath());
			}else if(result == JFileChooser.CANCEL_OPTION) {
				
			}else if(result == JFileChooser.ERROR_OPTION) {
				
			}
		}
	}
}