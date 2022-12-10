package edu.java.contact04;

import java.util.ArrayList;

public interface ContactDAO {
	//추상 메소드 abstract 를 사용해서 기능 메소드들을 정의
	// alt sfitf r 리네임
//	- 등록, ContactVO를 int형태로 insert한다
	public abstract int insert(ContactVO vo);
	
//	- 전체검색, <검색=돌려받기>return 타입 필요하기에 배열 필수 // 변경 추가,
	public abstract ArrayList<ContactVO> select();
	
//	- 상세검색, index로 select한다.
	public abstract ContactVO select(int index); // index번호를 매개로 검색
	
//	- 상세수정, index와 vo를 주고 update한다.
	public abstract int update(int index, ContactVO vo);
		
// 	- 연락처 정보 삭제	
	public abstract int delete(int index); // 변경 추가
	
} //end ContactDAO





