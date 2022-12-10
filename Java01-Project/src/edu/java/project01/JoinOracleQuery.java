package edu.java.project01;

public interface JoinOracleQuery {
	
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; // 접속할 오라클 DB 경로
	public static final String USER = "scott";
	public static final String PASSWORD = "tiger";
	
	public static final String TABLE_NAME = "MEMBER";
	// memberNO는 시퀀스 돌려야
	public static final String COL_MEMBER_ID = "MEMBER_ID"; // varchar2
	public static final String COL_MEMBER_PASSWORD = "MEMBER_PW";
	public static final String COL_MEMBER_NAME = "MEMBER_NAME";
	public static final String COL_MEMBER_PHONE = "MEMBER_PHONE";
	public static final String COL_MEMBER_EMAIL = "MEMBER_EMAIL";
	
	// 회원가입
	public static final String SQL_INSERT = "INSERT INTO " + TABLE_NAME +
			" VALUES(MEMBER_SEQ.nextval, ?, ?, ?, ?, ?)";
	// 아이디 중복확인, 로그인용 아이디비번 확인 2가지 기능 활용
	public static final String SQL_SELECT = "SELECT "+ COL_MEMBER_ID + ", "+ COL_MEMBER_PASSWORD + " FROM " + TABLE_NAME;
	
	
}//end JoinOracleQuery
