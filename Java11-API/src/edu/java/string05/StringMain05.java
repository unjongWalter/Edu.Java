package edu.java.string05;

import java.util.Scanner;
import java.util.regex.Pattern;

public class StringMain05 {

	public static void main(String[] args) {
		System.out.println("정규표현식 연습");
		System.out.println("010/02-0000-0000 형식으로 입력해주세요.");
		Scanner sc = new Scanner(System.in);
		
		String data = sc.nextLine();
		
		String regExp = "(02|010)-\\d{3,4}-\\d{4}";
		// (02|010) : 02 or 010 으로 시작
		// - : '-' 기호 확인
		// \d{3,4} : 3 ~ 4자리 숫자
		// \d{4} : : 4자리 숫자
		
		boolean result = Pattern.matches(regExp, data);
		if(result) {
			System.out.println("정상번호네요");
		} else {
			System.out.println("비정상번호네요");
		}
		
		data = sc.nextLine(); 
		regExp = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
		// \w+ : 한개 이상의 알파벳 또는 숫자
		// @ : @가 존재하는지
		// \w+ : 한 개 이상의 알파벳 또는 숫자
		// \. .가 존재하는지
		// \w+ : 한개 이상의 알파벳 또는 숫자
		// (\.\w+)? : \.\w+가 없거나 한 번 더 올 수 있음
		result = Pattern.matches(regExp, data);
		if(result) {
			System.out.println("정상");
		} else {
			System.out.println("비정상");
		}
				
		// 이메일 공통점 기준 패턴화
		// 예) test@naver.com wwrt@test.ac.kr
		// 골뱅이 전까지 문자열 나열, 마침표 전까지 문자열 나열, 마침표 후에 문자열 나열
		// 마침표 문자열 나열이 들어갈 수도, 아닐수도 있다.
		
	} //end  main()

} //end StringMain05

