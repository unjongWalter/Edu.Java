package edu.java.project01;

public interface ItemOracleQuery {
	
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; // 접속할 오라클 DB 경로
	public static final String USER = "scott";
	public static final String PASSWORD = "tiger";

	public static final String TABLE_NAME = "ITEM";
	
	public static final String COL_ITEM_ID = "ITEM_ID"; // pk number돌림
	public static final String COL_ITEM_N = "ITEM_NAME"; // 나머지 전부 varchar2
	public static final String COL_ITEM_PURCHASE_P = "ITEM_PURCHASE_P"; // PURCHASE PRICE
	public static final String COL_ITEM_SALES_P = "ITEM_SALES_P"; // SALES PRICE
	public static final String COL_ITEM_PURCHASE_C = "ITEM_PURCHASE_C"; // PURCHASE COUNT
	public static final String COL_ITEM_SALES_C = "ITEM_SALES_C"; // SALES COUNT
	public static final String COL_ITEM_V = "VENDOR_NAME"; // VENDOR NAME
	public static final String COL_ITEM_D = "ITEM_D"; // DATE
		
	// 등록, 전체검색, 수정, 삭제
	public static final String SQL_INSERT = "INSERT INTO " + TABLE_NAME + " VALUES(ITEM_SEQ.nextval, ?, ?, ?, ?, ?, ?, SYSDATE)";
	public static final String SQL_SELECT = "SELECT * FROM " + TABLE_NAME + " ORDER BY " + COL_ITEM_ID;
	public static final String SQL_UPDATE = "UPDATE " + TABLE_NAME + " SET " +  COL_ITEM_N +
			" = ?, " + COL_ITEM_PURCHASE_P + " = ?, " + COL_ITEM_SALES_P + " = ?, " + COL_ITEM_PURCHASE_C + " = ?, " + 
			COL_ITEM_SALES_C + " = ?, " + COL_ITEM_V + " = ? " + " WHERE " + COL_ITEM_ID + " = ?";
	public static final String SQL_DELETE = "DELETE " + TABLE_NAME + " WHERE " + COL_ITEM_ID + " = ? "; 
		
}//end ItemOracleQuery
