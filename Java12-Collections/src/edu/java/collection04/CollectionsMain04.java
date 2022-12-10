package edu.java.collection04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CollectionsMain04 {

	public static void main(String[] args) {
		// <학생 정보 3명 입력받고>
		// 이름 :
		// 점수 :
		// ㄴ 수학 : 100
		// ㄴ 영어 : 80
		Scanner sc = new Scanner(System.in);
//		Student[] list1 = new Student[3];
		List<Student> list = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			System.out.println("수학 점수 입력>");
			int math = sc.nextInt();
			System.out.println("영어 점수 입력>");
			int eng = sc.nextInt();
			System.out.println("이름 입력>");
			String name = sc.next();

			Score score = new Score(math, eng); // 밑에것 묶어주기, score넣기용
			Student student = new Student(name, score);
			list.add(student); // score에 포장 + name 포장 + list에 넣기
		}

		// 데이터 출력
		for (int i = 0; i < list.size(); i++) {
			System.out.println("--- 학생 [" + i + "] 정보 ---");
			// list.get(i);
			Student student = list.get(i);
			System.out.println("name : " + student.getName());
			System.out.println("math : " + student.getScore().getMath());
			System.out.println("eng : " + student.getScore().getEng());
		}

		// 데이터 수정
		// 1번 인덱스 : 둘리, 100, 50 점으로 수정
		list.set(1, new Student("둘리", new Score(100, 50))); // 안에 안음

		// 0번 인덱스의 영어 점수만 변경/ 학생내용 읽고, 수정 -> 속한개념 숙지
		list.get(0).getScore().setEng(50); // 학생의 점수의 영어...

		// 변경된 리스트 모든 데이터 출력
		System.out.println("--- 변경 후 ---");
		for (int i = 0; i < list.size(); i++) {
			System.out.println("--- 학생 [" + i + "] 정보 ---");
			// list.get(i);
			Student student = list.get(i);
			System.out.println("name : " + student.getName());
			System.out.println("math : " + student.getScore().getMath());
			System.out.println("eng : " + student.getScore().getEng());
		}
		// 데이터 삭제 : 1번 인덱스 학생의 모든 정보 삭제
		list.remove(1);		

	}// end main()
}// end CollectionsMain04
