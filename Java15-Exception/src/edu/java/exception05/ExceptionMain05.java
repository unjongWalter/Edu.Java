package edu.java.exception05;

public class ExceptionMain05 {

	public static void main(String[] args) {
		System.out.println("multiple exceptional messages");
		// 하나의 try-catch 구문에서 여러개의 catch를 사용하는 방법 1
		try { // 예외가 발생하면 바로 catch로 넘어감.
			int x = 12345;
			int y = 0;
			int result = x / y;
			System.out.println("result = " + result);
			
			int[] array =new int[10];
			array[11] = 10;
			System.out.println("array[11] = " + array[11]);
			
			String name = null;
			System.out.println("name's length : " + name.length());
			// 최상위 Exception은 가장 마지막에 사용. 처음 사용하면 나머지 병풍만든다
		} catch (ArithmeticException e) { // e변수에 예외의 상태정보 저장
			System.out.println("산술연산 예외 : " + e.toString());
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("배열인덱스 예외 : " + e.toString());
		} catch(NullPointerException e ) {
			System.out.println("NullPointer 예외 " + e.toString());
		}
		System.out.println("the end");
		
		// 하나의 try 구문에서 여러개 catch를 사용 시
		// 자식 클래스 Exception을 먼저 catch 구문에서 사용하고
		// 가장 마지막에 최상위 부모 클래스인 Exception을 사용하자
		
	} //end main()

}//end ExceptionMain05
