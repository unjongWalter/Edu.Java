package edu.java.contact06;
// A - B - C - D : 각 과정 별로 로그 찍어가며 오류확인 필수
import java.io.Serializable;

// 데이터 클래스(번호, 이름, 연락처, 이메일) 데이터를 묶어서 보내느 형태 VO
public class ContactVO implements Serializable{
	
	// 멤버 변수(필드, 프로퍼티)
	private int contactId; // 인서트에 불필요... 자동 카운팅되니까
	private String name;
	private String phone;
	private String email;
	
	public ContactVO() {}

	public ContactVO(int contactId, String name, String phone, String email) {
		super();
		this.contactId = contactId;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
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
		return "ContactVO [contactId=" + contactId + ", name=" + name + ", phone=" + phone + ", email=" + email + "]";
	}
	
}//end ContactVO
