package test.main;

import java.util.ArrayList;
import java.util.List;

import test.mypac.Info;
import test.mypac.MemberDto;

public class MainClass07 {
	public static void main(String[] args) {
		// default 생성자를 이용해서 객체를 생성한 경우
		MemberDto m1=new MemberDto();
		m1.setNum(1);
		m1.setName("김지훈");
		m1.setAddr("성북구");
		
		// 인자로 필드에 저장할 생성자를 이용해서 객체를 생성한 경우
		MemberDto m2=new MemberDto(2, "김찬미", "동대문구");
		
		// 위에서 생성한 객체의 참조값을 List 객체에 담아 보세요.
		List<MemberDto> tmp=new ArrayList<>();
		tmp.add(m1);
		tmp.add(m2);
		
		/*
		 * 		for 문을 이용해서 List 객체에 담긴 MemberDto 객체를 순서대로 참조해서
		 * 		아래와 같은 형식으로 출력해 보세요.
		 * 
		 * 		1 | 김지훈 | 성북구
		 * 		2 | 김찬미 | 동대문구
		 */
		for (int i=0; i<tmp.size(); i++) {
			MemberDto test = tmp.get(i);
			String line = test.getNum()+" | "+test.getName()+" | "+test.getAddr();
			System.out.println(line);
		}
		System.out.println("확장 for 문을 이용하면");
		for (MemberDto test : tmp) {
			String line = test.getNum()+" | "+test.getName()+" | "+test.getAddr();
			System.out.println(line);
		}
		// 참조 테스트
		// tmp 를 List 객체의 a 변수에 담아줌
		List<MemberDto> a=tmp;
		// MemberDto 타입의 객체를 가져와 b 변수에 담음
		MemberDto b=tmp.get(0);
		// int 타입의 c 변수에 get객체의 Num 필드를 대입
		int c = tmp.get(0).getNum();
		String d = tmp.get(0).getName();
		String e = tmp.get(0).getAddr();
		int f = tmp.get(0).getName().length();
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
	}
}
