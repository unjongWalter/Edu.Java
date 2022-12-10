package edu.java.contact02;

import java.util.Scanner;

public class ContactMain02 {
	// 사용자가 보는 인터페이스로 구성 UI적 요소
	private static Scanner sc = new Scanner(System.in);
	private static ContactDAO dao;

	public static void main(String[] args) {
		System.out.println("           연락처 프로그램 ver.0.00002   ");

		dao = ContactDAOImple.getInstance(); // 다형성, 싱글톤 인스턴스 생성

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

	private static void updateMember() {
		System.out.println("수정할 연락처의 index?");
		int index = sc.nextInt();
		sc.nextLine();

		int count = ((ContactDAOImple) dao).getCount();
		if (index >= 0 && index < count) {
			System.out.println("name?");
			String name = sc.nextLine();

			System.out.println("phone?");
			String phone = sc.nextLine();

			System.out.println("email?");
			String email = sc.nextLine();

			ContactVO vo = new ContactVO(name, phone, email); // vo만들어주지 뭐
			int result = dao.update(index, vo); // dao.update 입력해보니 null로 비어있더라
			if (result == 1) {
			}
			System.out.println("수정 완료우~ 초기메뉴로 이동~");
		} else {
			System.out.println("존재하지않는 인덱스~ 처음부터 다시시도~");
		}

	} // end updateMember()

	private static void selectByIndex() {
		System.out.println();
		System.out.println("index no.?");
		int index = sc.nextInt();
		sc.nextLine();

		int count = ((ContactDAOImple) dao).getCount(); // 객체지향 이해해
		if (index >= 0 && index < count) {
			ContactVO vo = dao.select(index);
			System.out.println(vo);
			System.out.println("상세검색 완료우~ 초기메뉴로 이동~");
		} else {
			System.out.println("존재하지않는 인덱스~ 처음부터 다시시도~");
		}

	} // end selectByIndex()

	private static void selectAll() {
		ContactVO[] list = dao.select();

		int count = ((ContactDAOImple) dao).getCount(); // 택배포장 벗겨서 제대로사용하는것
		for (int i = 0; i < count; i++) {
			System.out.println("index no. [" + i + "]");
			System.out.println(list[i]);
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
		int result = dao.insert(vo);
		int count = ((ContactDAOImple) dao).getCount();
		if (result == 1) {
			System.out.println("count = " + count);
			System.out.println("등록성공~ 초기메뉴로 이동~");
		}

	} // end insertMember()

	private static void showMainMenu() {
		System.out.println("-------------------------------------------------");
		System.out.println("1. 등록 | 2. 전체검색 | 3. 인덱스검색 | 4. 수정 | 0. 종료");
		System.out.println("-------------------------------------------------");
		System.out.println("what's your choice?(0~4)");

	} // end showMainMenu()
} // end MemberMain
