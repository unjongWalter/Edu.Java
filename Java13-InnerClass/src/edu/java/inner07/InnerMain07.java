package edu.java.inner07;

interface Hello{ // 상속 주는놈
	public abstract void hello();
	
}//end Hello
class Person implements Hello{

	@Override // 상속받는놈
	public void hello() {
		System.out.println("hey");		
	}
	
}//end Person
class Dog implements Hello{

	@Override // 상속받는놈
	public void hello() {
		System.out.println("bark!");		
	}	
	
}//end Dog

public class InnerMain07 {
	public static void main(String[] args) {
		Person p1 = new Person(); // 원래 형태1
		p1.hello();
		
		Hello p2 = new Person(); // 원래 형태2
		p2.hello();
		
		Hello dog = new Dog(); // 원래 형태3
		dog.hello();		

		Hello cat = new Hello() { // cat 읍는디? 큰 Hello로 카바친다
			// override 써서 시작... 익명클래스 생성
			@Override
			public void hello() {
				System.out.println("meowwww");				
			} 			
		}; // 뒤에서 당황해라
		cat.hello(); // 미친...
		
		Hello father = new Hello() {

			@Override
			public void hello() {
				System.out.println("Im your father.");				
			}
			
		};// 뒤에다가 땀 흘려라.
		father.hello();
		
		// new Hello() {본체}
		// 본체 : Hello interface를 구현하는 클래스의 내용(객체)
		
		// * 익명클래스를 사용하는 이유
		// - 인터페이스의 메소드가 한 개인 경우,
		//   클래스 외부에서 선언하여 implements하지 않고 사용하기 위해
		// - 익명 클래스를 사용하면 클래스를 외부에서 생성할 필요가 없음
		// - 객체를 한 번 생성하고 더이상 생성하지 않을 경우 사용
	} //end main()

} //end InnerMain07
