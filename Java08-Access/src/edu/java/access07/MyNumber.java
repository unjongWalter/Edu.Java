package edu.java.access07;
// 어렵게 꼬아둔 코드 예시
public class MyNumber {
	// 멤버 변수
	private int number;
	
	public MyNumber() {}
	
	public MyNumber(int number) {
		this.number = number;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	public void addToNumber(int x) {
		number += x;
	}
	// 기능 : 현재 객체(this : MyNumber)의 number 변수와
	//		매개변수에 있는 number를 더한 후, 현재 객체의 number에 저장
	// 리턴타입 : MyNumber
	// 함수이름 : add
	// 매개변수 : MyNumber number
	
	public MyNumber add(MyNumber number) { // 어렵게???
		this.number = this.number + number.number;
		return this;
		
	}
		
}
