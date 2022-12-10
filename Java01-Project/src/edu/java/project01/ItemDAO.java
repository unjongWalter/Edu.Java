package edu.java.project01;

import java.util.ArrayList;

// 메인에서 입력받은 DB->저장소에 넘겨주기 위한 메소드인터페이스
public interface ItemDAO {
	// 기능 구현 역할

	// 아이템 등록
	public abstract int insert(ItemVO vo);
	// 아이템 검색
	public abstract ArrayList<ItemVO> select();
	// 아이템 수정
	public abstract int update(ItemVO vo);
	// 아이템 삭제
	public abstract int delete(int itemId);

}// end itemDAO
