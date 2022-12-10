package edu.java.inherit08;

public class InheritMain08 {

	public static void main(String[] args) {
		// Employee 클래스 타입의 배열 선언
		Employee[] emps = {
			new Employee("길동씨"),
			new Manager("길동씨", "과장") // 타입이 왜 다른지?부터 생각
		};

		emps[0].test(); // override로 다른 출력값 가지구나
		emps[1].test();
		System.out.println("stop");
		
		EmployeeUtil util = new EmployeeUtil();
		for(Employee e : emps) { // 각각 꺼낸다.
			util.printEmpInfo(e); // 꺼낸 걸 util에 넣는다
			System.out.println("---a---");
		}
		
	} //end main()

} //end InheritMain08
