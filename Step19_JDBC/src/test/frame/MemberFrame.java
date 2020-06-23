package test.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MemberFrame extends JFrame implements ActionListener {

	// final
	private static final String COMMAND_SAVE = "save";
	private static final String COMMAND_SHOW = "show";
	private static final String COMMAND_DELETE = "delete";
	
	// 필드
	JTextField inputName;
	JTextField inputAddr;
	JTable table;
	DefaultTableModel model;
	
	// 생성자
	public MemberFrame() {
		setLayout(new BorderLayout());

		JLabel labelName=new JLabel("이름");
		inputName=new JTextField(10);
		
		JLabel labelAddr=new JLabel("주소");
		inputAddr=new JTextField(10);
		
		JButton saveBtn=new JButton("저장");
		saveBtn.addActionListener(this);
		saveBtn.setActionCommand(COMMAND_SAVE);
		
		JButton showBtn=new JButton("출력");
		showBtn.addActionListener(this);
		showBtn.setActionCommand(COMMAND_SHOW);
		
		JButton deleteBtn=new JButton("삭제");
		deleteBtn.addActionListener(this);
		deleteBtn.setActionCommand(COMMAND_DELETE);
		
		JPanel panel=new JPanel();
		panel.add(labelName);
		panel.add(inputName);
		panel.add(labelAddr);
		panel.add(inputAddr);
		panel.add(saveBtn);
		panel.add(showBtn);
		panel.add(deleteBtn);
		
		add(panel, BorderLayout.NORTH);
		
		// 표 형식으로 정보를 출력하기 위한 JTable
		table=new JTable();
		// 단일선택
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// 칼럼명을 String[] 에 순서대로 담기
		String[] colNames= {"번호", "이름", "주소"};
		// 테이블에 출력할 정보를 가지고 있는 모델 객체 (칼럼명, row 갯수)
		model=new DefaultTableModel(colNames, 0);
		// 모델을 테이블에 연결한다.
		table.setModel(model);
		// 스크롤이 가능 하도록 테이블을 JScrollPane 으로 감싼다
		JScrollPane scroll=new JScrollPane(table);
		// JScrollPane 을 프레임의 가운데에 배치하기
		add(scroll, BorderLayout.CENTER);
		
		// JTable 에 Sample 데이터 출력해보기
//		Object[] row1= {1, "김지훈", "성북구"};
//		Object[] row2= {2, "김찬미", "동대문구"};
//		model.addRow(row1);
//		model.addRow(row2);		
	}
	
	// main 메소드
	public static void main(String[] args) {
		MemberFrame f=new MemberFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 800, 500);
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command=e.getActionCommand();
		if (command.equals(COMMAND_SAVE)) {
			memberSave();
			labelClear();
		} else if (command.equals(COMMAND_SHOW)) {
			tableClear();
			memberShow();
		} else if (command.equals(COMMAND_DELETE)) {
			memberDelete();
			tableClear();
			memberShow();
		}
	}
	// 회원 정보를 담는 메소드
	public void memberSave() {
		// 새로 추가할 회원의 정보 담기
		MemberDto dto=new MemberDto();
		String name=inputName.getText();
		dto.setName(name);
		String addr=inputAddr.getText();
		dto.setAddr(addr);
		
		// MemberDao 객체 생성
		MemberDao dao=MemberDao.getInstance();
		
		// MemberDao 객체의 메소드를 활용해서 저장하기
		boolean isSuccess=dao.insert(dto);
		if (isSuccess=true) {
			JOptionPane.showMessageDialog(this,name+"님의 정보를 저장했습니다");
		} else {
			JOptionPane.showMessageDialog(this, "저장에 실패했습니다");
		}
	}
	// 회원 정보를 출력하는 메소드
	public void memberShow() {
		// MemberDao 객체 생성
		MemberDao dao=MemberDao.getInstance();
		// getList() 메소드를 이용해 받아온 회원 목록을 담아줄 List type 지역 변수 생성
		List<MemberDto> list=dao.getList();
		// 반복문을 통해 회원 목록 출력
		for (int i=0; i<list.size(); i++) {
			MemberDto tmp=list.get(i);
			Object[] row={tmp.getNum(), tmp.getName(), tmp.getAddr()};
			model.addRow(row);
		}		
	}
	// 회원 정보를 삭제하는 메소드
	public void memberDelete() {
		try {
			// 1. 선택된 row 인덱스를 읽어온다.
			int SelectedRowIndex=table.getSelectedRow();
			// 2. 선택된 row의 첫번째(0번째) 칼럼을 선택
			int SRI_num=(int) model.getValueAt(SelectedRowIndex, 0);
			// 3. MemberDao 객체를 이용해서 해당 데이터 삭제
			MemberDao dao=MemberDao.getInstance();
			dao.delete(SRI_num);
			JOptionPane.showMessageDialog(this, SRI_num+" 번 데이터를 를 성공적으로 삭제했습니다!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "삭제할 Row를 선택하세요");
		}
	}
	// 입력 필드를 초기화 하는 메소드
	public void labelClear() {
		// 입력필드 초기화
		inputName.setText("");
		inputAddr.setText("");
	}
	// 테이블을 초기화 하는 메소드
	public void tableClear() {
		model.setNumRows(0);
	}
}
