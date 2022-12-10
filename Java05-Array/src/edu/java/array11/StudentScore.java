package edu.java.array11;

import java.util.Scanner;

public class StudentScore {

	public static void main(String[] args) {
		System.out.println("<학생 점수 관리 프로그램>");
		// 1. 학생수 | 2. 점수입력 | 3. 점수리스트 | 4. 분석 | 5. 종료
		// 선택> 1
		// 학생수 입력해 > 10
		// 학생수 : 10

		// 변수 명명 규칙
		// 1. 첫 글자는 문자 or '$', '_'로 시작, 숫자는 불가(필수)
		// 2. 영어 대소문자가 구분(필수)
		// 3. 첫 문자는 영어 소문자 시작, 다른 단어가 붙을 때는 첫 문자를 대문자로 추가(관례) studentScore
		// 4. 문자 수의 제한은 없다.
		// 5. 자바 예약어는 불가(필수)
		// ㄴ boolean, byte, char, private, public, new, true, if 등

		// 5명의 학생 등록
		// 0 : 100, 1 : 90, 2 : 70, 3 : 80, 4 : 90
		// 각 점수 저장할 공간 : int 배열
		int stuNo = 0; // 학생 수 담을 그릇 초기화
		Scanner sc = new Scanner(System.in);
		int[] stuScores = null; // 학생 점수를 저장할 배열을 한계가 없도록 비워두자.
		boolean run = true; // 무한 루프 while에 run 돌리기

		while (run) {
			System.out.println("----------------------------------------------------");
			System.out.println("1. 학생 수 | 2. 점수입력 | 3. 점수리스트 | 4. 분석 | 5. 종료");
			System.out.println("----------------------------------------------------");
			System.out.println("선택>");

			int selectNo = sc.nextInt();
			switch (selectNo) {
			case 1: // 학생 수 입력
				System.out.println("학생 수 입력해봐."); // 친절한 프로그램 만들기
				stuNo = sc.nextInt(); // 학생 수 담을 그릇에 스캐너 숫자 받기
				stuScores = new int[stuNo]; // 인덱스에 위엣놈 받기
				System.out.println("입력된 학생 수 : " + stuNo); // 친절한 프로그램 만들기
				break;
			case 2: // 각 학생의 점수 입력
				if(stuScores == null) { // 순차적으로 안하면 오류나는 것 방지 팁!!!
					System.out.println("학생 수 입력부터 해라??!"); // 순차적으로 안하면 오류나는 것 방지 팁!!!
					break; // 밑에 실행안하게 break;를 걸기 // 순차적으로 안하면 오류나는 것 방지 팁!!!
				}
				System.out.println("점수 입력해봐.");
				for(int i = 0; i < stuScores.length; i++) {
					System.out.println(i + "번 학생의 점수 입력>");
					stuScores[i] = sc.nextInt();
				// 만약 case1이 선행되지 않고(stuScores = new int[stuNo];) case가 입력되면 " 1번부터 하고온나."라고 출력,
				// case2가 실행 안되도록 설정
				}
				break;
			case 3: // 정수 리스트 출력
				if(stuScores == null) { // 순차적으로 안하면 오류나는 것 방지 팁!!!
					System.out.println("학생 수 입력부터 해라??!"); // 순차적으로 안하면 오류나는 것 방지 팁!!!
					break; // 밑에 실행안하게 break;를 걸기 // 순차적으로 안하면 오류나는 것 방지 팁!!!
				}
				for(int i = 0; i < stuScores.length; i++) {
				System.out.println(i+ "번 학생 점수 : "+ stuScores[i]);
				}
				break;
			case 4: // 합계 평균 출력
				if(stuScores == null) { // 순차적으로 안하면 오류나는 것 방지 팁!!!
					System.out.println("학생 수 입력부터 해라??!"); // 순차적으로 안하면 오류나는 것 방지 팁!!!
					break; // 밑에 실행안하게 break;를 걸기 // 순차적으로 안하면 오류나는 것 방지 팁!!!
				}				
				// 시간 내서 입력해봐	
				break;
			case 5:
				System.out.println("종료할게."); // 1. 쉬운 것 : 디폴트 종료값 걸기
				run = false;
				break;
			default:
				System.out.println("기회 다시 줄게, 잘 생각해봐라.");
				break;
			}
		}

	} // end main()

} // end StudentScore
