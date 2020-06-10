package test.main;

import java.util.ArrayList;
import java.util.List;

public class MainClass03 {
	public static void main(String[] args) {
		// String type 을 저장할 ArrayList 객체를 생성하고
		// 참조값을 List 인터페이스 type 지역변수 msgs에 담기
		List<String> msgs=new ArrayList<>();
		msgs.add("김지훈");
		msgs.add("김청하");
		msgs.add("김찬미");
		msgs.add("이지안");
		msgs.add("이채린");
		msgs.add("유인나");
		// List 객체에 담긴 문자열을 for문을 이용해서 순서대로 콘솔창에 출력해보세요
		for (int i=0; i<msgs.size(); i++) {
			String tmp=msgs.get(i);
			System.out.println(tmp);
		}
		System.out.println("확장 for 문");
		for(String tmp:msgs) {
			System.out.println(tmp);
		}
		
	}
}
