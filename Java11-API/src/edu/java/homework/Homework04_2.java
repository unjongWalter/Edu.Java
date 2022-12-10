package edu.java.homework;

public class Homework04_2 {

	public static void main(String[] args) {
// 1. 다음 문자열에서 "자바"문자열이 포함되어 있는지 확인하고,
// 2. "자바"를 Java로 대치한 새로운 문자열을 만들어보세요.
		
		System.out.println("1 자바포함여부, 2 문자대체여부 확인");
		System.out.println("원래 문자열 : 모든 프로그램은 자바 언어로 개발될 수 있다.");

		String str = "모든 프로그램은 자바 언어로 개발될 수 있다.";
		int index = str.indexOf("자바");
		if (index == -1) {
			System.out.println("자바 문자열이 미포함");
		} else {
			System.out.println("자바 문자열 포함");
			str = str.replace("자바", "Java");
			System.out.println("->" + str);
		}
		
	}//end main()
	
}// end Homeworks04_2

