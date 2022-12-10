package edu.java.for04;

import java.util.Scanner;

public class ForMain04 {

	public static void main(String[] args) {
		System.out.println("for문 연습");

		// 1 ~ 10까지 숫자 중, 홀수면 "홀수", 짝수면 "짝수'가 출력되는 프로그램
		for (int y = 1; y <= 10; y++) {
			if (y % 2 == 0) { // 짝수일 때
				System.out.print("짝수 ");
			} else { // 홀수일 때
				System.out.print("홀수 ");
			}
		}
		System.out.println();
		// for문과 if문을 활용하여 아래 출력 결과를 나타내시오
		// * 1꼬마 2꼬마 3꼬마 인디언
		// * 4꼬마 5꼬마 6꼬마 인디언
		// * 7꼬마 8꼬마 9꼬마 인디언
		// * 10꼬마 인디언 보이~

		for (int x = 1; x <= 10; x++) { // 1~10
			System.out.print(x + "꼬마 "); // 1~10까지 꼬마 공통
			if (x % 3 == 0) { // 3 6 9
				System.out.println("인디언"); // 패턴 찾기
			} else if (x % 10 == 0) {
				System.out.println("인디언 보이~");

			}
		}

	} // end main()

} // end ForMain04
