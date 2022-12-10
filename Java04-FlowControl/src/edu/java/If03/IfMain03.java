package edu.java.If03;

import java.util.Scanner;

public class IfMain03 {

	public static void main(String[] args) {
		
		System.out.println("if - else if - else문");
		
		// if(조건1) {본문A}
		// else if(조건2) {본문B}
		// ...
		// else {본문C}
		// - 조건1이 참일 경우 본문A, 조건2가 참일 경우 본문B, 둘 다 아닐 경우 본문C가 실행
		// - else if 절은 1개 이상 작성 가능
		
		// x > 0, x < 0(==else), x == 0 해당 개념 명확화 필요
		// 자동 줄맞춤 : ctrl shift f
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		if(x > 0) {
			System.out.println("양수");
		} else if (x == 0) {
			System.out.println("0");
		} else {
			System.out.println("음수");
		}
		
	} // end Main()

} // end Ifmain03
