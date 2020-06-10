package test.main;

import java.util.HashMap;

public class MainClass08 {
	public static void main(String[] args) {
		/*
		 * 		HashMap<key 값의 type, value 값의 type>
		 */
		HashMap<String, Object> map1=new HashMap<>();
		map1.put("num", 1);
		map1.put("name", "김지훈");
		map1.put("addr", "성북구");
		/*
		 * 		value 의 Generic 클래스가 Object로 지정 되어 있기 떄문에
		 * 		리턴되는 Object type 을 원래 type으로 casting 해야 한다.
		 */
		int num=(int)map1.get("num");
		String name=(String)map1.get("name");
		String addr=(String)map1.get("addr");
	}
}
