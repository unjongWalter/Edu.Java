package edu.java.inherit02;

public class BusinessPerson extends Person { // 자식
	// 멤버 변수
	private String company;

	// * 생성자
	// - 자식 클래스의 생성자가 호출되면, 부모 클래스의 생성자가 먼저 호출되는 구조
	// - 부모 클래스의 생성자를 명시적으로(explicitly) 호출할 때는 super();
	// - 부모 클래스의 생성자를 명시적으로 호출하지 않으면, 
	// 	 부모 클래스의 "기본 생성자"가 자동으로 호출 됨
	// - 부모 클래스의 매개변수가 있는 생성자는 자동으로 호출되지 않기 때문에,
	//   필요한 경우는 반드시 명시적으로 호출해야 함
	// - 예) super(name)
	// - 자식 클래스의 생성자에서 부모 클래스의 생성자를 호출할 때는
	//   다른 어떤 코드보다 먼저 부모 클래스를 호출해야 함 : 기본 생성자 걍 써라.
		
	// source = gene~superclass
	public BusinessPerson() {
//		super(); // 부모 클래스의 기본생성자 호출 -> 생략 가능
		// super() == person()
		System.out.println("BusinessPerson() 생성자");
	}
	public BusinessPerson(String name) {
		super(name); // 만약 부모클래스의 매개변수 생성자를 명시적으로 호출할 경우
					// -> 생략 불가!
		System.out.println("BusinessPerson(name) 생성자");
		
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
		
} //end BusinessPerson
