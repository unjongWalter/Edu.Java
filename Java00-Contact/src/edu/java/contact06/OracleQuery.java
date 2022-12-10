package edu.java.contact06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import oracle.jdbc.driver.OracleDriver;

// static final로 묶어둔 애들 인터페이스로 작살내자
// JDBC에서 사용될 상수들, SQL 문장들을 정의
public interface OracleQuery {

	public static final String URL =
			"jdbc:oracle:thin:@localhost:1521:xe"; // 접속할 오라클 DB 경로
	public static final String USER = "scott";	
	public static final String PASSWORD = "tiger";	
	
	public static final String TABLE_NAME = "EX_CONTACT";
	public static final String COL_CONTACT_ID = "CONTACT_ID";
	public static final String COL_NAME = "NAME";
	public static final String COL_PHONE = "PHONE";
	public static final String COL_EMAIL = "EMAIL";

	// 쿼리 검증 : 쿼리 짜고, 마우스 오른쪽에서 복사. 디벨로퍼에 확인하고
	// 커밋 , insert ex_contact where contact_id = 4;
	
	// insert, nextval 시퀀스 구조, ?는 세개만.
	public static final String SQL_INSERT =
			"INSERT INTO " + TABLE_NAME +
			" VALUES(contact_seq.nextval, ?, ?, ?)";
		
	// select all	
	public static final String SQL_SELECT =
			"SELECT * FROM " + TABLE_NAME + " ORDER BY "+ COL_CONTACT_ID; // 정렬 order by
	
	// select by index
	public static final String SQL_SELECT_BY_CONTACT_ID =
			"SELECT * FROM " + TABLE_NAME + " WHERE " + COL_CONTACT_ID + " = ?"; // where 접근해서 뭔가 한다.
	
	// update
	public static final String SQL_UPDATE =
			"UPDATE " + TABLE_NAME + " set "+
			COL_NAME + " = ?, "+
			COL_PHONE + " = ?, "+
			COL_EMAIL + " = ? "+
			"WHERE "+ COL_CONTACT_ID + " = ?"; // where 접근해서 뭔가 한다.
	
	// delete
	public static final String SQL_DELETE =
			"DELETE " + TABLE_NAME + " WHERE " + COL_CONTACT_ID + " = ?";	
		
	
}//end OracleQuery


