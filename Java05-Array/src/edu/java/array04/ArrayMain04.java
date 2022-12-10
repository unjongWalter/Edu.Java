package edu.java.array04;

public class ArrayMain04 {

	public static void main(String[] args) {
		System.out.println("배열 초기화 연습");
		// 그릇을 만들어두고 안쓰는 것 : 그릇이 필요없다는 의미
		// 만약 학생 3명 국어 점수 저장
		// 배열 선언과 초기화1 : 
		int[] koreans = new int[3]; // 입력받을 때 보통 사용
		koreans[0] = 100;
		koreans[1] = 90;
		koreans[2] = 80;
		
		// 배열 선언과 초기화2;
		int[] english = {100, 90, 80};
		System.out.println(english.length);
		
		// for문을 사용한 출력
		for(int i =0; i < english.length; i++) {
			System.out.println(english[i]);
		}	
		
		// for -each 구문(향상된 for 구문)
		// for (타입 변수이름 : 배열) {,,,}
		// - 위 타입은 배열과 동일한 타입으로 선언
		// - 배열에 있는 모든 데이터를 접근할 때 사용
				
		// for-each 사용한 출력
		for(int x : english) { // 따로 인덱스가 없이 실행됨, each라는 모든 것을 다 꺼낼 때
			System.out.println(x); // english는 int 타입
		}
		// 100, 90, 80
		// 1) x = 100
		// ㄴ x 출력
		// 2) x = 90
		// ㄴ x 출력
		// 3) x = 80
		// ㄴ x 출력

	} // end main()

} // end ArrayMain04
