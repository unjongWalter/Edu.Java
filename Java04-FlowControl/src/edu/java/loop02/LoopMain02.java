package edu.java.loop02;

public class LoopMain02 {

	public static void main(String[] args) {
		System.out.println("랜덤 주사위");
		// 두 개의 주사위를 던져서 나온 값을(x, y)와 같은 형식으로 출력
		// 두 개의 주사위가 같은 숫자가 나오면 종료
		// 무한 루프 사용법
		// while(true) {
		// System.out.println("^ㅗ^"); // 무한 반복
		// }

		// for(;;) {
		// System.out.println("^ㅜ^");
		// }

		// 1 ~ 6까지 숫자 중 임의 1개 선택하게 만들기
		int count = 1;
		while (true) {
			double rX = Math.random(); // random() : 0 <= x , 1 사이의 난수 발생
			double rY = Math.random();

			int x = (int) (6 * rX + 1); // 주사위화 시키기
			int y = (int) (6 * rY + 1);
			System.out.println("x : " + x + ", " + "y : " + y);
			if (x == y) {
				System.out.println("같네");
				break;
			}
			count++;
		}
		System.out.println(count + "번 만에 썜쌤이.");
	} // end main()

} // end LoopMain02
