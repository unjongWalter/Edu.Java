package edu.java.homework;

public class HomeWork03 {

	public static void main(String[] args) {
		// 4. 도형 출력
		// *              i = 0 j = 0
		// **             i = 1 j = 0, 1
		// ***            i = 2 j = 0, 1, 2
		// ****           i = 3 j = 0, 1, 2 ,3
		// *****          i = 4 j = 0, 1, 2, 3, 4 
		// *****
		//  ****
		//   ***
		//    **
		//     *
		// key : i <= j
		
		// 삼각형우선 그리고, 역삼각형 도전
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (i >= j) {
					System.out.print("*");
				}
			}
			System.out.println();
		}

		// i = 0
		// i = 1 j = 0
		// i = 2 j = 0, 1
		// i = 3 j = 0, 1, 2
		// i = 4 j = 0, 1, 2 ,3
		// i = 5 j = 0, 1, 2, 3, 4
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (i > j) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();

		}

	} // end triangle()

} // end HomeWork
