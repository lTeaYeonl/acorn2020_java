package test.main;

import java.util.List;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MainClass13 {
	public static void main(String[] args) {
	/*
	 * 		MemberDao 객체를 이용해서 회원 목록을 얻어와서
	 * 		아래와 같은 형식으로 출력해 보세요.
	 * 
	 * 		1	|	김구라	|	노량진
	 * 		2	|	원숭이	|	상도동
	 * 		3	|	주뎅이	|	봉천동
	 * 		.
	 * 		.
	 */		
		// MemberDao 객체 생성
		MemberDao dao=MemberDao.getInstance();
		// getList() 메소드를 이용해 받아온 회원 목록을 담아줄 List type 지역 변수 생성
		List<MemberDto> list=dao.getList();
		// 반복문을 통해 회원 목록 출력
		for(MemberDto tmp:list) {
			System.out.println(tmp.getNum()+" | "+tmp.getName()+" | "+tmp.getAddr());
		}
	}
}
