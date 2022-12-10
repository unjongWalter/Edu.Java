package edu.java.inherit04;

public class Animal {// parents
	// 멤버변수
	private String name;
	
	// 생성자
	public Animal() {}
	public Animal(String name) {
		this.name = name;		
	}
	
	public void speak() {
		System.out.println("네가 말을...?");
	}
}
