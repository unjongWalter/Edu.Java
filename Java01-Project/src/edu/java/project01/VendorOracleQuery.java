package edu.java.project01;

public interface VendorOracleQuery {

	// DB연결 쿼리 우선
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; // 접속할 오라클 DB 경로
	public static final String USER = "scott";
	public static final String PASSWORD = "tiger";
		
	// 테이블명, 벤더아이디 이름 전화번호 이메일
	public static final String TABLE_NAME = "VENDOR";
	
	public static final String COL_VENDOR_ID = "VENDOR_ID"; // pk seq number
	public static final String COL_VENDOR_NAME = "VENDOR_NAME";
	public static final String COL_VENDOR_PHONE = "VENDOR_PHONE";
	public static final String COL_VENDOR_EMAIL = "VENDOR_EMAIL";

	// 등록, 전체검색, 수정, 삭제
	public static final String SQL_INSERT = "INSERT INTO " + TABLE_NAME + " VALUES(VENDOR_SEQ.nextval, ?, ?, ?)";
	public static final String SQL_SELECT = "SELECT * FROM " + TABLE_NAME + " ORDER BY " + COL_VENDOR_ID;
	public static final String SQL_UPDATE = "UPDATE " + TABLE_NAME + " SET " + 
						COL_VENDOR_NAME + " = ?, " +
						COL_VENDOR_PHONE + " = ?, " +
						COL_VENDOR_EMAIL + " = ? "
						+ " WHERE " + COL_VENDOR_ID + " = ? ";
	public static final String SQL_DELETE = "DELETE " + TABLE_NAME + " WHERE " + COL_VENDOR_ID + " = ? "; 
		
}//end VendorOracleQuery
