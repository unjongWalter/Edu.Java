package edu.java.for05;

public class ForMain05 {

	public static void main(String[] args) {
		System.out.println("for문 연습");		
		
		// 등차수열의 합 구하기
		// 1 + 2 + 3 + ... + 10
		// sum = 0 ~ sum = 0 + 1 ~ sum = 0 + 1 + 2 ~ sum = 0 + 1 + 2 + 3 => sum + n번쨰 횟수 (sum = sum+10)
		int sum1 = 0; 
		for(int i = 1; i <= 10; i++) {
			sum1 = sum1 + i;
		}
		System.out.println(sum1);
			
		// 1 ~ 100까지의 숫자 중 짝수들의 합을 출력
		// 2, 4, 6, 8, ... + 100
		int sum2 = 0; 
		for(int i = 1; i <= 100; i++) {
			if (i % 2 == 0) { // 짝수인 경우만 연산
				sum2 = sum2 + i;				
			}			
		}		
		System.out.println(sum2);			

	} //end main()

} //end ForMain05
