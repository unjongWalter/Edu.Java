package edu.java.array07;

public class ArrayMain07 {

	public static void main(String[] args) {
		// 문자 char, 문자열 String
		System.out.println("배열 연습3");
		String test = "문자열입니다.";
		System.out.println(test);
		System.out.println("문자열의 길이 : "+test.length());
		
		// 문자열 배열 선언
		String[] subjects = {"국어", "영어", "수학", "프로그래밍"};
		// "영어"의 문자열 길이 출력
		subjects[1].length(); // 배열에서 1칸에 있는 영어
		System.out.println(subjects[1].length());
		
		// 모든 subjects의 문자열 길이를 출력
		// for 구문
		for(int i = 0; i < subjects.length; i++) { // i = 인덱스 0칸에 있는 것 나타내기
			System.out.println("과목명 : "+ subjects[i]); //명만 나타내기			
			System.out.println("문자열의 길이 : "+ subjects[i].length()); // 길이 나타내기
		}
		
		// for- each 구문
		for(String str : subjects) {
			System.out.println(str.length());
		}
		
	} // end main()

} // end ArrayMain07
