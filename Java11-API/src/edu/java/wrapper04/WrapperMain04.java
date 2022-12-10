package edu.java.wrapper04;

public class WrapperMain04 {

	public static void main(String[] args) {

		// 2022년 7월 22일 17:41:43, 숫자 구분하여 합을 구하라

		String str = "2022년 7월 22일 17:41:43";

		String[] result = str.split("년 |월 |일 |:");
//		String[] result = str.split("[^0-9]+");
		// 0 ~ 9 연속된 숫자만 자른다.
		int sum = 0;		
		for (String x : result) {
			System.out.println(x); // 잘되는지 항상 확인
		//	int y = Integer.parseInt(x);
		//	sum = sum + y;
			sum += Integer.parseInt(x);
		}
		System.out.println(sum);
	} // end main()

} // end WrapperMain04
