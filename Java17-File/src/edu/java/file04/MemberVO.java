package edu.java.file04;

import java.io.Serializable;

// 객체(Object) 타입을 파일에 쓰거나, 파일에서 읽을 때
// Serializable(직렬화) 인터페이스를 구현하는 클래스로 선언하면 됨
// 구현해야 할 추상 메소드는 없기 떄문에 implements Serializable만 추가함
public class MemberVO implements Serializable { // 파일 읽어올때 사용

	private int no;
	private String id;
	private String pw;
	
	public MemberVO() {}

	public MemberVO(int no, String id, String pw) {
		super();
		this.no = no;
		this.id = id;
		this.pw = pw;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	@Override
	public String toString() {
		return "MemberVO [no=" + no + ", id=" + id + ", pw=" + pw + "]";
	}
	
}
