package test.main;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MainClass10 {
	public static void main(String[] args) {
		// 만일 MemberDao 객체의 참조값이 필요하다면?
		// MemberDao dao=new MemberDao(); 직접 객체 생성 불가
		
		// static 메소드를 이용해서 MemberDao 객체의 참조값을 받아올 수 있다.
		MemberDao dao=MemberDao.getInstance();
		// 새로 추가할 회원의 정보
		MemberDto dto=new MemberDto();
		dto.setName("박동훈");
		dto.setAddr("후계동");
		// MemberDao 객체의 메소드를 활용해서 저장 할 수 있다.
		dao.insert(dto);
		
		MemberDao dao2=MemberDao.getInstance();
		// 수정할 회원의 정보라면
		MemberDto dto2=new MemberDto(1, "김지훈", "종암동");
		dao2.update(dto2);
		
		dao2.getList();
		dao2.getData(1);
	}
}
