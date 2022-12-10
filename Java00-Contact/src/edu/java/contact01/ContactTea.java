package edu.java.contact01;

import java.util.Scanner;

public class ContactTea {
	
	public static final int MAXT = 100; // 연락처 최대 저장 개수 ->imple로 감
	public static ContactT[] contactListT = new ContactT[MAXT]; // 7. 유일한 contactListT가 되는 것.
	// 초기에 ContactT[]는 null이다. main 외 동네북을 따로 만들자. contactListT를 메인 위로
	public static int countT = 0; // 초기값 0, 배열에 데이터를 저장하면 증가하는 count
	public static Scanner sc = new Scanner(System.in);
		
	// 16. switch 문에 들어갈 놈 생성 -> 인터페이스로 뺴버림
	public static final int MENU_QUITT = 0; // 종료
	public static final int MENU_INSERTT = 1; // 등록
	public static final int MENU_SEARCHALLT = 2; // 전체검색
	public static final int MENU_SEARCHT = 3; // 상세검색
	public static final int MENU_WRITET = 4; // 수정
	
	public static void main(String[] args) {
				
		System.out.println("연락처 프로그램 실행"); //8
		
		boolean run = true; // 9
		
		while(run)	{ // 10 while문에서 작성하는것부터 하고, 함수화 따로 빼기
			// 반복문에서 길어지면 ㅈㅈ
			
		//	System.out.println("------------------- 메 뉴 -----------------------");
		//	System.out.println("1. 등록 | 2. 전체검색 | 3. 상세검색 | 4. 수정 | 5. 종료");
		//	System.out.println("------------------------------------------------");
		//	System.out.println("각 번호별 입력해주세요.> (예시 : 1)");
			showMainMenuT(); // 12.
			int choiceT = sc.nextInt(); // 13. 값 선택 받기
			sc.nextLine(); // 14. 엔터버퍼 치우기 중요해... 중요해 ㅠㅠ
			
			// 15. 선택된 번호에 따라 각 기능 수행
			// 16. case 숫자 -> final int로 교체
			switch (choiceT) {
			case MENU_INSERTT: // 등록
				insertContact(); // 17. 메소드로 따로 뺴고 실행시키게 넣자
				break;
			case MENU_SEARCHALLT: // 전체검색
				searchContact();
				break;				
			case MENU_SEARCHT: // 검색
				individualContact();	
				break;	
			case MENU_WRITET: // 수정
				modifyContact();
				break;
			case MENU_QUITT:// 종료우선 = 간단하니꼐
				run = false;
				System.out.println("끈다");
				break;
				
			default: // 간단하니께 우선 작살낸다
				System.out.println("잘 생각해봐라 ...");
				
				break;
			} //end switch
			
		} //end while
		
		sc.close();
	} //end main()

	private static void individualContact() { // 23. 상세검색
		System.out.println();
		System.out.println("상세검색 메뉴입니다. 인덱스 값 중에서 입력해주세요.(0~100)");
		int index = sc.nextInt();
		sc.nextLine();
		// 해당 범위 넘어서면 에러나기에, 지정해줌
		if(index >= 0 && index < countT) {
			System.out.println(contactListT[index].toString());
		} else {
			System.out.println("연락처가 해당인덱스에 없나이다.");
		}
				
	} //end modifyContact

	private static void modifyContact() { // 22. 수정난이도. 배열 count 범위 유의
		System.out.println("------------------");
		System.out.println("수정할 연락처의 인덱스를 입력해보세요. (0~100)");
		int index = sc.nextInt(); 
		System.out.println(contactListT[index].toString());
		// 해당 범위 넘어서면 에러나기에 지정해줌
		if(index >= 0 && index < countT) {
			System.out.println("이름>"); // 23.
			String name = sc.nextLine();

			System.out.println("연락처>");
			String phone = sc.nextLine();

			System.out.println("이메일>");
			String email = sc.nextLine();	
			
			contactListT[index].setName(name); // 24.
			contactListT[index].setPhone(phone);
			contactListT[index].setEmail(email);
			System.out.println("수정이 완료되었습니다. 초기메뉴로 이동합니다.");
			
		} else {
			System.out.println("연락처가 해당인덱스에 없나이다.");
		}
		
	} //end individualContact

	private static void searchContact() { // 21.
		System.out.println("연락처 개수 : " + countT);
		for (int i = 0; i < countT; i++) {
			System.out.println("No." + i);
			System.out.println(contactListT[i].toString()); //toString 활용
		//	contactListT[i].displayInfo();
			System.out.println();
			System.out.println("전체검색이 완료되었습니다. 초기메뉴로 이동합니다.");
		
		}
		
	} //end searchContact

	private static void insertContact() { //18.
		// contactListT 배열에 Contact 인스턴스를 저장				
		System.out.println("연락처 등록 메뉴입니다.");
		System.out.println("------------------");
		
		System.out.println("이름을 입력해주세요>");
		String name = sc.nextLine();

		System.out.println("전화번호를 입력해주세요>");
		String phone = sc.nextLine();

		System.out.println("이메일을 입력해주세요>");
		String email = sc.nextLine();
		
		// Contact 인스턴스 생성. 이름번호멜 배열로 넣기 전 묶자. // 20.
		ContactT c = new ContactT(name, phone, email);
				
		// 배열로 저장하자 // 19. 글로 작성좀해봐
		
		contactListT[countT] = c; // countT 반에 데이터 저장
		countT++; // 등록 수행시 마다 1씩 증가
		System.out.println("등록된 연락처 개수 : " + countT);
		System.out.println("등록이 완료되었습니다. 초기메뉴로 이동합니다.");
		
		
	}// end insertContact()

	// 메뉴 UI를 보여주는 함수 메소드
	public static void showMainMenuT() { // 11. 
		System.out.println("------------------- 메 뉴 -----------------------");
		System.out.println("1. 등록 | 2. 전체검색 | 3. 상세검색 | 4. 수정 | 0. 종료");
		System.out.println("------------------------------------------------");
		System.out.println("각 번호별 입력해주세요.> (예시 : 1)");
	}	
	
} //end ContactMain01
