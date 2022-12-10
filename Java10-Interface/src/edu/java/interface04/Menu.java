package edu.java.interface04;

// 인터페이스의 활용 : 상수(public static final)들만 정의하는 타입
public interface Menu {
	public static final int INSERT = 1; // main 위에 있던 걸 뺴돌림
	public static final int SELECT = 2;
	public static final int QUIT = 3;
	
	// public static final 생략 가능
	String STR_INSERT = "입력 메뉴";
	String STR_SELECT = "검색 메뉴";
	String STR_QUIT = "프로그램 종료";
	
}
