package edu.java.collection02;

import java.util.ArrayList;

class Student{
	// 멤버 ~
	private int stuNo;
	private String name;
	
	public Student() {}
	
	public Student(int stuNo, String name) {
		
		this.stuNo = stuNo;
		this.name = name;
	}
	public int getStuNo() {
		return stuNo;
	}
	public void setStuNo(int stuNo) {
		this.stuNo = stuNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		
		return "Student = stuNo : " + stuNo + ", name : " + name;
	}		
}

public class ListMain02 { // 연락처 업글 힌트

	public static void main(String[] args) {
		Student[] list1 = new Student[3];
		
		// Student 타입을 저장할 수 있는 ArrayList 인스턴스 생성
		ArrayList<Student> list2 = new ArrayList<>();
		
		Student stu1 = new Student(1, "kim"); // index 0
		list2.add(stu1); // index 0
		list2.add(new Student(2, "park")); // index 1, 바로 이렇게 사용 가능
		
		for(int i = 0; i < list2.size(); i++) {
			System.out.println(list2.get(i));
		}

	} //end main()

} //end ListMain02
