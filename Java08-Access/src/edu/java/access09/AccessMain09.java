package edu.java.access09;

// * static : 멤버변수 또는 메소드를 선언(정의)할 때 사용
// - 인스턴스 생성 이전에 프로그램이 처음 시작될 때 static 메모리 영역에 자동으로 생성

// * 클래스 변수(static) : static으로 선언한 멤버변수
// - 인스턴스를 생성하지 않아도 사용가능
// - static 변수는 메모리 영역에서 생성된 공간에서 공유됨 // 객체가 없어도 사용가능
// - 모든 인스턴스들이 공유하기 떄문에 값의 변경에 대해서 주의해야 한다
// - 사용형식 : 
// 		클래스이름, 변수이름

// * 인스턴스 변수 : static이 선언되지 않은 멤버변수
// - 인스턴스를 생성한 후에만 사용가능
// = 사용 형식 : 
//		침조변수, 변수이름

// * class 메소드(static 메소드) : static으로 선언한 메소드
// - 인스턴스를 생성하지 않아도 사용가능
// - 사용 형식 : 
// 		클래스이름, 메소드()

// * 인스턴스 메소드 : static으로 선언되지 않은 메소드
// - 인스턴스를 생성한 후에만 사용가능
// - 사용형식 : 
// 		참조변수, 메소드()

public class AccessMain09 {

	public static void main(String[] args) {
		// static 있으면 객체/인스턴스 생략하고 사용이 가능
		System.out.println(TestStatic.num2); // 초기화 0 값
		TestStatic.num2 = 123; // 이렇게 사용하면 안돼. 강사님 강조 // 주로 final과 사용
		
		System.out.println("---");
		// static 메소드 - 인스턴스 생성 없이 사용 가능		
		TestStatic.display2();
		
		System.out.println("---");
		TestStatic test = new TestStatic();
		System.out.println(test.num1);
		test.num1 = 100;
		test.display1(); // num2 = 123으로 나와버리면 큰1
		
		System.out.println("---");
		
		TestStatic test2 = new TestStatic();
		test2.display1();
		
	}//end main()

}//end AccessMain09
