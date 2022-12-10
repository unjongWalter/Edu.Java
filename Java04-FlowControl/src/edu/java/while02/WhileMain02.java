package edu.java.while02;

import java.util.Scanner;

public class WhileMain02 {

	public static void main(String[] args) {		
		// 반복문 : 구구단 변형형태 다수, 패턴 찾기 key point, 중첩문 활용 while문 == for문 > for문 우선 선택
		System.out.println("while 구구단 연습");
		
		Scanner sc = new Scanner(System.in);
		int dan = 2; // 'int dan = sc.nextInt();' 입력받기로 활용
		sc.close(); // 닫아주기 습관화
		int i = 1;
		while(i <= 9) {
			System.out.println(dan + " * " + i + " = " + dan * i); //'dan*i'이 기본형태, 그 이후에 추가 패턴화
			i++;					
		}
		System.out.println("===========");
		
		int d = 2; // 2 ~ 9단으로 오토 출력
		while(d <= 9) {
			System.out.println(d + "단");
			i = 1;
			while(i <= 9) {
				System.out.println(d + " * " + i + " = " + d * i); //'d*i'이 기본형태, 그 이후에 추가 패턴화
				i++;
			}
			d++;
		}
		
		// for문으로 구구단 출력하기
		// 단 : 2 ~ 9
		// 곱하는 수 : 1 ~ 9
		for(int x = 2; x <= 9; x++) {
			System.out.println(x + "단"); // 기본프레임부터 작성 후, 내용을 채우자 2 ~ 9 단으로 나가자
			for(int y = 1; y <= 9; y++) { // for을 중첩시키자 1 ~ 9를 곱하게 만들자
				System.out.println(x + " * " + y + " = " + x * y);				
			}						
		}		
				
	} //end main()

} //end WhileMain02
