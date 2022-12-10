package edu.java.project01;

import java.io.Serializable;
import java.sql.Date;

public class JoinVO implements Serializable{

	// 멤버변수
	private int joinNo;
	private String joinId;
	private String joinPassword;
	private String joinName;
	private String joinPhone;
	private String joinEmail;
	
	// 아이디비번만 사용할 것 만들어라.
	public JoinVO(String joinId, String joinPassword) {
		super();	
		this.joinId = joinId;
		this.joinPassword = joinPassword;		
	}	
	
	public JoinVO() {}
	
	public JoinVO(int joinNo, String joinId, String joinPassword, String joinName, String joinPhone, String joinEmail) {
		super();
		this.joinNo = joinNo;
		this.joinId = joinId;
		this.joinPassword = joinPassword;
		this.joinName = joinName;
		this.joinPhone = joinPhone;
		this.joinEmail = joinEmail;
	}
	public int getJoinNo() {
		return joinNo;
	}
	public void setJoinNo(int joinNo) {
		this.joinNo = joinNo;
	}
	public String getJoinId() {
		return joinId;
	}
	public void setJoinId(String joinId) {
		this.joinId = joinId;
	}
	public String getJoinPassword() {
		return joinPassword;
	}
	public void setJoinPassword(String joinPassword) {
		this.joinPassword = joinPassword;
	}
	public String getJoinName() {
		return joinName;
	}
	public void setJoinName(String joinName) {
		this.joinName = joinName;
	}
	public String getJoinPhone() {
		return joinPhone;
	}
	public void setJoinPhone(String joinPhone) {
		this.joinPhone = joinPhone;
	}
	public String getJoinEmail() {
		return joinEmail;
	}
	public void setJoinEmail(String joinEmail) {
		this.joinEmail = joinEmail;
	}
	@Override
	public String toString() {
		return "JoinVO [joinNo=" + joinNo + ", joinId=" + joinId + ", joinPassword=" + joinPassword + ", joinName="
				+ joinName + ", joinPhone=" + joinPhone + ", joinEmail=" + joinEmail + "]";
	}
		
}//end JoinVO
