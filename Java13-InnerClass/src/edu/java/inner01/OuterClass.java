package edu.java.inner01;

// 변수 선언 :
// 1. 멤버변수(필드) : 클래스에서 선언된 변수
// - 클래스 내부 어느 곳에서나 사용할수 있는 변수
// - 수식어(public, private, static, ...)를 사용할수 있음
// 2. 지역변수 : 메소드 안에서 선언하는 변수
// - 지역 변수가 선언된 곳에서부터 변수가 속한 블록({})이 끝나는 곳까지 사용할 수 있는 변수
// - 접근 수식어(public. private, static, ...)을 사용할 수 없음
// - final은 사용가능

// 내부 클래스(Inner Class) : 다른 클래스 내부에서 정의된 클래스
// 1. 멤버 내부 클래스(member inner class)
// - 멤버 변수를 선언하는 위치에서 정의하는 내부 클래스
// - 외부 클래스의 인스턴스가 생성되어야만 객체 생성이 가능함
// 2. static 내부 클래스(static inner class), 중첩 클래스(nested class)
// - 멤버 변수를 선언하는 위치에서 static으로 정의한 내부 클래스
// - 외부 클래스의 인스턴스를 생성하지 않아도 객체 생성 가능
// - 외부 클래스의 상관이 없는 클래스라고 생각해도 됨
// 3. 지역 내부 클래스(local inner class) : 메소드 안에서 정의하는 클래스
// 4. 익명 클래스(Anonymous class) : 이름이 없는 내부 클래스
// -> 림다 표현식 사용 가능 key point

// Outer를 먼저 써야 Inner를 쓴대!
public class OuterClass {
	// 멤버 변수
	private int value1;
	
	// 생성자
	public OuterClass(int v){
		this.value1 = v;	
	}
	// 메소드
	public void display() {		
		System.out.println("value1 = " + value1);
	} //end display()
	
	// 멤버 내부 클래스
	class InnerClass{
		private int value2;
		public InnerClass(int v) {
			this.value2 = v;			
		}
		
		// 외부 클래스의 멤버 변수는 내부 클래스에서 직접 사용이 가능
		public void setOuterValue(int value) {
			value1 = value;
		}
		
		public void printValues(){
			// 외부 클래스의 멤버 변수 출력
			System.out.println("outer class value : " + value1);
			
			// 내부 클래스의 멤버 변수 출력
			System.out.println("inner class value : " + value2);			
		}		
		
	} //end InnerClass	
	
} //end OuterClass
