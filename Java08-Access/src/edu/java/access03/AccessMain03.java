package edu.java.access03;

// 캡술화(encapsulation) // 필수이해 게터세터로 우회하여 사용하는 것
// - 클래스를 설계할 때, 멤버 변수(필드)들을 private으로 선언하여
// 외부 클래스에 필드들을 직접 접근해서 읽거나 쓰지 못하게 하는 것
// - 필요한 경우에 한하여 public 메소드를 정의하여
// private 멤버 변수를 간접적으로 읽거나 쓰는 것을 가능하게 할 수 있음

public class AccessMain03 {
	// get-읽기 set-쓰기
	public static void main(String[] args) {
		MyNumber num = new MyNumber(100);
		num.getNumber(); //읽을 수 있음, 바꿀 수 없음
		System.out.println("number = " + num.getNumber());
		
		num.setNumber(10);
		System.out.println("number = " + num.getNumber());
		
		num.addToNumber(10);
		System.out.println("number = " + num.getNumber());
		
	} //end main()

} //end AccessMain03

