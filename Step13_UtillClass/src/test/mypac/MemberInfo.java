package test.mypac;

public class MemberInfo {
	// 필드
	public int num;
	public String name;
	public String addr;
	
	// default 생성자
	public MemberInfo() {	}
	
	// 생성자의 인자로 번호, 이름, 주소를 전달 받을 수 있도록 한다.
	public MemberInfo(int num, String name, String addr) {
		this.num=num;
		this.name=name;
		this.addr=addr;
	}
}
