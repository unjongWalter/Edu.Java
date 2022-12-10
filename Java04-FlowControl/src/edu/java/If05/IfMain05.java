package edu.java.If05;

import java.util.Scanner;

public class IfMain05 {

	public static void main(String[] args) {
		System.out.println("If-else 문자 조건 연습");
		// 문자 하나를 입력받아서 그 글자가
		// 1) A ~ Z이면, "영대문자"라고 출력 ~ch가 A 이상 Z 이하 표현 가능
		// 2) a ~ z이면, "영소문자"라고 출력
		// 3) 0 ~ 9이면, "숫자"라고 출력
		// 4) 그 외 경우는, "뭥미"라고 출력
		
		//Scanner sc = new Scanner(System.in); //tip
		//char ch1 = sc.nextLine().charAt(0); // 문자 하나 입력 후 저장(여러개 입력해도 한개로 인식), 다른 표현 반복
		//System.out.println(ch1);
		
		Scanner sc = new Scanner(System.in); //
		System.out.println("뭐든 써봐라");
		String str = sc.nextLine(); //tip 참조
		char ch = str.charAt(0); //tip 참조
		System.out.println("입력받은 문자 : " + ch);
		// - 입력받은 문자 하나가 A이상이고, Z이하인 경우, "영대문자"를 출력
		if('A'<= ch && ch <= 'Z') {
			System.out.println("영대문자");
		} else if ('a' <= ch && ch <= 'z') {
			System.out.println("영소문자");
		} else if ('0' <= ch && ch <= '9') { // 문자로 생각해서 '0' ~ '9'
			System.out.println("숫자");
		} else {
			System.out.println("뭥미");
		}
		sc.close();
				
		// 문자하나 입력받고, A를 아키식으로 변환, ~보다 크고 작다 && 같은 범위개념으로 접근
		// tip : nextInt() : 정수 입력, nextDouble() : 실수 입력, nextLine() : 문자열 한 줄을 입력
		// String str = sc.nextLine() : 문자 한개 입력
		// char ch = str.charAt(0);   // 문자열에서 첫번째 글자만 저장

	} //end Main()

} //end IfMain05
