package test.main;

import java.util.ArrayList;

public class MainClass02 {
	public static void main(String[] args) {
		// 정소를 저장할 수 있는 가변 배열 객체 생성
		ArrayList<Integer> nums=new ArrayList<Integer>();
		nums.add(10);
		nums.add(20);
		nums.add(30);
		// 배열의 크기 얻어오기
		int size=nums.size();
		// 특정 인덱스 아이템 얻어오기 (참조)
		int num1=nums.get(0);
		Integer num2=nums.get(1);
		int num3=nums.get(2);
		// 특정 방의 값 수정(덮어쓰기)
		nums.set(1, 40); // 1번방 수정
		// 특정 인덱스 삭제(방 자체를 제거하기)
		nums.remove(1); // 1번방 삭제
		// 배열의 모든 방 삭제
		nums.clear();
	}
}
