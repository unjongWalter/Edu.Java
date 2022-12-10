package edu.java.class01;

public class ClassMain01 {
	// alt shift r : 이름 변경
	// 프로그램의 시작점 : main()메소드
	
	public static void main(String[] args) { // 프로그램 시작시 가장먼저 읽음
		// 클래스의 "객체(인스턴스)"를 "생성"한다
		// 클레스이름 변수이름 = new 생성자();
		
		// 변수 타입으로 선언할 수 있는 형태
		// - 기본타입 변수 : byte ,char, int 등. 실제 값(리터럴 값)을 변수에 저장
		// 예) int a = 3, b = 10;
		// - 참조타입 변수 : 배열, 클래스, 인터페이스 등. 주소를 통해 객체 참조 (new를 대개 사용)
		// 예) int[] a = new BasicTv();
		
		BasicTv tv = new BasicTv();
		tv.displayInfo(); // 초기, 현재 상태 출력
		
		// * 기존 생성자를 호출하여 객체를 생성하게 되면
		// 클래스의 멤버 변수들은 기본값으로 초기화됨
		// 	숫자(int, double, ..)타입의 기본값 : 0, 0.0
		// 	boolean 타입의 기본값 : false
		// 	그 외 타입(참조 타입) : null(그릇만 있고 내용이 아직없음)
				
		tv.turnOnOff(); // power 버튼 클릭 후 (1차)
		tv.displayInfo();
		
		tv.turnOnOff(); // power 버튼 클릭 후 (2차)
		tv.displayInfo();
		
		//	BasicTv tv2 = null; // tv2라는 그릇을 초기화시켜두자
		//	tv2.displayInfo();
		// nullPointerException : 참조변수가 null 값을 가진 경우
		// 객체의 멤버변수나 메소드를 사용하면 발생하는 프로그램 오류
		
	//	tv.turnOnOff(); //boolean으로 true시작. 20줄의 true
	//	System.out.println(tv.powerOn);
	//	tv.turnOnOff(); // 18줄의 false 
	//	System.out.println(tv.powerOn);
				
		tv.channelUp(); // 2
		tv.channelUp(); // 3
		tv.channelUp(); // 4
		tv.channelUp(); // 5
		tv.channelUp(); // 1
		
		tv.channelDown();
		tv.channelDown();
		tv.channelDown();
		tv.channelDown();
		tv.channelDown();
		
		tv.volumeUp();
		tv.volumeUp();
		tv.volumeUp();
		tv.volumeUp();
		tv.volumeUp();
		
		tv.volumeDown();
		tv.volumeDown();
		tv.volumeDown();
		tv.volumeDown();
		tv.volumeDown();
						
	} //end main()

} //end ClassMain01
