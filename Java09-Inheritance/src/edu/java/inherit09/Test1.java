package edu.java.inherit09;

public class Test1 {
	private int a; // 클래스 에서만
	int b; // 패키지 내
	protected int c; // 상속 또는 패키지 내
	public int d; // 전부
		
	public void display() {
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("c = " + c);
		System.out.println("d = " + d);
	}
}
