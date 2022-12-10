package edu.java.oper03;
// 증감 연산자, 반복문에 활용, 단순 1증가만 가능, 독립사용이 대부분
// - 변수의 값을 1 증가 또는 감소할 떄 사용하는 연산자
// - 변수의 앞(prefix)과 뒤(suffix)에 사용
// - ++, --
public class OperatorMain03 {

	public static void main(String[] args) {
		System.out.println("증감 연산자++, --)");
		
		int num1 = 100;
		num1++; // == num1 += 1;
		System.out.println("num1 = " + num1);
		
		int num2 = 100;
		++num2;
		System.out.println("num2 = " + num2);

		int num3 = 100;
		int result = 5 + ++num3; // bad code, 100+1을 먼저 실행하고 +5 실행
		System.out.println("num3 = " + num3);
		System.out.println("result = " + result);
		
		int num4 = 100;
		result = num4++ + 5; // bad code, 100+5가 먼저 실행 후 result에 저장
		// num4를 1증가시켜서 num4 = 101이 저장됨
				
		System.out.println("num4 = " + num4);
		System.out.println("result = " + result);
		
		// 증감 연산자는 변수 앞 또는 변수 뒤에 사용할 수 있음
		// 증감 연산자가 단독으로 사용되는 경우는 앞과 뒤가 모두 동일한 결과
		//		x++; 와 ++x는 동일하 효과(단독사용 시에만), ''''''''x++만 사용 예정''''''
		// 증감 연산자가 다른 연산자와 함께 사용 시
		// 앞은 다른 연산자보다 먼저 계산하고, 뒤는 다른 연산자보다 나중 계산함
		
		int x = 10;
		result = x++ + 5 + ++x;
		System.out.println("x = " + x);
		System.out.println("result = " + result);
		
		// 계산 순서
		// 1. x++ + 5
		//			(1) x + 5 ==> 10 + 5 ==> 15
		//			(2) x 증가 ==> x = 11
		// 2. 15 + ++x
		//			(1) x 증가 ==> x = 12
		//			(2) 15 + 12 = 27
		// 3. result = 27
		
	} //end main()

} //end OperatorMain03
