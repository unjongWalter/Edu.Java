package edu.java.inherit01;
// 기본티비를 상속받은 스마트티비
public class SmartTv extends BasicTv{
	// 멤버변수
	private String ip;
	
	// 생성자
	public SmartTv() {}

	// 게터세터
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Override
	public String toString() {
		return "SmartTv [ip=" + ip + "]";
	}	
	
	
	
	
}//end SmartTv
