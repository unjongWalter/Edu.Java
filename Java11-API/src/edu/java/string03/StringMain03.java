package edu.java.string03;

public class StringMain03 {

	public static void main(String[] args) {
		// length() : 문자열의 길이를 리턴
		String str1 = "abc";
		String str2 = "hey";
		System.out.println(str1.length());// return 한다. 길이 3
		System.out.println(str2.length());

		System.out.println("-----");
		// equals() : 문자열의 내용을 비교
		// object 클래스의 equals() 메소드를 override함
		System.out.println(str1.equals(str2));

		System.out.println("------");
		// equalsIgnoreCase : 문자열 대소 구분없이 비교
		String str3 = "hello";
		String str4 = "Hello";
		System.out.println(str3.equals(str4)); // false
		System.out.println(str3.equalsIgnoreCase(str4)); // true

		System.out.println();
		// charAt() : 문자열 중에서 해당 인덱스의 문자 하나를 리턴
		System.out.println(str3.charAt(1)); // 인덱스는 0부터 시작

		System.out.println();
		// indexOf() : 해당 문자 또는 문자열이 처음으로 등장하는 인덱스
		//				해당 문자 또는 문자열이 없으면 -1을 리턴
		// lastIndexOf() : 문자 또는 문자열이 가장 마지막으로 등장하는 인덱스
		String str5 = "Hello, world!";
		System.out.println(str5.indexOf("l")); // l이 2번째 처음 등장
		System.out.println(str5.indexOf("-1")); // -1 출력		
		System.out.println(str5.indexOf("world")); // world를 통으로 인식, 7번째 등장
		System.out.println(str5.lastIndexOf("l")); // l이 10번째 마지막 등장

		System.out.println();
		// startsWith() : 해당 문자열로 시작하는지 아닌지 확인, https:// 같은 것 활용
		String str6 = "https://www.google.com";
		System.out.println(str6.startsWith("https://"));

		System.out.println();
		// contains() : 해당 문자열을 포함하는지 아닌지
		System.out.println(str6.contains("google"));

		System.out.println();
		// split() : 문자열을 특정 기준으로 나눠서 배열로 리턴
		String str7 = "2022-07-22";
		String[] result = str7.split("\\."); // 나눌 기준 입력
		// 특수기호(.$()[}{}?*+\\) 사용은 기호 앞 \\ 붙여주어야 함
		for (String x : result) {
			System.out.println(x);
		}

		System.out.println();
		String str8 = "C:\\Program Files\\test folder";
		result = str8.split("\\\\| "); // '\\'기준으로 나누고 + ' '기준으로 추가 나눈다.
		for (String x : result) {
			System.out.println(x);
		}

//			result = str8.split("\\\\"); // '\\'기준으로 나누고		
//			for(String x : result) {				
//			String[] r = x.split(" "); // ' '기준으로 중복 나누기
//			for(String y : r) {
//				System.out.println(y);
//			}
		System.out.println();
		String str9 = "2022-07-22 10:13:08";
		// 2022,07,22,10,13,08로 나누어지도록
		// 추가로, 1~6월이면 "상반기", 7~12월 "하반기" 출력

		if (1 > str9.charAt(7) && 6 >= str9.charAt(7)) {
			System.out.println("상반기");
		} else {
			System.out.println("하반기");
		}

		result = str9.split("-| |:");
		for (String x : result) {
			System.out.print(x + "," + " ");
		}

//		System.out.println("-------");
		// 샘 버전...?
//		result = str9.split("-| |:");
//		for (int i = 0; i < result.length; i++) {
//			System.out.println(result[i]);
//			if (i == 1) {
//				int month = Integer.parseInt(result[i]);
//				System.out.println("월 : " + month);
//				if(month >= 1 && month <= 6) {
//					System.out.println("상반기");
//				} else {
//					System.out.println("하반기");
//				}				
//			}
//		}
		
		System.out.println("---");
		// compareTo() : 해당 문자열과 비교해서 서로 다른 문자의 개수 리턴
		// compareToIhnoreCase() : 해당 문자열과 대소문자 구분없이
		// 비교 후 서로 다른 문자의 개수 리턴 // 같은 것 기준으로 왼쪽은 -, 오른쪽은 +
		String str10 = "aabc";
		String str11 = "bbc";
		System.out.println(str10.compareTo("abc"));
		System.out.println(str10.compareTo("ab"));
		System.out.println(str10.compareTo("a"));
		System.out.println(str10.compareTo("b"));
		System.out.println(str10.compareTo("c"));
		System.out.println(str10.compareTo("bc"));
		System.out.println(str10.compareTo(str11));
		System.out.println(str10.compareTo("abc"));
		
		System.out.println();
		// toUpperCase() : 문자열을 대문자로 변경
		// toLowerCase() : 문자열을 소문자로 변경
		String str12 = "Hello, Java!";
		System.out.println(str12.toUpperCase());
		System.out.println(str12.toLowerCase());
		
		System.out.println("---");
		// substring(begin, end) : begin부터 end까지 문자열을 리턴
		// begin 인덱스는 포함, end 인덱스는 미포함
		System.out.println(str12.substring(0,5)); // 0 <= index < 5
		int begin = str12.indexOf("J");
		int end = str12.length();
		System.out.println(str12.substring(begin,end));
		
		System.out.println();
		// concat() : 문자열을 이어주는 메소드
		System.out.println(str12.concat(" world!"));
		
		System.out.println();
		// replace(A, B) : A문자열을 B로 변경
		String str13 = str12.replace("Java", "C+++++");
		System.out.println(str13);		
		
	} // end main()

} // end StringMain03
