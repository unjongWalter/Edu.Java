package edu.java.project01;

import java.util.ArrayList;

public interface VendorDAO {
	// 기능 구현
	// 등록
	public abstract int insert(VendorVO vo);
	// 검색
	public abstract ArrayList<VendorVO> select();
	// 수정
	public abstract int update(VendorVO vo);
	// 삭제
	public abstract int delete(int vendorId);
}//end VendorDAO
