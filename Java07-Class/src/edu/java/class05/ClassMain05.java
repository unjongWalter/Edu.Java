package edu.java.class05;

import java.util.Scanner;

public class ClassMain05 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String id = sc.nextLine();
		String password = sc.nextLine();
		
		// 인스턴스 생성
		Member member = new Member();
		boolean result = member.login(id, password); // 주소값 전송
		
		if(result) {
			System.out.println("로그인 성공");
		} else {
			System.out.println("다시 확인해");
		}
		sc.close();

	} //end main()

} //end ClassMain05
