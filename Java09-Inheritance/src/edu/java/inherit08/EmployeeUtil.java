package edu.java.inherit08;

public class EmployeeUtil {
	// employee 객체를 전송하려 한다.
	// employee 객체일 수 있고, manager 객체일 수 있다.
	// 가능한 이유는 employee와 manager가 부모 자식 관계
	// -> 두 가지 타입 인스턴스가 전송되기에
	// 조건문과 instanceof를 이용하여 인스턴스 타입에 따라 다르게 처리필요.
	public void printEmpInfo(Employee emp) {
		if(emp instanceof Manager) { // 자식, 인스턴스가 Manager 타입
			Manager m = (Manager) emp; // casting
			System.out.println("이름 : 111" + m.getName());		
			System.out.println("직책 : 111" + m.getType());
		} else if (emp instanceof Employee) { // 부모, 인스턴스가 Employee 타입
			System.out.println("이름 : 222" + emp.getName());		
		} else { // 둘다 아닌경우 // 상속관계가 아니라서 실행 불가
			System.out.println("둘다 아니네요.");
		
		}				
	}	
}
