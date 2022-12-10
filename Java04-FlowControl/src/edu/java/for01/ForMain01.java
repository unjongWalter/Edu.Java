package edu.java.for01;

// for 반복문
// - 반복 수행을 하기 위한 키워드
// - for(초기식; 조건식; 증감식) {
//		(본문)
// }
// - 초기값을 증감시켜서 조건식이 false가 될 때까지 본문을 반복
// - 실행순서
// 		1) 초기식. 2) 조건식. 3) 본문. 4) 증감식

public class ForMain01 {

	public static void main(String[] args) {
		System.out.println("for 반복문");
		for(int x = 1; x <= 10; x++) { // 1씩 증가하여 10까지 반복 수행
			System.out.println("Java " + x);
			
			// 1~10까지 출력
			// for(int x = 1; x <11; x++) {
			// sysout(x);
			// }
					
		}
		System.out.println("=======");
		// 1, 3, 5, 7, 9를 출력
		for(int x = 1; x < 10; x=x+2) { // 2씩 증가하여 9까지 나타내기
			System.out.println(x);
		}
		
		// 15, 14, 13, 12, ..., 1을 출력
		for(int x = 15; x >= 1; x--) { // 시작, 끝, 증가 or 감소 개념 탑재
			System.out.println(x);
		
		}
	}

}
