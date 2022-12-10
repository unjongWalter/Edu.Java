package edu.java.access04;

public class AccessMain04 { // 기억필수

	public static void main(String[] args) {
		// 객체 생성 및 데이터 저장 방식1
		Contact c1 = new Contact(0, "유재석", "000", "a@aa");
		System.out.println(c1.toString());		
		System.out.println();
		
		// 번호 변경(정보 변경)
		c1.setPhone("123-456-7890");
		System.out.println(c1.toString());
		
		// 객체 생성 및 데이터 저장 방식2
		Contact c2 = new Contact();
		c2.setNo(1);
		c2.setName("박명수");
		c2.setPhone("111");
		c2.setEmail("b@bb");
		System.out.println(c2.toString());
		
		// 3명의 연락처 정보를 배열로 묶음
		Contact[] contacts = new Contact[3]; // 여러명 진행 -> 배열
		
		// 유재석의 정보를 contacts[0]에 저장
		contacts[0]	= c1;		
		// 박명수의 정보를 contacts[1]에 저장
		contacts[1]	= c2;
		// 아이유의 정보를 contacts[2]에 저장
		contacts[2] = new Contact(2, "아이유", "222", "c@cc");
		
		for(Contact c : contacts) { // for each문
			System.out.println(c.toString());
		}
		
	} //end main()

}//end AccessMain04
