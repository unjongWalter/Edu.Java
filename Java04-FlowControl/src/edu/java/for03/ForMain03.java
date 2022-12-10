package edu.java.for03;

public class ForMain03 {

	public static void main(String[] args) {
		System.out.println("for문 연습");

		// 1 ~ 100까지 정수 중에서 10의 배수들만 출력
		for (int x = 1; x <= 100; x++) {
			if (x % 10 == 0) {
				System.out.print(x + " ");
			}

		}
		System.out.println();

		// 1 2 3 ... 10
		// ....
		// 91 92 93 ... 100
		for (int x = 1; x <= 100; x++) { // 일단 1 ~ 100 나열
			System.out.print(x + " ");
			if (x % 10 == 0) { // 줄바꿈을 이후에, 특이점 발생 시점 파악이 key point
				System.out.println(); // sysout의 순서 중요, 그에 따라 결과값 다름
				// x = 1일 때, 1을 출력하고 x % 10 == 1 이므로 줄바꿈 수행 x
				// x =10일 때, 10을 출력하고 x % 10 == 0 이므로 줄바꿈 수행 o

			}
		}

	}

}