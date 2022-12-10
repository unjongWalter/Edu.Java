package edu.java.inherit06;

// 다형성(Polymorphism)
// - 객체(인스턴스)를 여러 가지 타입으로 호출할 수 있는 것.
// - 생성된 인스턴스를 가리키는(참조하는) 참조 변수를 선언할 때
//   생성된 인스턴스의 클래스 타입으로 변수를 선언할 수 있고
//   그 부모 타입으로 변수를 선언할 수도 있는 것
// - 다형성의 장점
//   1 .배열을 사용할 떄 부모 타입으로만 선언해둔
//   그배열에는 부모/자식 타입 모두 저장 가능
//   2. 메소드를 정의할 떄 메소드의 매개변수나 리턴타입으로 부모 클래스 타입만 사용해도
//   부모/자식 타입 모두 매개변수나 리턴타입으로 사용가능

// 손흥민 extends 손정웅
// 손정웅 a = new 손정웅();, 손정웅 b = new 손정웅, 손정웅 c = 손흥민
public class InheritMain06 {

	public static void main(String[] args) {
		// Car 클래스의 인스턴스 생성
		Car car1 = new Car();
		
		// HybridCar 클래스의 인스턴스 생성
		HybridCar car2 = new HybridCar();
		
		Car car3 = new HybridCar(); // 다형성이다!
//		HybridCar car4 = new Car(); // 자식클래스에 부모클래스 객체 저장 불가!
		// Childclass 변수이름 = new ChildClass(); 가능
		// ParentClass 변수이름 = new Childclass(); 가능
		// Childclass 변수이름 = new ParentClass(); 불가능
		
		// Car 타입 배열 선언
		Car[] cars = new Car[3];
		cars[0] = car1; // car 20, 자기 자신 객체
		cars[1] = car2; // hyb 23, 자식 객체
		cars[2] = car3; // hyb 25
		
		for(Car x : cars) { // cars 배열에 있는 객체를 하나씩 저장
			x.display();
			System.out.println("-----++-----");
			
		}
		CarUtil util = new CarUtil();
		util.drive(cars);
				
	} //end main()

} //end InheritMain06
