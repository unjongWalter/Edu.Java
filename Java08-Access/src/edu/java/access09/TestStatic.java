package edu.java.access09;

public class TestStatic {
	int num1; // 인스턴스 멤버변수
	static int num2; //클래스 멤버변수
	
	// 인스턴스 매소드
	public void display1() {
		System.out.println("num1 = " + num1);
		System.out.println("num2 = " + num2); // static선언하면 이탤릭체
	}
	
	public static void display2() {
// 		System.out.println("num1 = " + num1); // 인스턴스 생성없이 사용하니 에러코드
		// static 메소드는 인스턴스 생성 없이 사용가능
		// num1은 인스턴스 멤버 변수이므로 인스턴스 생성 후에 사용가능
		// static 메소드에서는 num1은 사용불가
		System.out.println("num2 = " + num2); 
	}
	
	
	
}