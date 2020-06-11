package test.main;

import java.util.HashSet;

import test.mypac.Car;
/*
 * 		HashSet 은 Set 인터페이스를 구현한 클래스 이다.
 * 
 * 		- 순서가 없다
 * 		- key 값도 없다.
 * 		- 중복을 허용하지 않는다.
 * 		- 어떤 data 를 묶음(집합)으로 관리하고자 할 때 사용한다.
 */
public class MainClass12 {
	public static void main(String[] args) {
		// 정수값을 저장할 수 있는 HashSet 객체
		HashSet<Integer> set1=new HashSet<>();
		set1.add(10);
		set1.add(20);
		set1.add(20);
		set1.add(30);
		set1.add(30);
		
		// 문자열을 저장할 수 있는 HashSet 객체
		HashSet<String> set2=new HashSet<>();
		set2.add("kim");
		set2.add("lee");
		set2.add("park");
		set2.add("lee");
		set2.add("park");
		
		// Car 객체를 저장할 수 있는 HashSet 객체
		HashSet<Car> set3=new HashSet<>();
		set3.add(new Car("포르쉐"));
		set3.add(new Car("람보르기니"));
		set3.add(new Car("k7"));
		Car car1=new Car("옵티머스 프라임");
		Car car2=new Car("범블비");
		set3.add(car1);
		set3.add(car1);
		set3.add(car2);
		set3.iterator();
		
	}
}
