package edu.java.contact06;

import java.util.ArrayList;

// 연락처 등록, 전체검색, 상세검색, 수정, 삭제
public interface ContactDAO {// implements 필요해???
	// 연락처 등록
	public abstract int insert(ContactVO vo); // int로 insert하여 Con~에 vo로 쓰겠다.
	// 리턴타입 int : 데이터를 저장하고 저장에 대한 성공 여부를 돌려받기 위해서
	//				int로 지정. 0과 1을 DB서버에서 리턴함
	// insert : 등록 기능 의미,
	// 매개변수 ContactVO : 연락처 정보 받아 저장하기에, 데이터 클래스 VO 형태로 매개변수 지정
	 					
	// 연락처 전체 리스트 검색
	public abstract ArrayList<ContactVO> select();
	
	// 연락처 정보 인덱스 검색
	public abstract ContactVO select(int contactId); // index의 역할이 DB에서 contactId랑 동일.
	
	// 연락처 정보 인덱스 수정
	public abstract int update(ContactVO vo); // index인 contactId의 역할이 설계구조에서 기본 장착...으로 불필요
	
	// 연락처 정보 인덱스 삭제
	public abstract int delete(int contactId);
		
}//end ContactDAO
