package edu.java.exception07;

import java.util.Scanner;

public class ExceptionMain07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("try-catch-finally");
		// try {
		// 		정상 경우에 실행할 코드들;
		// } catch (Exception e) {
		// 		예외 상활 떄 실행할 코드;
		// } finally {
		// 정상 경우든, 예외든 항상 실행할 코드
		// }
		
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("try starts");
			int a = sc.nextInt();
			int b = sc.nextInt();
			int result = a/ b ;
			System.out.println("try ends : result = " + result);
					
		} catch (Exception e) {
			System.out.println("Exception : " + e.toString());
		}	
		
		finally {
			System.out.println("finally : 언제 실행스?");
			sc.close();
		}
		System.out.println("the end");
	}//end main07

} //end ExceptionMain07
