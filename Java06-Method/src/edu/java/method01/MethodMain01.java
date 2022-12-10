package edu.java.method01;
// 메소드 : 기능을 수행하기 위한 코드, 주로 반복적 기능 수행
// - 메소드는 클래스 안에서, 다른 메소드 외부에서 만든다.
// - (주의) 메소드 안에 또다른 메소드를 만들 수 없음
// - 메소드 정의 : int    add       input
//		[수식어] 리턴타입 메소드이름([매개변수1, 매개변수2, ...]) {본문}
//			수식어 종류 : public, private, static, ... - public 생략 가능
//			리턴타입 : 자료타입(int, double, String, class, ...) void(output 타입이 없음)/(null는 내용없음)
//			매개변수 : 메소드를 호출할 때 전달하는 데이터
//						전달받는 데이터가 없으면 매개변수 선언이 없어도 됨
//			{본문} : 메소드는 본체(body). 수행해야할 기능을 작성

public class MethodMain01 { // method
	// 메소드 생성
	public static void sayHello(String name) { // String name : 매개변수(parameter)
		System.out.println("하잇");
		System.out.println("난 " + name + "이래");
		
	} //end sayHello()
	
	public static void sayAge(int age) {
		System.out.println("난 " + age + "세 지롱");
	}
	
	// static 수식어 : 프로그램이 실행될 때 생성하도록 선언하는 키워드
	// * static 메소드에서는 static으로 선언된 메소드만 호출 가능
	public static void main(String[] args) { // main method
		// public static void main(String[] args){} 를 이런형태처럼 내부에서 만들 수 없다
		System.out.println("난 콤퓨타"); // 직접 말하는 것
		System.out.println("쟨 스마트폰");
		
		sayHello("me"); // sayHello라는 메소드, main에서 me를 호출한다.
		sayHello("ho"); // == 메소드호출, 인자값으로 "me", "ho"를 넘겨줌
		sayAge(3);
		
	} //end main()

} //end MethodMain01
