package test.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.filechooser.FileSystemView;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

public class Quiz04 extends JFrame implements ActionListener{
	
	//생성자
	public Quiz04() {
		
		setTitle("나의 파일");
		setLayout(new BorderLayout());
		//메뉴 아이템 3개 만들기 
		JMenuItem item_new=new JMenuItem("New");
		JMenuItem item_open=new JMenuItem("Open");
		JMenuItem item_save=new JMenuItem("Save");
		
		item_new.setActionCommand("new");
		item_new.addActionListener(this);
		
		//메뉴에 아이템 추가 
		JMenu menu1=new JMenu("File");
		menu1.add(item_new);
		menu1.add(item_open);
		menu1.add(item_save);
		//메뉴바에 메뉴 추가 
		JMenuBar mb=new JMenuBar();
		mb.add(menu1);
		//프레임에 메뉴바 장착
		setJMenuBar(mb);
		
		//텍스트 area 를 프레임의 가운데에 배치 
		JTextArea area=new JTextArea();
		add(area, BorderLayout.CENTER);
		area.setBackground(Color.YELLOW);
		area.setVisible(false);
	}
	
	public static void main(String[] args) {
		Quiz04 f=new Quiz04();
		f.setBounds(100, 100, 500, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JFileChooser fc=new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		fc.setDialogTitle("파일을 저장할 경로를 지정하세요");
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int result=fc.showOpenDialog(this);
//		int result2=fc.showSaveDialog(this);
		if(result == JFileChooser.APPROVE_OPTION) {
			if(fc.getSelectedFile().isDirectory()) {
				System.out.println("당신이 선택한 경로는 : "+fc.getSelectedFile());
			}
			//선택한 파일을 access 할수 있는 파일 객체 
			File selectedFile=fc.getSelectedFile();
			System.out.println(selectedFile.getAbsolutePath());
			
		}else if(result == JFileChooser.CANCEL_OPTION) {
			
		}else if(result == JFileChooser.ERROR_OPTION) {
			
		}
	}
}