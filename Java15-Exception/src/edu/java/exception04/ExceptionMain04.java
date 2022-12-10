package edu.java.exception04;

public class ExceptionMain04 {

	public static void main(String[] args) {
		// Exception : 예외 처리를 위한 클래스
		// |_ ArithmaticException
		// |_ NullPointException
		// |_ ...
		System.out.println("Exceptional messages");
		try {
			System.out.println("inner try");
			String name = null;
			System.out.println("name's length" + name.length());
			
		} catch (NullPointerException e) { // =! Arithmetic, 실행여부는 서로 다름
			System.out.println("Exceptional messages : " + e.toString());
			
		}
		System.out.println("the end");
		
	}//end main()

}//end ExceptionMain04
