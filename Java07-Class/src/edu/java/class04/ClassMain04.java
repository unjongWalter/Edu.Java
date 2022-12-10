package edu.java.class04;

public class ClassMain04 {

	public static void main(String[] args) {
		// 점수Scores부터 작성 후 학생Student로 끌고오는게 편리함
		
		// Scores 클래스 인스턴스 생성 : 변수명 scores1
		Scores scores1 = new Scores(50, 60, 70);
		
		// scores1의 모든 점수 출력
		scores1.printScores(); // 간단하게 전체 출력
		System.out.println("총점 : " + scores1.calcTotal());
		System.out.println("평균 : " + scores1.calcAverage());
		
		// 매개변수가 있는 생성자를 사용하여 Student 클래스의 인스턴스 생성
		// 변수명 stu1 : 인지값으로	자유롭게
		
		Student stu1 = new Student(2, "a", scores1);
		// == Student stu1 = new Student(2, "a", new Scores(4, 5, 9)); // 3단 논법 유사, 새로운 값 입력 가능
		stu1.displayStudentInfo();
		
		System.out.println("=========");
		Student stu2 = new Student(222, "k", scores1);
		
		// 총점만 출력 (stu2의 scores의 calc에 있는 총점만)
		System.out.println("총점 : " + stu2.scores.calcTotal());
						
		// stu1의 학생 정보 출력
			
	} //end main()

} //end ClassMain04
