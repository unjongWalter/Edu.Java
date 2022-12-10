package edu.java.homework;

public class Homeworks04_1 {

	public static void main(String[] args) {

		// 1. str문자열을 split로 배열 저장 나누기
		String str = "사과:배:바나나:복숭아";
		String[] result = str.split(":");
		for (String x : result) {
			System.out.println(x);
		}
		System.out.println("==============");
		// 2. 배열 저장 문자열을 StringBiffer로 하나로 연결
		StringBuffer buffer = new StringBuffer();
		for (String x : result) { // result = str.split(":")
			buffer.append(x);
		}
		System.out.println(buffer);
		
	} // end main()
	
} // end Homework04_1
