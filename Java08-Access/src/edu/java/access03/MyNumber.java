package edu.java.access03;

public class MyNumber {
	// 멤버 변수
	private int number;
	
	// 생성자
	public MyNumber(int number) {
		this.number = number;
	}
	
	// private 멤버 변수를 간접적으로 읽어오는 메소드 - getter
	public int getNumber() {
		return number;
	}
	
	// private 멤버 변수를 간접적으로 변경하는 메소드 - setter
	public void setNumber(int number) {
		this.number = number;
	}
		
	public void addToNumber(int x) {
		System.out.println("addToNumber() 티나게 호출됨");
		number -= x;
	}
	
}
