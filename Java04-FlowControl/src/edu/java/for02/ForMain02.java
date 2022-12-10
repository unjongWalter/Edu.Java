package edu.java.for02;

public class ForMain02 {

	public static void main(String[] args) {
		System.out.println("For 연습문");
	
		//println() : 맨 마지막 줄바꿈(\n)이 포함된 출력 함수
		//print() : 문자열을 나열하며 출력
		
		// 10 이하의 짝수만 오름차순으로 출력
		for(int x = 0; x <= 10; x+=2) { 
			System.out.print(x + " ");
		}
		System.out.println();
				
		// 2*0 2*1 2*2 2*3 2*4 2*5 위와 같은 결과, 0, 1, 2, 3, 4, 5 * 2라는 공톰점 활용 알고리즘적 사고
		for(int x = 0; x <= 5; x++) { 
			System.out.print(2 * x + " ");
		}		
		System.out.println();
		
		// 0 1 2 3 4 5 6 7 8 9 10 : if문 활용, 쌤 활용방식 추천
		for(int x = 0; x <= 10; x++) {
			if(x % 2 == 0) {
				System.out.print(x + " ");
				
			}
						
		}
						
	} //end main()

} //end ForMain02
