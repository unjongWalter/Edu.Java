package edu.java.project01;

import java.util.ArrayList;

public interface JoinDAO {
	// 기능 구현 역할

	// 회원가입/등록
	public abstract int insert(JoinVO vo);
		
	// 아이디 중복확인, 로그인 매칭용 
	public abstract ArrayList<JoinVO> select();
	
	
}//end JoinDAO