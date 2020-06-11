package test.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainClass11 {
	public static void main(String[] args) {
		Map<String, String> dic=new HashMap<>();
		dic.put("house", "집");
		dic.put("phone", "전화기");
		dic.put("car", "자동차");
		dic.put("pencil", "연필");
		dic.put("eraser", "지우개");
		/*
		 * 		검색할 단어를 입력하세요 : house
		 * 
		 * 		house 의 뜻은 집 입니다.
		 */
		Scanner scan=new Scanner(System.in);
		
		System.out.println("검색할 단어를 입력하세요 : ");
		// 문자열 입력 받기
		String inputWord=scan.nextLine();
		// map 객체에서 입력한 문자열로 저장된 값을 읽어와 보기
		String mean = dic.get(inputWord);
		if (mean==null) {
			System.out.println(inputWord+" 는 목록에 없습니다");
		} else {
			// 출력할 문자열 구성하기
			String line = inputWord+" 의 뜻은 "+mean+" 입니다.";
			// 출력하기
			System.out.println(line);
			
		}
	}  
}
