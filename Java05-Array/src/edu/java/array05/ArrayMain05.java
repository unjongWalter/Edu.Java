package edu.java.array05;

public class ArrayMain05 {

	public static void main(String[] args) {
		System.out.println("배열 연습1");

		// char 26개를 저장할 수 있는 배열 선언
		char[] alphas = new char[26];

		alphas[0] = 'a' + 0; // alphas는 캐릭터 배열로 선언됨
		// for문 사용하여 'a' ~ 'z'까지 저장
		alphas[1] = 'a' + 1;
		alphas[2] = 'a' + 2;
		for(int i = 0; i < alphas.length; i++) { // i = 인덱스 0칸에 있는 것 나타내기
			alphas[i] = (char) ('a' + i);
		}
		for(char ch : alphas) {
			System.out.print(ch + " ");
		}
		System.out.println("===");
		
		for(char ch = 'a'; ch <='z'; ch++) {
			alphas[ch - 'a'] = ch;
		}
		for(char ch : alphas) {
			System.out.print(ch + " ");
		}
	} // end main()

} // end ArrayMain05
