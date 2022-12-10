package edu.java.array08;

public class ArrayMain08 {

	public static void main(String[] args) {
		
		System.out.println("2차원 배열");
		
		// 2차원 배열 : 1 차원 배열을 원소로 갖는 배열
		int[] korean = {10, 20, 30}; // 1차원 배열
		int[] english = {40, 50, 60}; // 1차원 배열
		
		int[][] scores = { // [] 안에 i, [] 안에 j
				korean,
				english
		}; // 2 x 3인 2차원 배열 : i는 층, j는 호 ==> 2층 3호
		// 엑셀로 층, 호에 각각 넣어가며 해봐도 됨
		
		System.out.println(scores[1][1]); // 1층 1호 or i = 1, j = 1
		System.out.println(scores[0][2]); // 0층 2호 or i = 0, j = 2
		System.out.println("층의 길이(개수) :" + scores.length);
		System.out.println("0층의 호의 길이(개수) :" + scores[0].length);
		
		// 2차원 배열의 모든 요소 출력
		
	//	int n = 1; // ==check
		for(int i = 0; i < scores.length; i++) { // 층만큼 반복
			for(int j = 0; j < scores[i].length; j++) { // 호만큼 반복, 각 층의 길이
				System.out.print(scores[i][j] + " "); // check mate
	//			System.out.print((n * 10) + " ");  // ==check
	//			n++;  // ==check
			}
			System.out.println();
		}
		int[][] a = new int[3][4]; // 3 x 4 생성 배열
		// 배열이 생성되면서 특정 주소값을 갖는다.
		// 주소값은 컴퓨터 메모리에 저장되는 위치를 의미		
		System.out.println(a);		
	} // end main()

} // end ArrayMain08
