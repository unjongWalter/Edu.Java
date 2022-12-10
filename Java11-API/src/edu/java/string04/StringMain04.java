package edu.java.string04;

// String 클래스 : immutable 클래스(내용이 바뀌지 않는 클래스)
// StringBuffer, StringBuilder : mutable 클래스(내용을 바꿀 수 있는 클래스)

// StringBuffer : Java 1.0 버전부터 사용된 클래스
// - 추가/삭제 속도가 느림
// - Thread-safe : 쓰레드에 안전한 클래스
// - 멀티쓰레드 환경에서 사용하기 적합

// StringBuilder : Java 5.0 버전부터 사용된 클래스
// - 추가/삭제 속도가 빠름
// - Thread-unsafe : 쓰레드에 안전하지 않은 클래스
// - 싱글쓰레드 환경에서 사용하기 적합
// 그 외 모든 기능이 동일(동일한 기능의 메소드들을 가지고 있음)

public class StringMain04 {
// 문자연결할 때는 buffer + append를 쓰자!
	public static void main(String[] args) {
		// StringBuffer, StringBuilder 클래스
		StringBuffer buffer = new StringBuffer("abc");
//		StringBuffer buff = "abc"; // compile error
		
		System.out.println(buffer);
		System.out.println(System.identityHashCode(buffer));
		System.out.println(buffer.hashCode());
		// hashcode가 동일하면 같은 객체(주소값)이다.
		// - 새로운 주소를 할당받지 않으므로 메모리를 절약할 수 있음
		
		System.out.println("--------");
		// append() : 문자열을 덧붙이는 메소드
		buffer.append("def").append("ghi");
		System.out.println(buffer);
		System.out.println(System.identityHashCode(buffer));
		System.out.println(buffer.hashCode());
		
		System.out.println("------");
		String str = "abc";
		System.out.println(str); // abc
		System.out.println(System.identityHashCode(str));
		System.out.println(str.hashCode());
		
		System.out.println("---");
		str = str + "def";
		System.out.println(str);
		System.out.println(System.identityHashCode(str));
		System.out.println(str.hashCode());
		// String 리터럴은 문자열 연결 시 새로운 주소로 변경됨.
		// 그만큼 메모리를 차지하게 되므로 특정 상황(문자열 연결)에서는 비효율적임.
		// 다만, 읽기용으로 사용하면, StringBuffer, StringBuilder보다 효율적임.						
	}
}
