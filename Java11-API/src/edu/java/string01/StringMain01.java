package edu.java.string01;

// API(Application Programming Interface)
// - 프로그램 언어나 운영 체제가 제공하는 기능을 사용할 수 있게 만든 인터페이스
public class StringMain01 {

	public static void main(String[] args) {
		String str1 = "hey"; // 문자열 literal 상수 : 기본타입
		System.out.println(str1);
		
		String str2 = new String("hey"); // 참조타입, 인스턴스 생성
		System.out.println(str2);
				
		if(str1 == str2) {
			System.out.println("같은 참조");			
		} else {
			System.out.println("다른 참조");
		} // str1 ==/ str2. 다르구나!
		
		// String을 저장하는 참조변수에는 문자열이 있는 주소값이 저장됨
		// 비교연산자(==, !=) 단순 주소값만 비교
		// -> 실제 문자열과 내용이 같더라도 '주소값이 다르다'라는 결과를 줄 수 있음
		// 따라서, 문자열의 내용이 같은지 다른지 비교할 때는, equals()메소드를 사용해야 함
		
		if(str1.equals(str2)) {
			System.out.println("내용이 같네");
		} else {
			System.out.println("내용이 다르네");
		} // str1 ==/ str2. 다르구나!
		
		String str3 = "abc";
		String str4 = "abc";
		if(str3 == str4) {
			System.out.println("같은 참조");
		} else {
			System.out.println("다른 참조");
		}
		
	} //end main()

} //end StringMain01
