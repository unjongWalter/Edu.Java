package edu.java.homework;

public class HomeWork01 {

	public static void main(String[] args) {
		// 2. 반복문과 random 활용, 두 개 주사위로 난수 발생, 합이 5가 될때 종료
		// 
		// int count = 1;
		while (true) {
			double rX = Math.random(); // random() : 0 <= x , 1 사이의 난수 발생
			double rY = Math.random();

			int x = (int) (6 * rX + 1); // 주사위화 시키기
			int y = (int) (6 * rY + 1);
			System.out.println("x : " + x + ", " + "y : " + y);
			if (x + y == 5) {
				System.out.println("합해서 5다 종료할란다.");
				break;
			}
			// count++;
		}
		// System.out.println(count + "번 만에 종료.");

	} // end random dice()

} // end HomeWork
