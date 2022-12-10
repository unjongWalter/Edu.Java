package edu.java.inherit06;

public class CarUtil {
	// 매개변수 생성자와 유사하긴 하긴 하지...
	public void drive(Car[] cars) { // Car 배열을 인자값으로 받아옴
		for(Car car : cars) { // == for(int i = 0; i < cars.length; i++){}
			// Car 배열에는 Car, Hybrid 타입의 인스턴스가 저장됨
			// cars[0] : Car
			// cars[1] : Hybrid
			// cars[2] : Hybrid
			car.display();			
		}
	}
}
