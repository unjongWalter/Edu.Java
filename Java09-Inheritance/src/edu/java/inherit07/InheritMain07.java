package edu.java.inherit07;

class ParentClass{ // public은 하나만!
	private int x;
	public ParentClass(int x) {
		this.x = x;
		System.out.println("ParentClass(x) 생성자");
	}
	public int getx() {
		return x;
	}
	
} //end ParentClass

class ChildClass extends ParentClass{
	private int y;
	public ChildClass(int x, int y) {
		super(x);
		this.y = y;
		System.out.println("ChildClass(x, y) 생성자");		
	}	
	public int getY() {
		return y;
	}
	
} //end ChildClass

public class InheritMain07 {

	public static void main(String[] args) {		
		ParentClass class1 = new ParentClass(100);
		System.out.println("-1-");
		ParentClass class2 = new ChildClass(100, 200); // 다형성, 포인트
		System.out.println("--2--");
		
		System.out.println(class2.getx());
//		System.out.println(class2.gety()); // getY를 부모는 몰라
		// class2는 ParentClass 타입으로 선언했기 떄문에
		// ChildClass에서 정의한 getY() 메소드를 사용할 수 없음
		// 강제 형 변환(casting)을 하면, ChildClass가 가지고 있는 메소드 사용 가능
		// 포장지를 뜯는 것 : casting // 포장지 뜯기 전이라 사용 못한 것
		System.out.println("---3---");
		ChildClass c = (ChildClass) class2; // casting, 제대로 사용하기 위해 필수
		System.out.println(c.getY());
		System.out.println("----4----");
		System.out.println(((ChildClass) class2).getY());
		System.out.println("-----5-----");
		// instanceof 키워드
		// - 기본형태
		// 	 참조변수 instanceof 클래스 이름
		// - 명시한 클래스 타입의 인스턴스와 같으면 true, 아니면 false를 리턴
		// - 특정 인스턴스가 원래 어떤 클래스인지 확인할 때 사용
		System.out.println(class2 instanceof ChildClass);
		System.out.println("===6===");
		if(class2 instanceof ChildClass) { // class2가 ChildClass 객체면,
			System.out.println("x = " + class2.getx());
			System.out.println("y = " + ((ChildClass) class2).getY());
		} else {
			System.out.println("x = " + class2.getx());
		}
		
	} //end

} //end InheritMain07
