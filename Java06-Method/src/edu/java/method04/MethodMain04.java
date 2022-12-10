package edu.java.method04;

import java.util.Scanner;

public class MethodMain04 {
	// 객체지향은 유지보수 측면으로 사용!
	// 주소값이 같은 애들은 같은 애들이다 ((scores들 전부!))
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("배열을 매개변수로 갖는 메소드");

		// 정수(int) 5개를 저장할 수 있는 배열 선언
		int[] scores = new int[5];
		System.out.println("주소값 : " + scores); // 컴퓨터에 현재 저장된 위치로 이해

		// 배열에 데이터 입력
		inputScores(scores); // scores는 주소값을 인차로 전달함 // scores는 택배송장같은 개념

		// System.out.println(scores[1]);

		// 배열값 출력
		printScores(scores); // ctrl 누르고 찾아갈 수 있음

		// 배열에 저장된 점수들의 총합을 출력
		int total = calcTotal(scores);		
		System.out.println("합계 = " + total);		
		
	} // end main()	

	// 배열에 점수를 입력하는 기능
	private static void inputScores(int[] scores) { // 주소값을 전달받음
		System.out.println("주소값 : " + scores);
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < scores.length; i++) {
			System.out.println("점수 : " + i + "번째 입력>");
			scores[i] = sc.nextInt();
		}
		sc.close();
	}// end inputScores()

	private static void printScores(int[] scores) {
		System.out.println("주소값 : " + scores);
		for (int x : scores) {
			System.out.println("입력한 점수 : " + x);
		}

	} // end printScores()
	
	private static int calcTotal(int[] scores) {
		int total = 0;
		for(int i = 0; i < scores.length; i++) {
			total += scores[i];
		}
		return total;
	} //end calcTotal()	

} // end MethodMain04
