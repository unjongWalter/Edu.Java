package edu.java.homework;

import java.io.Serializable;

public class Student implements Serializable { // 파일저장시키기영
	private String name;
	private int math;
	private int eng;

	public Student() {}

	public Student(String name, int math, int eng) {
		super();
		this.name = name;
		this.math = math;
		this.eng = eng;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", math=" + math + ", eng=" + eng + "]";
	}

	public void displayInfo() {
		System.out.println("name : " + name);
		System.out.println("math : " + math);
		System.out.println("eng : " + eng);

	}

}
