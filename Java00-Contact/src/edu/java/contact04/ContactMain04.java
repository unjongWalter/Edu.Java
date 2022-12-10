package edu.java.contact04;

import java.util.ArrayList;

import java.util.Scanner;

public class ContactMain04 {

	// 사용자가 보는 인터페이스로 구성 UI적 요소

	private static Scanner sc = new Scanner(System.in);
	private static ContactDAO dao = ContactDAOImple.getInstance();

	public static void main(String[] args) {
		System.out.println("           연락처 프로그램 ver.0.0004   ");
		//dao = ContactDAOImple.getInstance(); // 다형성, 싱글톤 인스턴스 생성
		boolean run = true;
		while (run) {
			showMainMenu(); // 시작과 동시에 보여라
			int choice = sc.nextInt();
			sc.nextLine(); // 버퍼키 제거용
			
			switch (choice) {
			case Menu.INSERT:
				insertMember(); // 이름짓고 자동완성으로 맹글어내기
				break;
			case Menu.SEARCH_ALL:
				selectAll();
				break;
			case Menu.SELECT_BY_INDEX:
				selectByIndex();
				break;
			case Menu.UPDATE:
				updateMember();
				break;
			case Menu.DELETE: // 추가
				deleteMember();
				break;
			case Menu.QUIT:
				run = false;
				System.out.println("종료우~");
				break;
			default:
				System.out.println("think again.");
				break;
			}
		}
	} // end main
	
	// 등록, 업데이트 모두 저장
	private static void deleteMember() { // 삭제, 추가내용
		System.out.println();
		System.out.println("삭제할 연락처의 index?");
		int index = sc.nextInt();
		sc.nextLine();
	//	int count = dao.select().size(); // 추가
		int size = ((ContactDAOImple) dao).getListSize();
		if (index >= 0 && index < size) { // 이거 다시봐라... 
			int result = dao.delete(index); // 이해해놔라...
			if (result == 1) {
				System.out.println("삭제 완료우~ 초기메뉴로 이동~");
			}
			// System.out.println("");
		} else {
			System.out.println("존재하지않는 인덱스~ 처음부터 다시시도~");
		}
	} // end deleteMember()

	private static void updateMember() {

		System.out.println("수정할 연락처의 index?");
		int index = sc.nextInt();
		sc.nextLine();

		ArrayList<ContactVO> list = dao.select(); // 다시봐라...

	//	int count = dao.select().size();
		int size = ((ContactDAOImple) dao).getListSize();
		// int count = ((ContactDAOImple) dao).getCount();

		if (index >= 0 && index < size) {

			System.out.println("name?");
			String name = sc.nextLine();

			System.out.println("phone?");
			String phone = sc.nextLine();

			System.out.println("email?");
			String email = sc.nextLine();

			ContactVO vo = new ContactVO(name, phone, email); // vo만들어주지 뭐

			int result = dao.update(index, vo); // dao.update 입력해보니 null로 비어있더라

			if (result == 1) {
				System.out.println("수정 완료우~ 초기메뉴로 이동~"); // 위치맞나???
			} // 이거 위치맞아???			

		} else {

			System.out.println("존재하지않는 인덱스~ 처음부터 다시시도~");

		}

	} // end updateMember()

	private static void selectByIndex() {

		System.out.println();

		System.out.println("index no.?");

		int index = sc.nextInt();

		sc.nextLine();

		ArrayList<ContactVO> list = dao.select();
		int size = ((ContactDAOImple) dao).getListSize();
		// int count = dao.select().size();

		// int count = ((ContactDAOImple) dao).getCount(); // 객체지향 이해해

		if (index >= 0 && index < size) {

			ContactVO vo = dao.select(index);

			System.out.println(vo);

			System.out.println("상세검색 완료우~ 초기메뉴로 이동~");

		} else {

			System.out.println("존재하지않는 인덱스~ 처음부터 다시시도~");

		}

	} // end selectByIndex()

	private static void selectAll() {

	//	int count = dao.select().size(); // 필요???
		int size = ((ContactDAOImple) dao).getListSize(); // 별로래 택배포장 벗겨서 제대로사용하는것
		ArrayList<ContactVO> list = dao.select(); // 변경
		for (int i = 0; i < size; i++) {
			System.out.println("index no. [" + i + "]");
			System.out.println(list.get(i)); // 변경
			System.out.println("전체검색 완료우~ 초기메뉴로 이동~");
		}

	} // end selectAll()

	private static void insertMember() {

		System.out.println("name?");
		String name = sc.nextLine();
		System.out.println("phone?");
		String phone = sc.nextLine();
		System.out.println("email?");
		String email = sc.nextLine();

		// Main -> ContactVO로 포장해서 -> ContactDAO 보내기 준비하자

		ContactVO vo = new ContactVO(name, phone, email);

		int result = dao.insert(vo); // DAO에서 옮
		
		int size = ((ContactDAOImple) dao).getListSize();
		
		ArrayList<ContactVO> list = dao.select(); // 추가 변경

	//	int count = dao.select().size(); // 추가 변경

		if (result == 1) {

			System.out.println("size = " + size); // 필수아님

			System.out.println("등록성공~ 초기메뉴로 이동~");

		}

	} // end insertMember()

	private static void showMainMenu() { // UI 요소

		System.out.println("-----------------------------------------------------------");

		System.out.println("1. 등록 | 2. 전체검색 | 3. 인덱스검색 | 4. 수정 | 5. 삭제 | 0. 종료");

		System.out.println("-----------------------------------------------------------");

		System.out.println("what's your choice?(0~5)");

	} // end showMainMenu()

} // end MemberMain
