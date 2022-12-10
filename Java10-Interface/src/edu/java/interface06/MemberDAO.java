package edu.java.interface06;
// tip : interface에서 public abstract만 가능
// interface DAO 함수 설계 방식
// 함수의 리턴타입 : 돌려주는 데이터 형태에 따라
// 함수의 매개변수 : 전송되는 데이터 형태에 따라
// tip : insert, update, delete 모두 int형태로 리턴 갖는다.
public interface MemberDAO {
	
//	- 회원정보 등록, MemberVO를 int형태로 insert한다
	public abstract int insert(MemberVO vo);
	
//	- 회원정보 전체검색, <검색=돌려받기>return 타입 필요하기에 배열 필수
	public abstract MemberVO[] select();
	
//	- 회원정보 상세검색, index로 select한다.
	public abstract MemberVO select(int index); // index번호를 매개로 검색
	
//	- 회원정보 상세수정, index와 vo를 주고 update한다.
	public abstract int update(int index, MemberVO vo);
	
}
// 연락처 등록은 DAO에 단순히 배열에 집어넣어, DB에 저장이 아직은 어려워.