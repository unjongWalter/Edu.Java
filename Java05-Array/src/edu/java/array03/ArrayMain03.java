package edu.java.array03;

import java.util.Scanner;

public class ArrayMain03 {

	public static void main(String[] args) {
		System.out.println("배열 연습");
		// n개의 점수를 정수로 입력받고, 배열의 각 인덱스에 저장
		// 예시 
		// scores[0] = sc.nextInt();, scores[1] = sc.nextInt();, scores[2] = sc.nextInt();
		// 1. 점수 출력
		// 2. 점수 합 출력
		// 3. 점수의 평균 출력
		// 4. 점수의 최대값 출력
		// 5. 점수의 최소값 출력
		
		Scanner sc = new Scanner(System.in);
		// ctrl shift o : 자동 import 단축키, eclipse로 가능함
		// int [] scores = new int[3]; 3개를 만들어야겠다 
		System.out.println("입력받을 점수 개수>");
		int n = sc.nextInt();
		int[] scores = new int[n];
		
		for(int i = 0; i < scores.length; i++) {
			System.out.println(i + "번째 점수 입력>"); // 사용자 편의 입각
			scores[i] = sc.nextInt();
		}		
		// for문을 사용하여, 입력받은 모든 점수 출력
		for(int i = 0; i < scores.length; i++) {
			System.out.println(i +"번째 점수 :"+ scores[i]); // 1번 스텝			
		}
		// 배열에 저장된 모든 점수의 합 출력
		int sum = 0; // sum 초기화
		for(int i = 0; i < scores.length; i++) {
			sum += scores[i]; // == sum = sum + scores[i];
		}
			System.out.println("sum = " + sum);
		
		// 평균 출력하기(소숫점까지)
		double avg = (double) sum / scores.length; // 형변환 우측에 해야 소숫점 나타남	
		System.out.println("평균 = " + avg);
		
		// 점수 중 최대값 출력 : 삥 뜯기 예시처럼  max를 0부터 시작하여 하나하나 검열
		int max = Integer.MIN_VALUE; // int 범위 중에 최소값 저장 개념 정립, 삥듣는자가 돈이 없어서 젤 많은애 뜯어감
		for(int i = 0; i < scores.length; i++) {
			if(scores[i] > max) { // 배열에 저장된 값이 max보다 큰 경우
				max = scores[i]; // 맥스만큼 크면 갖고온나, 삥뜯 성립				
			}
		}
		System.out.println("최대값 = " + max);
		
		// 점수 중 최소값 출력
		int min = Integer.MAX_VALUE; // int 범위 중에 최대값 저장 개념 정립, 삥뜯는자가 돈이 많은데도 젤 없는애 뜯어감
		for(int i = 0; i < scores.length; i++) {
			if(scores[i] < min) { //배열에 저장된 값이 min보다 작은 경우
				min = scores[i];
			}
			
		}
		System.out.println("최소값 = " + min);
		
	} //end main()

} //end ArrayMain03
