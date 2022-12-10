package edu.java.access10;

public class AccessMain10 {

	public static void main(String[] args) {
		// PublicToilet 클래스의 인스턴스 생성
		PublicToilet p1 = PublicToilet.getInstance();
		p1.setLocation("캠핑장");
		System.out.println(p1); // 주소값
		System.out.println(p1.getLocation()); // 입력값
		
		System.out.println();
		PublicToilet p2 = PublicToilet.getInstance();
		System.out.println(p2); // p1동일
		System.out.println(p2.getLocation());
		
		System.out.println("===");
		
		p2.setLocation("공연장?"); //p2에 입력해도 both of that 둘다 변해부려... 
		System.out.println(p1.getLocation());
		System.out.println(p2.getLocation());
		
	} //end main()

} //end AcceccMain10
