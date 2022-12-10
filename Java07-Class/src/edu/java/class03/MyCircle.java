package edu.java.class03;

public class MyCircle {
	
	// 멤버변수
	double radius; // 속성 성질, MyCircle의 radius, 값 미입력시 기본적으로 초기화라서 0.0 값을 가진다.
		
	// 기본생성자
	public MyCircle() {}
	
	// 생성자, 매개변수
	public MyCircle(double radius) {
		this.radius = radius; //this 자기자신(MyCircle 클래스)
		// 현재 클래스(MyCircle)에 있는 radius 변수에 외부에서 받아오는(매개변수) radius의 값을 저장한다.
	}

	// 메소드, 원의 면적 계산
	public double calcArea() {
		return 3.14 * radius * radius;
		
	} // end class()
	
} // end MyCircle