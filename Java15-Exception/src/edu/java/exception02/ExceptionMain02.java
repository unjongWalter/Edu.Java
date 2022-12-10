package edu.java.exception02;

import java.util.Scanner;

public class ExceptionMain02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("예외 사례"); // 입출력 시 잦음
		Scanner sc = new Scanner(System.in);

//		System.out.println("숫자?");
//		int n1 = sc.nextInt();
//		int n2 = sc.nextInt();
//
//		if (n2 != 0) {// 범위 지정하여 0을 나누는 미친짓 막아두기.
//
//			int result = n1 / n2;
//			System.out.println("result = " + result);
//		} else {
//			System.out.println("n2값은 0이 아닌 숫자로 입력해");
//		}
		// 예외 처리 : try 구문
		// - 예외 발생 상황에 대해 처리해주는 기능
		// try{
		// 		정상 실행 문장;
		// } catch (예외클래스 변수이름){
		//		예외 상황 때 실행 문장
		// }
		System.out.println();
		try {
			System.out.println("try 내부");
			System.out.println("n3 입력>");
			int n3 = sc.nextInt();
			System.out.println("n4 입력>");
			int n4 = sc.nextInt();
			int result = n3/n4;
			System.out.println("result : " + result);
			
		} catch (Exception e) {
			System.out.println("예외 발생 : " + e.getMessage());
		}
		System.out.println("종료해버린다.");
		sc.close();
		
	} //end main()

} // end ExceptionMain02
