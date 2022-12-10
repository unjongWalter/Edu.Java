package edu.java.If01;

import java.util.Scanner;

// 흐름제어(Flow control)
// - 프로그램의 실행 흐름을 개발자가 원하는 방향으로 바꿀 수 있음
// - 제어문이라고 부름
// - 제어문에는 조건문과 반복문이 존재
// - 조건문 : if, if-else, if-else if-else, switch
// - 반복문 : for, while, do-while

public class IfMain01 {

	public static void main(String[] args) {
		System.out.println("if문");
		
		// if(조건) {본문}
		// - 조건이 참(true)이면 본문을 실행
		Scanner sc = new Scanner(System.in);
		int score = sc.nextInt();
		
		// 만약 score이 90점 이상이면
		if (score >= 90) {
			System.out.println("점수가 90점 이상입니다.");
			System.out.println("등급은 A입니다.");
			
		}
		// 만약 score가 90점 미만이면
		if (score < 90) {
			System.out.println("점수가 90점 미만입니다.");
			System.out.println("등급은 미정입니다.");
		}	
		
		// 90점이 애매해질떄 : <90, >=90 동시에 적용시... 방지방법은 다음 스테이지로
		sc.close();
	} //end main()

} // end IfMain
