package edu.java.interface01;

import java.util.Scanner;

// 인터페이스(Interface) : 껍데기용도, 여러개 가능... (상속은 단일!)
// 1. 인터페이스의 모든 메소드는 public abstract로 선언(Java7버전까지)
// -> public abstract 수식어 생략 가능
// 2. 인터페이스의 모든 멤버 변수는 public static final로 선언
// -> public static final 수식어 생략 가능
// 3. 인터페이스를 선언할 때는 interface 키워드 사용
// 4. 인터페이스를 구현(상속)하는 클래스는 implements 키워드 사용
// 5. 클래스는 다중 상속이 불가능
// (예) class Child extends Parent1, Parent2 (x)
// 6. 인터페이스를 구현하는 개수는 제한이 없음
// (예) class Child implements Inter1, Inter2 (o)

public class InterfaceMain01 {
// 인터페이스 : 상속과 같은 능력 -> 상속은 하나만 가능, 인터페이스는 여러개 가능
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("id");
		String id = sc.next();
		System.out.println("ps");
		String pw = sc.next();
		sc.close();
		
		DataBaseQuery db = new OracleDatabaseQuery(); // 다형성 (부모 자식아닌데도...?)		
		int result = db.insert(id, pw);
		if(result > 0) {
			System.out.println("insert 성공");
		} else {
			System.out.println("insert 실패");
		}
				
	} //end

} //end InterfaceMain01
