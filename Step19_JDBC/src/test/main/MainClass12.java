package test.main;

import java.util.Scanner;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MainClass12 {
	public static void main(String[] args) {
		/*
		 *		Scanner 객체를 이용해서 문자열을 두번 입력 받는다.
		 *		새로 추가할 이름과 주소를 입력 받아서
		 *		MemberDao 객체를 이용해서 DB에 저장하는 code를 작성해 보세요.
		 */
		// Scanner 객체 생성
		Scanner scan=new Scanner(System.in);
		System.out.println("저장할 이름을 입력하세요 : ");
		String input_name=scan.nextLine();
		System.out.println("저장할 주소를 입력하세요 : ");
		String input_addr=scan.nextLine();
		
		// 새로 추가할 회원의 정보 담기
		MemberDto dto=new MemberDto();
		dto.setName(input_name);
		dto.setAddr(input_addr);
		
		// MemberDao 객체 생성
		MemberDao dao=MemberDao.getInstance();
		
		// MemberDao 객체의 메소드를 활용해서 저장하기
		boolean isSuccess=dao.insert(dto);
	}
}
