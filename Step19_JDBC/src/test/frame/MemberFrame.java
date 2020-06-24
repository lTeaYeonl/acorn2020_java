package test.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
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

public class MemberFrame extends JFrame implements ActionListener, PropertyChangeListener{

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
		model=new DefaultTableModel(colNames, 0) {
			// 인자로 전달되는 행(row), 열(column) 수정 가능 여부를 리턴하는 메소드
			@Override
			public boolean isCellEditable(int row, int column) {
				// 만일 첫번째(0번쨰) 칼럼이면 수정이 불가 하도록 한다
				if(column==0) {
					return false;
				}
				return true;
			}
		};
		// 모델을 테이블에 연결한다.
		table.setModel(model);
		// 스크롤이 가능 하도록 테이블을 JScrollPane 으로 감싼다
		JScrollPane scroll=new JScrollPane(table);
		// JScrollPane 을 프레임의 가운데에 배치하기
		add(scroll, BorderLayout.CENTER);
		// 회원목록 출력
		memberShow();
		table.addPropertyChangeListener(this);
		
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
			tableClear();
			memberShow();
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
		// 1. 선택된 row 인덱스를 읽어온다.
		int SelectedRowIndex=table.getSelectedRow();
		if(SelectedRowIndex==-1)	 { // 선택된 row 가 없다면
			return; // 메소드 종료
		}
		// 정말 삭제할것인지 확인
		int result=JOptionPane.showConfirmDialog(this, "정말 삭제하시겠습니까?");
		if(result==JOptionPane.YES_OPTION){
			// 2. 선택된 row의 첫번째(0번째) 칼럼을 선택
			int SRI_num=(int) model.getValueAt(SelectedRowIndex, 0);
			// 3. MemberDao 객체를 이용해서 해당 데이터 삭제
			MemberDao dao=MemberDao.getInstance();
			dao.delete(SRI_num);
			JOptionPane.showMessageDialog(this, SRI_num+" 번 데이터를 삭제했습니다!");
		} else {
			return;
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

	boolean isEditing=false;
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println("Property change");
		System.out.println(evt.getPropertyName());
		if(evt.getPropertyName().equals("tableCellEditor")) {
			if(isEditing) { // 수정 중 일때
				// 변화된 값을 읽어와서 DB에 반영한다
				// 수정된 칼럼에 있는 row 전체의 값을 읽어온다.
				int SelectedRowIndex=table.getSelectedRow();
				int num=(int)model.getValueAt(SelectedRowIndex, 0);
				String name=(String)model.getValueAt(SelectedRowIndex, 1);
				String addr=(String)model.getValueAt(SelectedRowIndex, 2);
				// 수정할 회원의 정보를 MemberDto .객체에 담고
				MemberDto dto=new MemberDto(num, name, addr);
				// DB 에 저장하기
				MemberDao.getInstance().update(dto);
				isEditing=false; // 수정중이 아니라고 표시한다.
			}
			isEditing=true; // 수정중이라고 표시한다.
		}
	}
}
