package edu.java.If04;

import java.util.Scanner;

public class IfMain04 {

	public static void main(String[] args) {
		System.out.println("if - else if - else 연습");
		
		//점수를 정수로 입력받아서 (이상, 미만 개념 숙지)
		//score가 90점 이상이면 "A"를 출력
		//score가 80점 이상이면 "B"를 출력
		//score가 70점 이상이면 "C"를 출력
		//score가 70점 미만이면 "F"를 출력
		
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		System.out.println("점수 등급은? "); // 썜's tip : 편의성 증대를 위해 보조적
		
		if(x >= 90) {
			System.out.println("A");
		} else if (x >= 80) {
			System.out.println("B");
		} else if (x >= 70) {
			System.out.println("C");
		} else {
			System.out.println("F"); //else if(score < 70)으로 작성도 가능, 열린마인드필요.
		}
		
	} //end main()

} //end IfMain04
