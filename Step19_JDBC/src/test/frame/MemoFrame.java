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

import test.dao.MemoDao;
import test.dto.MemoDto;

/*
 * 		CREATE TABLE MEMO
 * 		(num NUMBER PRIMARY KEY,
 * 		content VARCHAR2(30),
 * 		regdate DATE);
 * 
 *		CREATE SEQUENCE MEMO_SEQ;
 *
 *		위와 같이 테이블을 만들고 해당 테이블에 데이터를 SELECT, INERT, UPDATE, DELETE 기능을 수행할 수 있는 MemoFrame 을 만들어 보세요.
 *
 *		조건
 *		1. num 칼럼의 값은 시퀀스를 이용해서 넣으세요.
 *		2. regdate 칼람(등록일)의 값은 SYSDATE 를 이용해서 넣으세요
 *		3. 수정은 content 만 수정 가능하게 하세요
 *		4. MemoDto, MemoDao 를 만들어서 프로그래밍 하세요.
 */
public class MemoFrame extends JFrame implements ActionListener, PropertyChangeListener {

	// final
	private static final String COMMAND_SAVE = "save";
	private static final String COMMAND_SHOW = "show";
	private static final String COMMAND_DELETE = "delete";
	
	// 필드
	JTextField inputContent;
	DefaultTableModel model;
	JTable table;
	
	// default 생성자
	public MemoFrame() {
		setLayout(new BorderLayout());

//		num content date
		JLabel labelContent=new JLabel("콘텐츠");
		inputContent=new JTextField(10);
		
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
		panel.add(labelContent);
		panel.add(inputContent);
		panel.add(saveBtn);
		panel.add(showBtn);
		panel.add(deleteBtn);
		
		add(panel, BorderLayout.NORTH);
		
		table=new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		String[] colNames= {"번호", "콘텐츠", "날짜"};
		model=new DefaultTableModel(colNames, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				if (column==0 || column==2) {
					return false;
				}
				return true;
			}
		};
		table.setModel(model);
		JScrollPane scroll=new JScrollPane(table);
		add(scroll, BorderLayout.CENTER);
		table.addPropertyChangeListener(this);
		
		memoShow();
	}
	public static void main(String[] args) {
		MemoFrame f=new MemoFrame();
		f.setTitle("MemoFrame");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 800, 500);
		f.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String command=e.getActionCommand();
		if (command.equals(COMMAND_SAVE)) {
			contentSave();
			labelClear();
			tableClear();
			memoShow();
		} else if (command.equals(COMMAND_SHOW)) {
			tableClear();
			memoShow();
		} else if (command.equals(COMMAND_DELETE)) {
			memoDelete();
			tableClear();
			memoShow();
		}
	}
	// content 를 입력하는 메소드
	public void contentSave() {
		MemoDto dto=new MemoDto();
		String content=inputContent.getText();
		if (content.length() <= 0) {
			JOptionPane.showMessageDialog(this, "값을 입력해 주세요");
			return;
		}
		dto.setContent(content);
		
		MemoDao dao=MemoDao.getInstance();
		
		boolean isSuccess=dao.insert(dto);
		if (isSuccess=true) {
			JOptionPane.showMessageDialog(this, content+" 내용을 저장했습니다");
		} else {
			JOptionPane.showMessageDialog(this, "저장에 실패했습니다");
		}
	}
	// memo 테이블을 출력하는 메소드
	public void memoShow() {
		MemoDao dao=MemoDao.getInstance();
		List<MemoDto> list=dao.getList();
		for (int i=0; i<list.size(); i++) {
			MemoDto tmp=list.get(i);
			Object[] row= {tmp.getNum(), tmp.getContent(), tmp.getDate()};
			model.addRow(row);
		}
	}
	// memo row 를 삭제하는 메소드
	public void memoDelete() {
		int SelectedRowIndex=table.getSelectedRow();
		if(SelectedRowIndex==-1) {
			return;
		}
		int result=JOptionPane.showConfirmDialog(this, "정말 삭제 하시겠습니까?");
		if (result==JOptionPane.YES_OPTION) {
			int SRI_num=(int) model.getValueAt(SelectedRowIndex, 0);
			MemoDao dao=MemoDao.getInstance();
			dao.delete(SRI_num);
			JOptionPane.showMessageDialog(this, SRI_num+" 번 데이터를 삭제했습니다!");;
		} else {
			return;
		}
	}
	// 입력 필드를 초기화 하는 메소드
	public void labelClear() {
		inputContent.setText("");
	}
	// 테이블을 초기화 하는 메소드
	public void tableClear() {
		model.setNumRows(0);
	}
	
	boolean isEditing=false;
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println(evt.getPropertyName());
		if (evt.getPropertyName().equals("tableCellEditor")){
			if (isEditing) {
				int SelectedRowIndex=table.getSelectedRow();
				int num=(int)model.getValueAt(SelectedRowIndex, 0);
				String content=(String)model.getValueAt(SelectedRowIndex, 1);
				String date=(String)model.getValueAt(SelectedRowIndex, 2);
				MemoDto dto=new MemoDto(num, content, date);
				MemoDao.getInstance().update(dto);
				isEditing=false;
			}
			isEditing=true;
		}
		
	}
}
