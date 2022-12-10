package edu.java.method02;

public class MethodMain02 {
	// (생성할 정의 우선) 기능1 : 두 개의 정수를 매개변수로 전달받고, 두 정수의 합을 리턴.
	// 메소드 이름 : add
	// 리턴타입 : int(coz 정수)
	// 매개변수 : int x , int y	
	public static int add(int x, int y) {
		return x + y;
		// int sum = x + y;
		// return sum;
	} // end add()
	
	// 기능2 : 두 개의 정수를 매개변수로 전달받고, 두 정수의 차를 리턴
	// 메소드 이름 : sub
	// 리턴타입 : int
	// 매개변수 : int x, int y
	public static int sub(int x, int y) {
		return x - y;
	} // end sub
	
	// 기능3 : 두 개의 실수를 매개변수로 전달받고, 두 실수의 곱을 리턴
	// 메소드 이름 : mul
	// 리턴 : double	
	// 매개변수 : double x, double y
	public static double mul(double x, double y) {
		return x * y;
	} // end mul
	
	// 기능4 : 두 개의 실수를 매개변수로 전달받고, x를 y로 나눈 값을 리턴
	// 메소드 이름 : div
	// 리턴 : double	
	// 매개변수 : double x, double y	
	public static double div(double x, double y) {
		return x / y;
	} // end div
			
	public static void main(String[] args) {
		System.out.println("메소드 연습");

		int result = add(10, 20); // 기능1
		System.out.println("result = " + result);
		
		result = sub(10, 20);// 기능2
		System.out.println("result2 = " + result);
		
		double m = mul(10, 20);// 기능3
		System.out.println("m = " + m);
		
		double d = div(10, 20);// 기능4 // 자동 형변환 가능성 염두
		System.out.println("d = " + d);
				
	} //end main()

} //end MethodMain02
