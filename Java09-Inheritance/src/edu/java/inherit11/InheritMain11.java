package edu.java.inherit11;

// final : 최종, 변경할 수 없는
// - final + 멤버 변수 or 지역 변수 : 상수(한 번 초기화된 값을 변경할 수 없는 변수)
// - final + 메소드 : override 할 수 없는 메소드
// - final + 클래스 : 상속을 허용하지 않는 클래스

class SuperClass{
	public void test() {
		System.out.println("test");
		
	}
	public final void testFinal() {
		System.out.println("final method");
	}
	
} //end SuperClass

class subClass extends SuperClass{ // 상속
	@Override
	public void test() {}
	
//	testFinal() // final으로 선언된 메소드는 override 불가능
}

public class InheritMain11 {

	public static void main(String[] args) {
		
	} //end main()

} //end InheritMain10
