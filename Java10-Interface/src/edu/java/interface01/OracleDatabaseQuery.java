package edu.java.interface01;

public class OracleDatabaseQuery implements DataBaseQuery{

	@Override
	public int insert(String id, String pw) {
		System.out.println("오라클 DB 연결");
		System.out.println("SQL 문장 작성/실행");
		System.out.println("SQL 실행 결과 처리");		
		return 1;
	} //end insert()

} //end OracleDatabaseQuery
