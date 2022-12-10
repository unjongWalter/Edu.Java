package edu.java.inherit09;

import edu.java.inherit10.Test3;

public class InheritMain09 {

	public static void main(String[] args) {
		Test1 t1 = new Test1();
//		t1.a = 1; // private : 자기 자신 클래스만
		t1.b = 2; // package : 같은 패키지
		t1.c = 3; // protected : 같은 패키지 상속받는 클래스
		t1.d = 4; // public : 어디든
		
		System.out.println("--");
		Test2 t2 = new Test2();
		t2.display();
		System.out.println("====");
		
		Test3 t3 = new Test3();
		t3.c = 30;
		t3.d = 40;
		t3.display();
				
	} //end main()

} //end InheritMain09
