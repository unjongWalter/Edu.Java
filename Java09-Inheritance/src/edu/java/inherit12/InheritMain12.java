package edu.java.inherit12;

// abstract : 추상적인, 실체가 없는

// abstract 메소드(추상 메소드) :
// - 메소드의 원형(prototype : 리턴타입, 이름 매개변수)만 선언하고
//   메소드의 본체(body : {})를 구현하지 않는 메소드
// - {...}이 없음
// - 선언 타입
//   abstract 리턴타입 메소드이름(매개변수1, 매개변수2, ...);

// abstract 클래스(추상클래스) :
// - 추상 메소드를 하나라도 가지고 있는 클래스
// - 선언 타입
// abstract class 클래스이름{..}
// - 추상 클래스는 인스턴스를 생성 불가(호출 x)
// - 상속받는 클래스에서 메소드를 override하면 인스턴스를 생성 가능

abstract class TestAbstract {
	// 멤버변수
	private int x;

	// 메소드
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	// 추상 메소드 : 본체가 없는 메소드
	public abstract void hello(); // abstract class안에서만 사용 가능

} // end TestAbstract

class TestChild extends TestAbstract {

	@Override //TestChild 빨간 맛 ->오버라이드 생성필수
	public void hello() {
		System.out.println("hi!.!.!.!");		
	}	
}

public class InheritMain12 {

	public static void main(String[] args) {
		// 추상 클래스는 인스턴스를 생성 불가
//		TestAbstrac test1 = new TestAbstract();
		
		TestChild child = new TestChild();
		child.setX(100000);
		System.out.println("x = " + child.getX());
		child.hello();
		
	} // end main()

} // end InheritMain12
