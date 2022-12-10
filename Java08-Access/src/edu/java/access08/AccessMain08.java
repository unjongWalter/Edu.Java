package edu.java.access08;

import java.util.Scanner;

// * (JRE)Java Runtime Environment
// - Java 애플리케이션을 생성하고 실행하기 위한 구성 요소
// - JRE는 Java 개발도구(Java Environment Kit, JDK)의 일부
// - 운영체제와 Java 프로그램 사이에서 조정 역할을 수행

// * (JVM)Java Virtual Machine
// - Java 바이트 코드를 실행하는 주체(소프트웨어)
// - 특정 공간을 할당하여 메모리 관리
 
// * JVM이 관리하는 메모리 영역:
// - stack(스택) : 지역 변수들이 저장되는 메모리 영역
// - Heap(힙) : 인스턴스(참조 자료형class string array 등)가 저장되는 메모리 영역
// - Method(메소드) : static으로 선언한 변수, 메소드의 실행 코드들이 저장되는 메모리 영역

// * final 제한자
// - 초기화된 값을 바꿀 수 없음.
// - final : 최종적인, 변경할 수 없는
// - final + 멤버변수, 지연변수 : 상수(한 번 초기화된 값을 변경할 수 없는 변수)
// - final + 메소드 : override 할 수 없는 메소드
// - final + 클래스 : 상속을 허락하지 않는 클래스

public class AccessMain08 { // 멤버변수

	public static final int MENU_INSERT = 1; // main에서 사용하기 위해 static사용
	public static final int MENU_DELETE = 2; // rule : 대문자 굵은애 static final
	public static int test = 100;
	
	public static void main(String[] args) { // 지역변수
		// 멤버변수 : 클래스 단계에서 선언된 변수
		// 지역변수 : 메소드나 특정 위치에 포함된 곳에서 선언된 변수
		// - 지역변수의 이름은 멤버 변수와 동일 선언불가
		int x = 10;
		final int y = 10;

		x = 123;
		// 일반적인 지역변수는 초기화 이후에도 언제든지 값 변경가능
//		y = 100;
		// final 지역변수는 처음 초기화된 값을 변경불가
				
		System.out.println(MENU_INSERT);
				
		test = 20;
		// final이 아닌 멤버 변수는 언제든지 초기값 변경가능
		
		System.out.println("1. 등록. 2. 삭제.");
		System.out.println("메뉴 선택>");
		Scanner sc = new Scanner(System.in);
		int select = sc.nextInt();
		switch (select) {
		case MENU_INSERT: // 유지보수 측면에서 1, 2 같은 숫자대신...
			System.out.println("got it");
			break;
		case MENU_DELETE:
			System.out.println("ㅡ.ㅡ?");
			break;			
		default:
			break;
		}
		
	} //end main()

} //end AccessMain08
