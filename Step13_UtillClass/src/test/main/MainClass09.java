package test.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainClass09 {
	public static void main(String[] args) {
		/*
		 * 		3명의 회원정보 (번호, 이름, 주소) 를 HashMap 객체에 담고
		 * 
		 * 		HashMap 객체의 참조값을 ArrayList 객체에 순서대로 담아 보세요.
		 */
		HashMap<String, Object> h1=new HashMap();
		h1.put("num", 1);
		h1.put("name", "김지훈");
		h1.put("addr", "성북구");
		
		HashMap<String, Object> h2=new HashMap();
		h2.put("num", 2);
		h2.put("name", "김찬미");
		h2.put("addr", "동대문구");
		
		HashMap<String, Object> h3=new HashMap();
		h3.put("num", 3);
		h3.put("name", "김청하");
		h3.put("addr", "동대문구");
		
		List<HashMap> list=new ArrayList<HashMap>();
		list.add(h1);
		list.add(h2);
		list.add(h3);
		
		for (int i=0; i<list.size(); i++) {
			HashMap tmp = list.get(i);
			int num=(int)tmp.get("num");
			String name=(String)tmp.get("name");
			String addr=(String)tmp.get("addr");
			String line = num+" | "+name+" | "+addr;
			System.out.println(line);
		}
		System.out.println("확장 for 문을 이용하면");
		for (HashMap tmp : list) {
			int num=(int)tmp.get("num");
			String name=(String)tmp.get("name");
			String addr=(String)tmp.get("addr");
			String line = num+" | "+name+" | "+addr;
			System.out.println(line);
		}
		
		// 참조연습
		List<Map<String, Object>> a=list;
		Map<String, Object> b=list.get(0);
		Object c=list.get(0).get("num");
		Object d=list.get(0).get("name");
		Object e=list.get(0).get("addr");
		int f=(int)list.get(0).get("num");
		String g=(String)list.get(0).get("name");
		String h=(String)list.get(0).get("addr");
		
		int i=((String).list.get(0).get("addr")).length();
	}
}
