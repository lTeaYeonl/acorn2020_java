package test.main;

import java.util.ArrayList;
import java.util.List;

import test.mypac.Info;
import test.mypac.MemberDto;

public class MainClass05 {
	public static void main(String[] args) {
		// Info 클래스로 객체를 생성해서 참조값을 i1이라는 지역변수에 담기
		Info i1=new Info();
		// 필드는 public 으로 선언되어 있기 때문에 직접 접근해서 대입연산자로 값을 대입할 수 있다.
		i1.num=1;
		i1.name="김지훈";
		i1.addr="성북구";
		
		Info i2=new Info();
		i2.num=2;
		i2.name="김찬미";
		i2.addr="동대문구";
		
		// 위의 Info type 객체의 참조값을 List 객체에 순서대로 담아 보세요.
		List<Info> tmp=new ArrayList<Info>();
		tmp.add(i1);
		tmp.add(i2);
		
		/* 		반복문 for 를 이용해서 List 객체에 담긴 정보를 아래와 같은 형식으로 출력해 보세요.
		 * 		1 | 김지훈 | 성북구
		 * 		2 | 김찬미 | 동대문구
		 */
		for (int i=0; i<tmp.size(); i++) {
			Info test = tmp.get(i);
			String line=test.num+" | "+test.name+" | "+test.addr;
			System.out.println(line);
			
			}
		System.out.println("확장 for 문을 이용하면");
		for (Info test : tmp) {
			String line=test.num+" | "+test.name+" | "+test.addr;
			System.out.println(line);
		}
	}
}
