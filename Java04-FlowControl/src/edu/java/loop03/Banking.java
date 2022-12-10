package edu.java.loop03;

import java.util.Scanner;

public class Banking {

	public static void main(String[] args) {
		System.out.println("Java bank");
		// while문과  Scanner를 이용하여 예금 ~ 종료 제공하는 코드 작성
		// 1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료
		// key : 선택 후 처음으로 돌아감, 4번 선택 시 종료
		// while(true)는 무한반복, while(run) 잦은 사용
		Scanner sc = new Scanner(System.in); 
		int bal = 0; // 예금 저장 변수
		boolean run = true; // while문의 반복 여부 검사
		
		while(run) { //연락처 프로그램도 활용 가능
			System.out.println("----------------------------------");
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료 ");
			System.out.println("----------------------------------");
			System.out.println("선택>"); // 1~4 이외를 선택하는 사람도 있겠구나...
			
			int choice = sc.nextInt(); // 선택된 값을 저장할 변수
			switch (choice) {
			case 1:
				System.out.println("예금액>");
				bal += sc.nextInt(); // 기존 값에 입력된 값을 가산
				break;
			case 2:
				System.out.println("출금액>");
				bal -= sc.nextInt(); // 기존 값에 입력된 값을 감산
				break;
			case 3:
				System.out.println("잔액>" + bal);				
				break;
			case 4:
				System.out.println("종료합니다.");		
				run = false;
				break;
			default:
				System.out.println("잘 골라라");
				break;
			}
			
		}	
		
		// sc.close(); 
		// int i = 1;
		// while(i <= 9) {
		// System.out.println(dan + " * " + i + " = " + dan * i); 
		// i++;						
	
	} //end main()

} //end Banking
