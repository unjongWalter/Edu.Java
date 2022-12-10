package edu.java.interface02;

//Java 버전 8부터 바뀐 인터페이스 :
// 인터페이스가 가질 수 있는 멤버들 : 
// 1. public static final 필드(멤버 변수) - Java 7 버전과 동일
// 2. public abstract 메소드 - Java 7 버전과 동일
// 3. default 메소드 :
//		- 본체(body)가 구현되어 있는 메소드
//		- default 키워드를 사용하여 선언
//		- 인스턴스가 생성되어야만 사용할 수 있는 메소드
// 4. static 메소드
// 		- 본체(body)가 구현되어 있는 메소드
//		- static 키워드 사용, 인스턴스 생성 없이 사용 가능 메소드

public interface TestInterface {
	public static final int MAX = 100;
	
	public abstract int insert(String id, String pw);
	
	public default void conncetDB() {
		System.out.println("DB CN Success");
	}
	public static void createDB() {
		System.out.println("DB CR Success");
	}
}
