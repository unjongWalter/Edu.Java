package edu.java.oper04;

// 비교 연산자
// - 두 값을 범위적으로 비교할 때 사용
// - 연산 결과로 true, false를 리턴
// - <, >, <=, >= ,== ,!=

// 논리 연산자
// - boolean 타입의 변수를 사용하여 연산
// - A && b : AND(논리곱) 연산
//			A와 B 모두 true일 때만 true, 나머지는 false
//  -A || B : OR(논리합) 연산
// 			A와 B 모두 true이면 true, A, B 모두 false일 때는 false
// - !A : NOT(논리 부정) 연산
// 			A가 true면 false, A가 false이면 true

public class OperatorMain04 {

	public static void main(String[] args) {
		System.out.println("비교 연산자");
		
		System.out.println(10 > 20); // 10이 20보다 크냐?, 20이 10보다 작냐?
		System.out.println(10 < 20); // 10이 20보다 작냐?, 20이 10보다 크냐?
		System.out.println(123 == 100); // 123이 100과 같냐?
		System.out.println(123 != 100); // 123이 100과 다르냐?
		
		System.out.println("논리 연산자");
		boolean A = true;
		boolean B = false;
		System.out.println(A && B);
		System.out.println(A || B);
		System.out.println(!B);
		
		//score 표기 때, 90점 이상이고 100점이하 이다
		System.out.println((10 > 0) && (10 < 100));
		System.out.println((10 > 0) || (10 < 100)); // 이미 앞이 true라서 뒤가 불필요해. dead code. 순서가 항상 중요해
		System.out.println((10 <= 0) || (10 <= 100));
		System.out.println(!(111<100));
		
		

	} // end Main()

} // end Operatormain04
