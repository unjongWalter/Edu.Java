package edu.java.access10;

//싱글톤 디자인 패턴(singleton design pattern)
//- 클래스의 인스턴스를 오직 하나만 생설할 수 있도록 작성하는 설계 기법
//1. 클래스 자신 타입의 private static 변수를 선언
//2. 생성자는 private으로 선언
//3. public static 메소드를 제공해서 인스턴스를 생성할 수 있도록 설계
//처음 생성한 인스턴스를 변경이 불가능(주소값이 같음)

public class PublicToilet {
	// 누구나 사용하는 공간 instance = null 상태로 존재, 그러나 instance는 private이기에 PublicToilet에서만 사용이 된다.
	// main() 메소드에서 인스턴스를 생성하려고 했지만, PublicToilet의 기본 생성자가 private로 선언되었기에 접근 불가하다.
	// -> new로 생성이 불가하다. -> public static PublicToilet getInstance()로 인스턴스 생성 가능하도록 싱글토톤 패턴.
	// getInstance()는 인스턴스가 없으면 새로 만들고, 있으면 기존 인스턴스를 사용하도록 구현되어 있다.
	
	private String location; // 변수생성
	
	//1. 클래스 자신 타입의 private static 변수를 선언	
	private static PublicToilet instance = null;
	
	//2. 생성자는 private으로 선언
	private PublicToilet() {}
	
	//3. public static 메소드를 제공해서 인스턴스를 생성할 수 있도록 설계
	public static PublicToilet getInstance() {
		if(instance == null) {
			instance = new PublicToilet();
		}
		return instance;
	}

	// 게터세터 생성
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
} //end PublicToilet
