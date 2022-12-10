package edu.java.date01;

import java.util.Date;

public class DateMain01 {

	public static void main(String[] args) {
		// 시스템의 현재 시간 정보
		Date date = new Date(); // java util
		System.out.println(date);
		System.out.println(date.getTime());
		// 1970년 1월 1일 0시~ 기준(0)베이스로 삼아서
		// milli-second(1/1000)마다 1씩 증가시킨 값
		
		System.out.println();
		Date date2 = new Date(0L); // 0 literal 기준 시간으로 초기화
		System.out.println(date2);
		Date date3 = new Date(1000L); // 기준 시간 + 1초
		System.out.println(date3);
				
	} //end main()

} //end DateMain01
