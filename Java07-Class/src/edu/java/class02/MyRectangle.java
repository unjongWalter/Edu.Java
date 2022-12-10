package edu.java.class02;

// 클래스 :
// 		상태(속성, 성질) - 멤버 변수 (field, property)
// 		기능 - 메소드
// 		생성자(constructor) - 멤버 변수들을 초기화
// 			- 클래스 이름과 동일
// 			- 매개변수는 있을수도 있고, 없을 수도 있음
// 			- 클래스를 작성할 떄 생성자를 하나도 정의하지 않은 경우,
//			자바 커파일러가 기본 생성자를 자동으로 만들어줌.
// 			- 생성자를 하나라도 정의한 경우에는, 자동으로 기본 생성자를 만들지 않음

public class MyRectangle {
	// 멤버 변수
	double width; // 직사각형 가로 //클래스 바로 밑 변수(오른팔)
	double height; // 직사각형 세로
		
	// 생성자
	public MyRectangle() {} // 기본 생성자
	
	// 매개변수가 있는 생성자
	public MyRectangle(double width, double height) { // 오른팔 밑 왼팔
		this.width = width; // this는 곧 MyRectangle 클래스, 객체 자기자신이다. (내 안의) 오른팔 이것의 왼팔 
		this.height = height;		
	}
		
	// 메소드 
	public double calcArea() { // this 안써도 된다. 헷갈릴 일이 없으니까
		return width * height;
	
	// 매개변수 변경하는 것	
	// public void setWidth(double 10)	
		
	}
		
} //end MyRectangle
