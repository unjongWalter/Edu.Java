package edu.java.class03;

public class ClassMain03 {
// 메인에서 호출한다.
	public static void main(String[] args) { // static 시작 우선
		
		// 기본 생성자를 사용하여, MyCircle 클래스의 인스턴스 생성		
		MyCircle circle = new MyCircle();
		
		System.out.println("반지름 : " + circle.radius + "cm 입니다.");				
		System.out.println("넓이 : " + circle.calcArea() + "cm 입니다.");

		// c1 객체의 반지름에 1.0 값을 저장하여 반지름과 면적 출력
		circle.radius = 1.0; 
		System.out.println("반지름 : " + circle.radius + "cm 입니다.");				
		System.out.println("넓이 : " + circle.calcArea() + "cm 입니다.");
		
		// 매개변수가 있는 생성자에 10.0을 값으로 주고 MyCircle 클래스의 인스턴스 생성
		MyCircle circle2 = new MyCircle(10.0);
		System.out.println("반지름 : " + circle2.radius + "cm 입니다.");				
		System.out.println("넓이 : " + circle2.calcArea() + "cm 입니다.");
		
	} //end main()

} //end ClassMain03