package edu.java.interface05;

// 상속 : IS-A 관계 성립 시
// - 스마트 TV는 TV이다. class SmartTv extends BasicTv {}
// 구현인터페이스 : HAS-A 관계 성립 시
// - TV는 리모콘을 가진다. class BasicTv implements RemoteController {}
public class InterfaceMain05 {

	public static void main(String[] args) {
		Tv tv = new Tv();
		tv.turunOn();
		tv.turunOff();
		
		Audio audio = new Audio();
		audio.turunOn();
		audio.turunOff();
		
		System.out.println("-1-");
		
		RemoteController rc1 = new Tv();
		rc1.turunOn();
		
		RemoteController rc2 = new Audio();
		rc2.turunOn();
		
		System.out.println("---");
		
		RemoteController[] arrRc = new RemoteController[2]; // 인스턴스 x, 배열 저장
		arrRc[0] = tv;
		arrRc[1] = audio;
				
	} //end main()

} //end InterfaceMain05
