package edu.java.exception06;

public class ExceptionMain06 {

	public static void main(String[] args) {
		// 하나의 try 구문에서 여러개 catch를 사용 방법2 
		// try {
		// 		정상 상활일 때 사용할 코드;
		// } catch (Ex1 | Ex2 | Ex3 | ... e) {
		//		예외 상황 때 실행할 코드;
		// } catch (Exception e) {...}

		try {
			System.out.println("try starts");
			int result = 123/0;
			int[] array = new int[10];
			array[10] =10;
			System.out.println("try ends");
			
		} catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			System.out.println("Exception : " + e.toString());
						
		} catch (Exception e) {
			System.out.println("Exception : " + e.toString());
		}
				
	}//end main()

}//end ExceptionMain06
