package edu.java.contact01;

import java.util.Scanner;

public class ContactMain01 {

	public static final int MENU_QUIT = 5; // 종료
	public static final int MENU_INSERT = 1; // 등록
	public static final int MENU_SEARCHALL = 2; // 전체검색
	public static final int MENU_SEARCH = 3; // 상세검색
	public static final int MENU_WRITE = 4; // 수정
	public static final int MAX = 100; // 연락처 최대 저장 개수

	// 연락처 저장 배열
	public static Contact[] contactList = new Contact[MAX];
	public static int count = 0; // 초기값 0, 배열에 데이터를 저장하면 증가하는 count
	public static Scanner sc = new Scanner(System.in);

	// 메인 메뉴 출력 메소드
	private static void showMainMenu() { // 한방에 해결하기용 public? private 차이
		System.out.println("------------------- 메 뉴 -----------------------");
		System.out.println("1. 등록 | 2. 전체검색 | 3. 상세검색 | 4. 수정 | 5. 종료");
		System.out.println("------------------------------------------------");
		System.out.println("각 번호별 입력해주세요.> (예시 : 1)");

	} // end showMainMenu()

	// 연락처 등록용 메소드
	public static void insertContact() {
		System.out.println("연락처 등록 메뉴입니다.");
		System.out.println("------------------");		
		
		System.out.println("이름을 입력해주세요>");
		String name = sc.nextLine();

		System.out.println("전화번호를 입력해주세요>");
		String phone = sc.nextLine();

		System.out.println("이메일을 입력해주세요>");
		String email = sc.nextLine();

		// Contact 인스턴스 생성
		Contact ct = new Contact(name, phone, email);

		// 배열로 저장하자
		contactList[count] = ct;
		count++;
		System.out.println("등록된 연락처 개수 : " + count);
		System.out.println("등록이 완료되었습니다. 초기메뉴로 이동합니다.");

	} // end insertContact()

	// 2. 전체검색용 메소드
	public static void searchContact() {
		if (count == 0) {
			System.out.println("등록된 연락처가 없습니다. 1번 메뉴부터 시작해주세요.");

		} else {
			System.out.println("----------------");
			System.out.println("전체검색 메뉴입니다.");
			
			// for 문 전체보여주기용
			for (int i = 0; i < count; i++) {
				System.out.println("No." + i);
				contactList[i].displayInfo();
				System.out.println();
				System.out.println("전체검색이 완료되었습니다. 초기메뉴로 이동합니다.");

			} // end for
		} // end if
	} // end showContact
	

	// 3. 상세검색용 메소드 // 유의 
	public static void individualContact() {
		if (count == 0) {
			System.out.println("등록된 연락처가 없습니다. 1번 메뉴부터 시작해주세요.");
		} else {
			System.out.println("------------------");
			System.out.println("상세검색 메뉴입니다. 인덱스 값 중에서 입력해주세요.(0~100)");
			int index = sc.nextInt();

			if (index < count) { // <= 에서 =을 뺴기. 인덱스 이상을 넘어서서 없는애 찾는 격
				contactList[index].displayInfo();
			System.out.println();
			System.out.println("상세검색이 완료되었습니다. 초기 메뉴로 이동합니다.");
			} else {
				System.out.println("인덱스 값 중에서 입력해주세요.(0~100)");

			} // end if

		} // end if

	} // end individualContact

// System.out.println("초기 메뉴로 이동합니다.");

	// 4. 수정용 메소드
	public static void modifyContact() {
		if (count == 0) {
			System.out.println("등록된 연락처가 없습니다. 1번 메뉴부터 시작해주세요.");
		} else {
			System.out.println("------------");
			System.out.println("수정 메뉴입니다.");
			System.out.println("현재는 총 " + count + "개의 연락처가 저장되어있습니다.");
			System.out.println("수정할 연락처의 인덱스를 입력해보세요. (0~100)");
		}

		int index = sc.nextInt();
		sc.nextLine();

		if (index < count) {
			System.out.println("----------현재 저장된 내용------------");
			contactList[index].displayInfo();
			System.out.println("---------------------------------------");
			System.out.println("수정할 이름, 연락처, 이메일 순서로 입력 해주세요.");

			// 수정은 통채로
			System.out.println("이름>");
			String name = sc.nextLine();

			System.out.println("연락처>");
			String phone = sc.nextLine();

			System.out.println("이메일>");
			String email = sc.nextLine();

			// Contact 인스턴스
			Contact ct = new Contact(name, phone, email);
			contactList[index] = ct;
			System.out.println();
			System.out.println("수정이 완료되었습니다. 초기메뉴로 이동합니다.");

		} else { // 없어도 되나??

		}

	} //end midifyContact

	// 메인 메소드
	public static void main(String[] args) {

		System.out.println("연락처 프로그램 실행");

		boolean run = true;
		// UI 지속 출력용
		while (run) {

			showMainMenu(); // run할떄부터 보여주기

			int select = sc.nextInt(); // 받아내기
			sc.nextLine(); // 버퍼키???

			switch (select) {

			case MENU_QUIT: // 5. 종료				
				System.out.println("5. 종료합니다.");
				run = false;
				break;

			case MENU_INSERT: // 1. 등록
				insertContact();
				break;

			case MENU_SEARCHALL: // 2. 전체검색
				searchContact();
				break;

			case MENU_SEARCH: // 3. 상세검색
				individualContact();
				break;

			case MENU_WRITE: // 4. 수정
				modifyContact();
				break;

			default:
				System.out.println("메뉴 1 ~ 4 중에서 고르세요.");

			} // end switch

		} // end while
		
		sc.close(); // 여기에 종료
		
	} // end main()

} // end class ContactMain
