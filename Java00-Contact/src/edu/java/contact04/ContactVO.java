package edu.java.contact04;

import java.io.Serializable;

public class ContactVO implements Serializable {// serial 필수 떙기기
	// 연락처 멤버 변수와 생성자, getter/setter 메소드들을 정의(기존의 Contact 클래스)
	private String name;
	private String phone;
	private String email;

	public ContactVO() {}

	public ContactVO(String name, String phone, String email) {
		this.name = name;
		this.phone = phone;
		this.email = email;
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
		return "name = " + name + ", phone = " + phone + ", email = " + email + "]";
	}

} //end ContactVO
