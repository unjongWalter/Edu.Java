package edu.java.lambda01;

class AdderImple implements Adder{

	@Override // 빨갱이 자동변환 ㄱ
	public double add(double x, double y) {		
		return x + y;
	}	
}

public class LambdaMain01 {

	public static void main(String[] args) {
		System.out.println("[1] 인터페이스를 구현하는 클래스 사용");
		AdderImple adder1 = new AdderImple();
		double result = adder1.add(2.0, 4.0);
		System.out.println("result = " + result);
		
		System.out.println("[2] 다형성 사용");
		Adder adder2 = new AdderImple();
		result = adder2.add(1.1, 2.2);
		System.out.println("result = " + result);
		
		System.out.println("[3] 익명 클래스 사용"); //functional- 구현되어 자동 override
		Adder adder3 = new Adder() {			
			@Override
			public double add(double x, double y) {				
				return x + y;
			}
		};	
		result = adder3.add(3.3, 1.1);
		System.out.println("result = " + result);
		
		System.out.println("[4] 람다 표현식 사용"); // 3번 == 4번
		Adder adder4 = (x, y) -> x + y;
		result = adder4.add(1.1, 2.2);
		System.out.println("result = " + result);			
	}

}//end LambdaMain01
