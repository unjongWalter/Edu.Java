package edu.java.while01;

// while 문
// - for문과 같은 반복문
// - 선언 형태
//		while(조건) {
//			(본문)
//		}

public class WhileMain01 {

	public static void main(String[] args) {
		System.out.println("while 반복문");

		// 0 ~ 10까지 출력
		int x = 0;
		while (x <= 10 ) {
			System.out.println(x + " ");
			x++;		
		}
		System.out.println("========");
				
		// while문을 사용하여 10, 9, ... 1까지 출력하기
		int y = 10;
		while (y >= 1) {
			System.out.println(y + " ");			
			y--;		
		}
		
	} //end main()

} //end WhileMain01
