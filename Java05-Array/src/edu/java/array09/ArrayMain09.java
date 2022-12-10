package edu.java.array09;

public class ArrayMain09 {

	public static void main(String[] args) {
		System.out.println("2차원 배열 연습");
		String[] avengers = {"아이언맨", "토르", "헐크", "캡틴아메리카"};
		String[] villain = {"타노스", "하이드라", "레드스컬"};
		String[][] characters = {
			avengers,
			villain
		};
		// 2차원은 중첩반복문 써라. for each 문 활용
		// 문자열 2차원 -> 문자열 1차원 -> 문자열 단계를 거쳐라
		for(String[] group : characters) {
			for(String name : group) {
				System.out.print(name + " ");
			}
			System.out.println();			
		}				
		
	} //end main()

} //end ArrayMain09
