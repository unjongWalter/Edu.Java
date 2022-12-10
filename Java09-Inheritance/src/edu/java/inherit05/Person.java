package edu.java.inherit05;

public class Person {
	private String name;
	
	public Person() {}
	
	public Person(String name) {
		
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	// 자바의 모든 클래스는 java.lang.Object 클래스를 상속받아서 만들어짐
	// 자바의 모든 클래스는 Object 클래스의 public 메소드들을 사용 가능
	// - 패키지이름, 클래스이름@참조값(주소값) 리턴
	@Override // annotation : 특정 변수나 함수의 상태를 표시
	public String toString() {		
		return name + "입니까?";
	}
}
