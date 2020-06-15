package test.main;

import java.io.File;

public class MainClass10 {
	// 필드
	static int i;
	public static void main(String[] args) {
		File f1=new File("c:/acorn2020/myFolder/folder1");
		// 디렉토리 만들기
		f1.mkdir();
		System.out.println("디렉토리를 만들었습니다!");
		for (i=0; i<10; i++) {
			File tmp=new File("c:/acorn2020/myFolder/new_folder"+i);
			tmp.mkdir();
		}
		System.out.println("디렉토리 "+i+"개를 만들었습니다!");
	}
}
