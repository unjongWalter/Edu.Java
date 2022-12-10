package edu.java.array01;

// 배열
// - 같은 타입의 변수들을 하나의 목록으로 저장할 때 사용
// - 배열의 선언과 초기화
//		배열타입[] 배열이름 = new 배열타입 [배열길이];
//		배열이름[인덱스] = 값;
// 		or 방식이 두가지야
//		배열타입[] 배열이름 = {값1, 값2, ...}
// - 배열의 인덱스는 0부터 시작

public class ArrayMain01 {

	public static void main(String[] args) {
		System.out.println("배열(array)");
		int score1 = 100; // 패턴 중 숫자만 다르거나 할 때 사용
		int score2 = 90;
		int score3 = 80;
		int score4 = 70;		
		System.out.println(score1);
		System.out.println(score2);
		System.out.println(score3);
		System.out.println(score4);
		
		System.out.println("==========");
		// 초기화 방식1
		int[] scores = new int[4]; // int 타입의 배열을 4개 만들고, scores로 선언한다
		scores[0] = 90;
		scores[1] = 80;
		scores[2] = 70;
		scores[3] = 60;
		for(int i = 0; i < 4; i++) { // 시작번호가 0부터
			System.out.println(scores[i]);			
		}
		
		// 초기화 방식2
		// int[] scoress = {90, 80, 70, 60};
		// System.out.println();
		
	} //end main()

} //end ArrayMain01
