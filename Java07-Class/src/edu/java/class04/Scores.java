package edu.java.class04;

public class Scores {
	// 멤버 변수(필드, 프로퍼티)
	int korean;
	int english;
	int math;
	
	// 생성자
	public Scores() {}
	// 마우스 오른쪽, 소스, 제러레이터 컨스트럭트 유징 필드, 제너레이트버튼
	public Scores(int korean, int english, int math) {
		this.korean = korean;
		this.english = english;
		this.math = math;
	}
	
	// 세 과목의 총점을 리턴하는 메소드
	public int calcTotal() {
		return korean + english + math;
	}
	
	// 세 과목의 평균을 리턴하는 메소드
	public double calcAverage() {
		return (double) calcTotal() / 3;
	}
	
	// 세 과목의 각 점수를 출력하는 메소드	
	public void printScores() {
		System.out.println("국어 : " + korean);
		System.out.println("영어 : " + english);
		System.out.println("수학 : " + math);			
	}
	
}
