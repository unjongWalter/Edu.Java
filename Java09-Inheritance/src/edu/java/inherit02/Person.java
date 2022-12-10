package edu.java.inherit02;

public class Person { // 부모
	// 멤버 변수
	private String name;
	
	// 기본생성자
	public Person() { // 부모부터 불려오네... 먼 죄야
		System.out.println("Person 생성자");
	}

	// 매개변수가 있는 생성자
	public Person(String name) {	
		this.name = name;
		System.out.println("Person(name) 생성자");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
		
}
