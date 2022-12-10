package edu.java.date03;

import java.util.Calendar;

public class DateMain03 {

	public static void main(String[] args) {
		// Calendar : 추상 클래스
		// |_ GregorianCalendar : Calendar의 자식 클래스
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);

		// 날짜, 시간 정보 추출		
		int year = cal.get(Calendar.YEAR);
		System.out.println("year : " + year);
		
		int month = cal.get(Calendar.MONTH) + 1;
		System.out.println("month : " + month); // Month : 1월(0) ~ 12월(11)
		
		int day = cal.get(Calendar.DAY_OF_MONTH);
		System.out.println("day : " + day); // Day : 1 ~ 31일
		
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		System.out.println("hour : " + hour);
		// Hour : 12시간 단위, Hour_of_day : 24시간 단위
		
		int minute = cal.get(Calendar.MINUTE);
		System.out.println("minute : " + minute);
		
		int second = cal.get(Calendar.SECOND);
		System.out.println("second : " + second);
				
		String dateString = String.format("%d/%d/%d %d:%d:%d", 
				+ year, month, day, hour, minute, second);
		System.out.println(dateString);
		
	} //end main()

} //end DateMain03
