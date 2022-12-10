package edu.java.access04;

public class Contact {
// 연락처 정보 저장 툴(class)
// 멤버변수 (인덱스 번호, 이름, 전번, 이메일 등)

	// 멤버 변수
	private int no;
	private String name;
	private String phone;
	private String email;

	public Contact() {
	}
	// 오른쪽 마우스, 소스 -> 제너 컨스 어퍼 && 유징 필드 && 게터세터 세가지 적용
	public Contact(int no, String name, String phone, String email) {

		this.no = no;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}
	
	// 총 8가지 게터 세터
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

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
	@Override
	public String toString() {
		return "Contact [no=" + no + ", name=" + name + ", phone=" + phone + ", email=" + email + "]";
	}	
	
}
