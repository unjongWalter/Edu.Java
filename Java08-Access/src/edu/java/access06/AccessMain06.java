package edu.java.access06;

import edu.java.access05.TestPublic;

public class AccessMain06 {

	public static void main(String[] args) {
		TestPublic test1 = new TestPublic();
		
//		TestPackage test2 = new TestPackage(); // 불가
		// 다른 패키지에 속한 클래스에서는 인스턴스 생성 불가능
		
	} //end main()

} //end AccessMain06
