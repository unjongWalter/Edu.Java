package edu.java.contact01;

// 데이터 클래스(이름, 연락처, 이메일)
public class ContactT {
	// 멤버변수(필드, 프로퍼티) 1. 뭘 다룰지 먼저
	private String name;
	private String phone;
	private String email;
	
	// 기본 생성자 2. 기본내놔
	public ContactT() {}
	
	// 3. 변수
	public ContactT(String name, String phone, String email) {
		
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	// 4. 게터세터
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

	// 5. 오른쪽 tostring 추후 설명주실예정
	@Override
	public String toString() {
		return "ContactT [name=" + name + ", phone=" + phone + ", email=" + email + "]";
	}
	
	// 6. 보여주기 메소드
	public void displayInfo() {
		System.out.println("이름 : " +  name);
		System.out.println("전화번호 : " + phone);
		System.out.println("이메일주소 : " + email);
	}
	

}
