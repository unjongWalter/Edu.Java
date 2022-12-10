package edu.java.homework;

public class HomeWork04 {

	public static void main(String[] args) {
		// 3. 1 + (-2) + 3 + (-4) + ... + n형태로 더하고, sum이 100 이상일 때
		// n값과 sum 값 출력
		// key : loop 돌리기, 홀수는 더하고, 짝수는 뺴주기

		int sum = 0; // 1 변수 선언우선, 초기화시키자
		int n = 1;
		while (true) {
			if (n % 2 == 1) {
				sum = sum + n; // 2. 홀수일 때
			} else {
				sum = sum - n; // 3. 짝수일 때
			}
			if (sum >= 100) {
				break;
			}
			n++; // 4. 계속 증가
		}
		System.out.println("sum : " + sum + ", n = " + n);

		// while(true) { // 2 돌리자
		// if(num%2 != 0) { // 오류 발생,
		// sum += num;
		// } else {
		// sum -= num;
		// }
		// if(sum >= 100) {
		// System.out.println("n : " + num);
		// break;
		// }
		// }
		// System.out.println("sum :" + sum);

	} // end sum, n()

} // end HomeWork03
