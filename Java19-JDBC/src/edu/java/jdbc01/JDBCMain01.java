package edu.java.jdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.OracleDriver;

// 폴더 lib 맹글고~ 파일 6.jar 빌드 패스로 보내삐라
// JDBC : Java DataBase Connection
// 0. 데이터베이스 라이브러리를 프로젝트에 추가
// 		1) 프로젝트에 lib 폴더를 생성
//		2) C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib (11g xe 기준)
//			폴더에 있는 ojdbc6.jar 파일을 프로젝트의 lib 폴더에 복사
//		3) 복사한 jar 파일(라이브러리)을 build path에 추가
//		(마우스 오른쪽 클릭 -> Build Path -> Add to Build Path)
// 1. DB와 연동하기 위해 필요한 상수들을 정의
// 2. JDBC 드라이버를 메모리에 로드
// 3. DB와 Connection(연결)을 맺음
// 4. Connection 객체를 사용하여 Statement 객체를 생성
// 5. SQL 문장을 생성
// 6. Statement 객체를 사용하여 SQL 문장을 실행 (DB 서버로 SQL 문장을 전송)
// 7. DB 서버가 보내준 결과를 확인/처리

public class JDBCMain01 {
	// 1. DB에 사용할 상수들, insert update delete 같음
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; // 접속할 오라클 DB 경로
	public static final String USER = "scott";
	public static final String PASSWORD = "tiger";

	public static final String TABLE_NAME = "EX_CONTACT";
	public static final String COL_CONTACT_ID = "CONTACT_ID";
	public static final String COL_NAME = "NAME";
	public static final String COL_PHONE = "PHONE";
	public static final String COL_EMAIL = "EMAIL";

	public static void main(String[] args) {
		System.out.println("JDBC 1 - insert");

		Connection conn = null; // 객체그릇 초기화 맹글기
		Statement stmt = null; // ctrl space sql로 고고, 나중에 prepared만!

		try {
			// 2. Oracle JDBC 드라이버를 메모리에 로드
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			// 3. DB와 Connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB연결성공");

			// 4. Connection 객체를 사용하여 Statement 객체를 생성
			stmt = conn.createStatement();

			// 5. SQL 문장 작성? 작성하고자하는 QUERY...
			// INSERT INTO EX_CONTACT
			// VALUES(CONTACT_SEQ.nextval, 'mok', '010-1111-2222', 'test@test.com');
			String sql_insert = "INSERT INTO " + TABLE_NAME // INTO 뒤 띄워쓰기 주의
			// " VALUES" 앞 띄워쓰기 주의!!!
					+ " VALUES (CONTACT_SEQ.nextval, 'mok', '010-1111-2222', 'test@test.com')";
			System.out.println(sql_insert); // 로그찍기

			// 6. SQL 문장 실행(DB 서버로 SQL 전송)
			int result = stmt.executeUpdate(sql_insert);

			// 7. DB 서버가 보낸 결과 확인/처리
			System.out.println(result + "행이 삽입됩니다.");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}// end main()

}// end JDBCMain01
