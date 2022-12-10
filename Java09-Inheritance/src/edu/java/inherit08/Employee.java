package edu.java.inherit08;

public class Employee {
	// 멤버변수
	private String name;
	
	// 생성자
	public Employee() {
		super();		
	}

	public Employee(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void test() {
		System.out.println("직원");
	}
		
}
