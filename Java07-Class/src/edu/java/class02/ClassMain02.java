package edu.java.class02;

public class ClassMain02 {

	public static void main(String[] args) {
		// 기본 생성자를 사용하여 MyRectangle 클래스의 인스턴스 생성
		MyRectangle rect1 = new MyRectangle(); // 타입 = 기본생성자
		
		rect1.width = 3.0; // rect1의 width 변수에 3.0을 저장(.은 하위개념)
		rect1.height = 4.0;
		System.out.println("가로 : " + rect1.width);
		System.out.println("세로 : " + rect1.height);
		System.out.println("넓이 : " + rect1.calcArea()); // My- 28~29에 이미 나와있다.
		
		System.out.println("=============");
		
		// 매개변수가 있는 생성자를 호출하여 인스턴스 생성
		MyRectangle rect2 = new MyRectangle(10.0, 20.0);
		System.out.println("가로 : " + rect2.width);
		System.out.println("세로 : " + rect2.height);
		System.out.println("넓이 : " + rect2.calcArea());
		
	} //end main()
	
} //end ClassMain02
