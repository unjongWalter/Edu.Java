package edu.java.method03;

import java.util.Scanner;

public class MethodMain03 {

	public static void main(String[] args) {
		// 1. 국어, 영어, 수학 점수를 입력받고, 3개의 변수에 저장 // main에서 스캐닝 받자
		Scanner sc = new Scanner(System.in);
		int kor = sc.nextInt();
		int eng = sc.nextInt();
		int math = sc.nextInt();

		// 2. 입력받은 점수 출력
		System.out.println("국어 : " + kor);
		System.out.println("영어 : " + eng);
		System.out.println("수학 : " + math);

		// 3. 함수를 정의하여(주의) 세 과목 총점 출력 //main에서 출력해
		int sum = calcTotal(kor, eng, math);
		System.out.println("sum = " + sum);

		// 4. 함수를 정의하여 세 과목 평균 출력(소숫점까지)
		double avg = calcAverage(sum);
		System.out.println("avg = " + avg);

		// 5. 함수를 정의하여 평균에 따른 등급을 출력
		char grade = selecGrade(avg);
		System.out.println("grade = " + grade);
	}
	// 3. 총점을 리턴하는(tip) 함수 ==/ 출력이랑 다름
	// 메소드 이름 : calcTotal
	public static int calcTotal(int kor, int eng, int math) { // 3. 총점리턴
		return kor + eng + math;
	}
	// 4. 평균을 리턴하는 함수
	// 메소드 이름 : calcAverage()
	public static double calcAverage(int sum) { // 4. 평균리턴
		return sum / 3.0; // (double)sum /3; //배열이 아니라서 숫자 3을 직접 기입함
	}
	// 5. 등급을 리턴하는 함수
	// 메소드 이름 : selecGrade()
	// 100 ~ 90 => 'A'
	// 89 ~ 80 => 'B'
	// 79 ~ 70 => 'C'
	// 69 이하 => 'F'
	public static char selecGrade(double avg) {
		if(100 >= avg && avg >= 90) {
			return 'A';
		} else if(avg >= 80) {
			return 'B';
		} else if(avg >= 70) {
			return 'C';
		} else {
			return 'F';
				
	// 위랑 같음
	// char result;
	//	if(100 >= avg && avg >= 90) {
	//		return = 'A';
	//	} else if(avg >= 80) {
	//		return = 'B';
	//	} else if(avg >= 70) {
	//		return = 'C';
	//	} else {
	//		return = 'F';
				
		}
	} //end main()
} // end MethodMain03
