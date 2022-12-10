package edu.java.inner05;

class OuterClass {
	private int value;
	public OuterClass(int value) {
		this.value = value;
	}
	
	public void test() {
		int x = 200; // 지역 변수(local variable)
		
		// 지역 변수를 선언하는 위치에서 정의하는 클래스 : 지역 클래스
		class LocalClass {
			private int value2; // 지역클래스의 멤버 변수
			
			// 지역 클래스의 생성자
			public LocalClass(int value2) {
				this.value2 = value2;
			}
			
			// 지역 클래스의 메소드
			public void display() {
				// 외부 클래스의 멤버 변수를 참조 가능
				System.out.println("outes's 1st value = " + value);
				
				// 메소드의 지역 변수 사용 가능
				System.out.println("x = " + x);
				
				// 지역 클래스의 멤버 변수를 참조 가능
				System.out.println("value2 = " + value2);
			} // end display()			
		} // end LocalClass
		
		// 지역 클래스의 인스턴스 생성 - 메소드 안에서만 가능
		LocalClass local = new LocalClass(300);
		local.display();
		
	} // end test()
	
} // end OuterClass

public class InnerMain05 {

	public static void main(String[] args) {
		OuterClass outer = new OuterClass(100); // outer부터 읽는다! 
		outer.test();
		
	} // end main()

} // end InnerMain05
