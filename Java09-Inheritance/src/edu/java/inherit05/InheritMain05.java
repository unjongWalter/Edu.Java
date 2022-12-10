package edu.java.inherit05;

// * 모든 클래스의 부모 클래스는 Object 클래스이다.
public class InheritMain05 {

	public static void main(String[] args) {
		Person p1 = new Person("돌리");
		System.out.println(p1.toString()); //Object 부모에 자동으로 들어가있다
		// toString() : 객체가 가지고 있는 정보를 문자열로 출력
		// Object 클래스의 toString은 모든 클래스에서 사용 가능
		// p1과 p1.toString()은 같은 결과를 출력
		
		// quiz
		// 1. Point 클래스
		// - 멤버변수(double x, double y)
		// - 기본 생성자, 매개변수 생성자
		// - toString 오버라이드해서 (x, y)형식 문자열을 리턴하는 메소드 생성
		// 2. main()함수에서 Point 변수 및 인스턴스 생성하고 아래 출력
		// (1.0, 2.0) (toString()메소드 활용) // 활용을 원하심
		
		Point po1 = new Point(1.0, 2.0);
		System.out.println(po1);
		
		String str = new String("문자열"); // str의 특이한 형태?
		System.out.println(str.toString());
	}

}
