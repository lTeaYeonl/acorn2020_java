package test.main;

import java.util.Scanner;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MainClass14 {
	public static void main(String[] args) {
		/*
		 * 		Scanner 객체를 이용해서 검색할 회원 번호를 입력 받아서
		 * 		입력 받은 번호에 해당하는 회원 정보를 얻어와서
		 * 		아래와 같은 형식으로 출력해 보세요.
		 * 
		 * 		1을 입력한 경우
		 * 
		 * 		1	|	김지훈	|	종암동
		 * 
		 * 		입력한 번호가 없는 경우 (입력값 : 9)
		 * 
		 * 		9 번 회원은 존재 하지 않습니다.
		 * 
		 * 		값을 입력하지 않았을 경우까지 +
		 */
		// Scanner 객체를 이용해서 정수를 입력 받고
		Scanner scan=new Scanner(System.in);
		System.out.println("검색할 회원 번호 입력 : ");
		int input_num=scan.nextInt();
		
		// MemberDao 객체를 이용해서 입력한 회원 정보를 MemberDto 에 담아온다.
		MemberDao dao=MemberDao.getInstance();
		MemberDto dto=new MemberDto();
		dto=dao.getData(input_num);

		// 검색한 회원정보 출력
		if (dto!=null) { // 입력한 번호의 회원정보가 있을 경우
			System.out.println(dto.getNum()+" | "+dto.getName()+" | "+dto.getAddr());
		} else if (dto==null) { // 입력한 번호의 회원정보가 없을 경우
			System.out.println(input_num+" 번 회원은 존재 하지 않습니다!");
		}
	}
}
