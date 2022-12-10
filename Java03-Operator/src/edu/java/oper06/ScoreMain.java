package edu.java.oper06;

import java.util.Scanner;

public class ScoreMain {

	// 총점 및 평균 계산 프로그램 만들기
	// 1. 점수를 입력받자. 국어, 영어, 수학
	// - 변수 선언 : int 3(정수)개
	// 2. 총점(합산) 계산
	// - 국어, 영어, 수학 점수를 합산
	// ㄴ 합산을 저장하여 출력 
	// - 변수를 선언 : int 형으로 1개 선언
	// 3. 평균 계산
	// - 2번 값/3
	// ㄴ 평균을 저장하여 출력 -> 소숫점 셋째자리까지 출력
	
	public static void main(String[] args) {
		System.out.println("총점 및 평균 계산 프로그램");
		// 1. 입력받을 준비 : scanner 생성
		Scanner sc = new Scanner(System.in);
		// 2. 국어, 영어, 수학 점수를 정수로 입력받고 변수에 저장
		System.out.println("국어 점수 입력 : ");
		int kor = sc.nextInt();
		System.out.println("영어 점수 입력 : ");
		int eng = sc.nextInt();
		System.out.println("수학 점수 입력 : ");
		int math = sc.nextInt();
		// 3. 국어, 영어, 수학 점수를 출력 (부차적 작업, 필수아님)
		System.out.print("국어 : "); // print는 줄 바꿈 x, println은 줄 바꿈 o
		System.out.println(kor);
		System.out.print("영어 : ");
		System.out.println(eng);
		System.out.print("수학 : ");
		System.out.println(math);
		// 4. 총점을 계산하여 출력
		int sum = kor + eng + math;
		System.out.println("총점 : " + sum);
		// 5. 평균을 계산하여 출력(소숫점 셋째자리까지)
		double e = sum/3.0; // double로 주사용. 실수 나눗셈 몫 때 3.0으로 표기, operatormain01 참조
		System.out.printf("평균 : %.3f", e); // 소숫점 나타내기 할 때, printf와 콤마로 활용하기
		
		
		

	} // end main()

} // end ScoreMain
