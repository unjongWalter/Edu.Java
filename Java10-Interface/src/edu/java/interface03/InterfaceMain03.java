package edu.java.interface03;

// 클래스는 다중 상속 불가, 인터페이스는 다중 상속 가능
interface Test1{
	public abstract void test1();
} //end Test1

interface Test2{
	public abstract void test2();
} //end Test2

class TestImple implements Test1, Test2{

	@Override
	public void test2() {
		System.out.println("test2~");		
	}

	@Override
	public void test1() {
		System.out.println("test1~");		
	}
	
} //end TestImple

public class InterfaceMain03 {

	public static void main(String[] args) {
		TestImple imple1 = new TestImple();
		imple1.test1();
		imple1.test2();
		System.out.println("---");
		// 인터페이스의 다형성 : 
		// - 구현된 클래스의 객체를 인터페이스 타입의 참조 변수에 저장 가능
		Test1 imple2 = new TestImple();
		imple2.test1();
		((Test2)imple2).test2(); // 인터페이스타입으로 바꿈
		// 변수를 Test1로 선언했기 때문에 Test2의 메소드는 사용 불가
		// Test2의 메소드를 사용하기 위해서는 강제 형 변환(casting)을 해야함
		
	} //end main()
	
} //end InterfaceMain03
