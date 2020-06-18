package test.main;

import java.util.Random;

public class MainClass03 {
	public static void main(String[] args) {
		Random ran=new Random();
		int nums=ran.nextInt(44)+1;
		System.out.println(nums);
	}
}
