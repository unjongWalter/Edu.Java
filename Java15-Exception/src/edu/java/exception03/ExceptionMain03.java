package edu.java.exception03;

public class ExceptionMain03 {
// try catch로 문제 사전 확인
	public static void main(String[] args) {
		try {
			System.out.println("inner try");
			int[] array = new int[10];
			array[13] = 100; // out of the length
			System.out.println(array[10]); // out of the bounds of length
		} catch (Exception e) {// 모든 예외 처리
			System.out.println("exceptional message : " + e.toString());
		}
		System.out.println("the end");	

	}//end main()

}//end ExceptionMain03
