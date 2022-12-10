package edu.java.array02;

public class ArrayMain02 {

	public static void main(String[] args) {
		System.out.println("배열의 선언, 초기화, 출력");		
		// int형 정수 10개를 저장할 수 있는 배열 선언
		// 인덱스 0칸에 있는 변수는 1이다. 위치개념과 변수개념 숙지
		int[] array = new int[20];
		
		// 배열의 길이 출력
		System.out.println("배열의 길이 : " + array.length); // 길이를 숫자로 한정하면 큰1나		
		// 배열의 인덱스 : 0 ~ (length - 1) == 9		
		// for문을 사용하여 배열에 1 ~ 10까지의 값을 '저장'
		for(int i = 0; i < array.length; i++) { // i = 인덱스 0칸에 있는 것 나타내기
			array[i] = i + 1; // 인덱스 0 ~ 9칸에, 변수 1 ~ 10까지 저장하는 코드
		}		
		// for문을 사용하여 배열의 모든 값 '출력' <오름차순 출력>
		 for(int i = 0; i < array.length; i++) {
			System.out.println(array[i]);			
		}			
		// for문을 사용하여 배열의 값을 10, 9, 8, 7, ... 1로 <내림차순 출력>
		for(int i = array.length-1; i >= 0; i--) { // 9를 표기 x, array.length-1로 안전하게 표기
			System.out.println(array[i]); // 기준점을 인덱스 9칸에 있는 10을 먼저 출력하게 하자			
		}		
		// for문을 사용하여 배열의 모든 값(원소)들을 더하기, <오름차순>과 <내림차순> 모두 활용가능
		int sum = 0; // sum 그릇에 0초기화 후
		for(int i = 0; i < array.length; i++) {
			sum = sum + array[i]; // sum += array[i];		// if array[i%==0]	
		}
		System.out.println("sum = " + sum);
				
	} //end main()

} //end ArrayMain02
