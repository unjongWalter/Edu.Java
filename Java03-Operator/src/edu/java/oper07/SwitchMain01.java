package edu.java.oper07;

import java.util.Scanner;

// switch - case 문
// -if문과 비슷하지만 비교 값을 정형화하는 방식
// - 변수와 일치하는 값에 따라 해당 case문이 실행됨
// switch(변수) {
// 		case 값1 : ... // ==if
//			break;
//		case 값2 : ... // ==else if
//			break;
//			default : ... // ==else
//			break;
// ]

public class SwitchMain01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		
		// if문
		System.out.println("if - else문");
		if(a==1) {
			System.out.println("1번 선택");			
		} else if(a==2) {
			System.out.println("2번 선택");
		} else {
			System.out.println("그 외 선택");
		}
		
		// switch문 - 정형화된 형태만 가능
		System.out.println("switch문");
		switch (a) {
		case 1:
			System.out.println("1번 선택");
			break; // break빠지면 오류발생
		case 2:
			System.out.println("2번 선택");
			break;
		default:
			System.out.println("그 외 선택");
			break;
		}
				
	} //end main()

} //end SwitchMain
