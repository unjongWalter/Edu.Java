package edu.java.inner02;

public class InnerMain02 {

	public static void main(String[] args) {
		// Car 인스턴스 및 Tire 인스턴스 생성
		Car car1 = new Car("Porche 911");
		Car.Tire tire1 = car1.new Tire(20);
		tire1.dislpay();
		
		System.out.println();
		Car car2 = new Car("니로");
		Car.Tire tire2 = car2.new Tire(18);
		tire2.dislpay();
		// 인스턴스를 생성해야 나오더라~
	} //end main()

} //end InnerMain02
	