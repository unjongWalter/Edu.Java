package edu.java.homework;

public class Point {
	// 오른쪽 마우스 하는것 고고
	// 멤버 변수 선언
	private double x, y;

	public Point() {} // 기본 생성, 마우스 오른쪽 어퍼클라스
	
	// 마우스 오른쪽 매개변수 생성자 자동 using fields, super 지우기
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	
	// 마우스 오른쪽 게터세터
	public double getX() {
	return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	
	public double distance(Point pt) {
		return Math.sqrt((x - pt.x) * (x - pt.x) + (y - pt.y) * (y - pt.y));
	}
}
