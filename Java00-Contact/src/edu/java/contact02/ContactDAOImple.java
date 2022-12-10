package edu.java.contact02;

public class ContactDAOImple implements ContactDAO {
	// 싱글 패턴을 사용하여 인스턴스를 생성, ContactDAO.java의 추상 메소드들을 오버라이딩해서
	// 실제 기능 메소드들을 구현
	
	// 1. private static 자기자신 타입 멤버변수 선언
	private static ContactDAOImple instance = null;

	// 2. private 기본 생성자
	private ContactDAOImple() {}

	// 3. public static method ~ instance를 return하는 method
	public static ContactDAOImple getInstance() {
		if (instance == null) {
			instance = new ContactDAOImple();
		}
		return instance;
	} //end ContactDAOImple get

	// 배열 저장 카운트 같은것 ㄱㄱ
	private final int MAX = 100; // 최대 갯수 제한 -> 단점보완필요
	private ContactVO[] list = new ContactVO[MAX]; // 연락처 저장할 배열
	private int count; // 배열에 저장할 데이터 갯수, private로 막아뒀어...

	public int getCount() { // count를 MemberMain에서 사용하기위해 뚫자
		return count;
	}

	@Override
	public int insert(ContactVO vo) {
		list[count] = vo;
		count++;
		return 1;
	}

	@Override
	public ContactVO[] select() {
		return list;
	}

	@Override
	public ContactVO select(int index) {
		// TODO Auto-generated method stub
		return list[index];
	}

	@Override
	public int update(int index, ContactVO vo) {
		list[index].setName(vo.getName());
		list[index].setPhone(vo.getPhone());
		list[index].setEmail(vo.getEmail());
		return 1;
	}

} //end ContactDAOImple
