package edu.java.interface06;
// MemberDAO를 interface한 MemberDAOImple 클래스
// DAO(Date Access Object) :
// - 데이터의 전송을 담당 역할
public class MemberDAOImple implements MemberDAO {

	// 싱글톤 디자인 패턴 적용 시작	
	// 1. private static 자기자신 타입 멤버변수 선언
	private static MemberDAOImple instance = null;
	// 2. private 기본 생성자
	private MemberDAOImple() {}
	// 3. public static method - instance를 return하는 method
	public static MemberDAOImple getInstance() {
		if(instance == null) {
			instance = new MemberDAOImple();
		}
		return instance;
	}
	// 배열 저장 카운트 같은것 ㄱㄱ
	private final int MAX = 100; // 최대 회원수
	private MemberVO[] list = new MemberVO[MAX]; // 회원정보 저장할 배열
	private int count; // 배열에 저장할 데이터 갯수, private로 막아뒀어...
	
	public int getCount() { // count를 MemberMain에서 사용하기위해 뚫자
		return count;
	}
	
	@Override
	public int insert(MemberVO vo) { // 회원 등록
		list[count] = vo;
		count++;
		return 1; // 0 : 실패, 1 : 성공
	}

	@Override
	public MemberVO[] select() {		
		return list;
	}

	@Override
	public MemberVO select(int index) {		
		return list[index];
	}

	@Override
	public int update(int index, MemberVO vo) {
		list[index].setPw(vo.getPw());
		list[index].setEmail(vo.getEmail());
		return 0;
	}

}
