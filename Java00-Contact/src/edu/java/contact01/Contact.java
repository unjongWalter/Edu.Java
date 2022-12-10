package edu.java.contact01;

public class Contact {
//	private int no;
	private String name;
	private String phone;
	private String email;
	
	// 기본 생성자
	public Contact() {}
	
	// 매개
	public Contact(String name, String phone, String email) {
		
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	// 읽고, 쓰고 게터세터
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	// 전체 보여주기용 메소드
	public void displayInfo() {
		System.out.println("이름 : " +  name);
		System.out.println("전화번호 : " + phone);
		System.out.println("이메일주소 : " + email);
	}
	
} //end class contact
