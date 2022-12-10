package edu.java.class01;

// 클래스(class)
// -만들고자 하는 대상의 상태(속성) 정보들을  "멤버 변수(필드)"로 선언하고,
// 대상이 가져야 할 기능들을 "메소드"로 정의하는,
// 새로이 만드는 "데이터 타입"
public class BasicTv {
	// TV가 가져야 할 상태(속성, 성질) => 멤버 변수(필드, 프로퍼티)
	boolean powerOn; // TV의 전원 상태(true : on, false : off)
	int channel = 1; // TV의 채널 정보. 1으로 초기화
	int volume; // TV의 소리 정보. 0으로 초기화 // int volume = 0;
	
	// TV가 가져야 할 기능 => 메소드
	public void turnOnOff() { // 토글기능. powerOn = false; // turnOnOff();// 함수호출
	// 만약 powerOn == false ㄴ powerOn = true;
	// 만약 powerOn == true ㄴ powerOn = false;
		if(powerOn == true) { // 만약 티비가 켜져있으면, ((if(powerOn)만 사용도 가능))
			powerOn = false;
			System.out.println("TV가 꺼졌");
		} else { // 만약 티비가 꺼져있으면
			powerOn = true;
			System.out.println("TV가 켜짐");
		}		
	} //end turnOnOff()
	
	// 채널 증가 기능 메소드
	public void channelUp() {
		// 해당 메소드를 호출하면 channel 변수가 1씩 증가하고
		// 1, 2, 3, 4, 5, 1, 2, ~ ... 로 순환구조이다.
		// channel이 5인 상태에서 메소드를 호출하면 channel = 1로 초기화된다.
		// 아래코드를 작성하시오.						
		if(channel == 5) { 
			channel = 1;		
		} else { 
			channel++;			
		}		
		// channel++;	
		// if(channel == 6) { 
		// channel = 1;
		// }
		System.out.println("channel up :" + channel);
	} //end channelUp()		
	
	// 채널 감소 기능 메소드
	public void channelDown() {
		channel--;
		if(channel == 0 ) {
			channel = 5;
		}
		System.out.println("channel Down " + channel);
		
	} //end channelDown()
	
	// 소리 증가 기능 메소드(최대 4)
	public void volumeUp() {
		if(volume < 4) { // volume <= 4를 하면 값이 틀림.
			volume++;		
		}	
		System.out.println("volume up " + volume);	
		
	} //end VolumeUp()
		
	// 소리 감소 기능 메소드 (최소 0)
	public void volumeDown() {
		if(volume > 0) { // volume <= 4를 하면 값이 틀림.
			volume--;
	}
		System.out.println("volume Down " + volume);	
	
	} //end VolumeDown()
	
	public void displayInfo() {
		System.out.println("--- TV 현재 상태 ---");
		System.out.println("전원 : " + powerOn);
		System.out.println("채널 : " + channel);
		System.out.println("볼륨 : " + volume);
		
	}// end displayInfo()
		
} //end BasicTv
