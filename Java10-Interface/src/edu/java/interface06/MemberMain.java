package edu.java.interface06;

import java.util.Scanner;
// MVC 디자인 패턴에서 View 클래스
// - UI를 담당하는 역할
public class MemberMain {
	private static Scanner sc;
//	private static Scanner sc = new Scanner(System.in);
	private static MemberDAO dao; // 싱글톤, MemberDAOImlpe 인스턴스 저장할 변수
	
	public static void main(String[] args) {
		System.out.println("관리 플그램");
		sc = new Scanner(System.in);
		dao = MemberDAOImple.getInstance(); // 다형성, 싱글톤
		
		boolean run = true;
		while (run) {
			showMainMenu();
			int choice = sc.nextInt();
			sc.nextLine(); //버퍼키 제거용
			
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
				break;					
			default:
				System.out.println("think again.");
				break;
			}						
		}
	} // end

	private static void updateMember() {
		System.out.println("회원 정보 수정");
		System.out.println("인덱스 입력");
		int index = sc.nextInt();
		sc.nextLine();
		
		System.out.println("pw?");
		String pw = sc.nextLine();
		System.out.println("email?");
		String email = sc.nextLine();
		
		MemberVO vo = new MemberVO("", pw, email);
		
		int result = dao.update(index, vo);
		if(result == 1) {
			System.out.println("수정 댔네 댔스");
		}
		
	} //end updateMember()

	private static void selectByIndex() {
		System.out.println();
		System.out.println("index no.?");
		int index = sc.nextInt();
		sc.nextLine();
		
		int count = ((MemberDAOImple)dao).getCount();
		if(index >= 0 && index < count) {
			MemberVO vo = dao.select(index);
			System.out.println(vo);
		} else {
			System.out.println("존재않는 인덱스 번호다 다시봐라");
		}
				
	} //end selectByIndex()

	private static void selectAll() {
		MemberVO[] list = dao.select();
		
		int count = ((MemberDAOImple) dao).getCount(); // 택배포장 벗겨서 제대로사용하는것
		for(int i = 0; i < count; i++) {
			System.out.println("information [" + i + "]");
			System.out.println(list[i]);
		}
		
	} //end selectAll()

	private static void insertMember() {
		System.out.println();
		System.out.println("-----infor-----");
		System.out.println("id?");
		String id = sc.nextLine();
		System.out.println("pw?");
		String pw = sc.nextLine();
		System.out.println("email?");
		String email = sc.nextLine();
			
		// Main -> MemberVO로 포장해서 -> MemberDAO 보내기 준비하자
		MemberVO vo = new MemberVO(id, pw, email);
		int result = dao.insert(vo);
		if(result == 1) {
			System.out.println("등록됐네 됐스");
		}
	//	System.out.println(result);
		
		// 인스턴스를 한번만 생성하도록 강제 = 싱글톤 패턴
} //end insertMember()

	private static void showMainMenu() {
		System.out.println("-------------------------------------------------");
		System.out.println("1. 등록 | 2. 전체검색 | 3. 상세검색 | 4. 수정 | 0. 종료");
		System.out.println("-------------------------------------------------");
		System.out.println("what's your choice?");
		
	} //end showMainMenu()

} // end MemberMain
