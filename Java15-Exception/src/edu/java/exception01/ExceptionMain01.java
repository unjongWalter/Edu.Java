package edu.java.exception01;

// compile error : 소스코드 빌드 시 발생하는 에러
// -> 실행 파일이 만들어지지 않기 때문에 실행 불가
// 예외(Exception) : 
// -> 소스코드를 빌드할 때는 에러가 없지만
// 실행 파일을 실행할 때 발생하는 오류
// 논리적 오류 :
// -> 컴파일 에러나 실행 예외도 발생 없지만
// 논리적 문제로 원하는 실행 결과가 안나오는 경우

public class ExceptionMain01 {

	public static void main(String[] args) {
//		int 123; 컴파일 에러 변수명으로 숫자 ㄴㄴ
//		int n = 123/0; // 예외
		
		int result = findMax(20, 1);
		System.out.println(result);
	}

	public static int findMax(int x, int y) {
		if(x < y) { // 논리적 오류
			return x;			
		} else {
			return y;
		}		
	}		
} //end ExceptionMain01
