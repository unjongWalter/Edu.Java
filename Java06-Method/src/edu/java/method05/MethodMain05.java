package edu.java.method05;

// 메소드 overloading ~ 이렇게 설계되어 있으니 잘 활용하세요 ~ 
// 1. 매개변수의 개수가 다르거나
// 2. 매개변수의 타입이 다른 경우
// 같은 이름으로 정의할 수 있음
// (주의) 메소드의 리턴타입만 다른 경우는 같은 이름으로 메소드를 정의할 수 없음

public class MethodMain05 {

	public static void main(String[] args) {
		System.out.println();
		System.out.println("문자열");
		System.out.println(1);
		System.out.println(1.0);
		System.out.println(true);
				
		sayHello(); // call 방식 유의
		sayHello(null);
		sayHello(0, null);
		sayHello(null, 0);
		
	} //end main()

	public static void sayHello() {
		System.out.println("흐엥");
	} //end sayHello()
	
	public static void sayHello(String name) { // 매개변수 String을 추가하니 사용가능하더라, 오버로딩
		System.out.println("hi");
		System.out.println("Je suis " + name + ".");			
	} //end sayHello(String)
		
	public static void sayHello(String name, int age) {
		System.out.println("name : " + name);
		System.out.println("age : " + age);
	} //end 
		
	public static void sayHello(int age, String name) { // 순서가 다른건 다른것!
		System.out.println("age : " + age);
		System.out.println("name : " + name);
	} //end 
		
} //end MethodMain05
