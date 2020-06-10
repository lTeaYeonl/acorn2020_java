package test.main;

import java.util.ArrayList;

public class MainClass01 {
	public static void main(String[] args) {
		ArrayList<String> names=new ArrayList<String>();
		// String type의 참조값 저장하기
		names.add("김지훈");
		names.add("김찬미");
		names.add("이채린");
		// 배열의 방의 크기 얻어오기
		int size=names.size();
		// 각각의 방에 저장된 값 불러오기
		String name1=names.get(0); // 0번방
		String name2=names.get(0); // 1번방
		String name3=names.get(0); // 2번방
		
		// 특정 방의 값 수정(덮어쓰기)
		names.set(0, "이지안"); // 0번방 수정
		
		// 특정 인덱스 삭제(방 자체를 제거하기)
		names.remove(0); // 0번방 삭제
		
		// 배열의 모든 방 삭제
		names.clear();
	}
}
