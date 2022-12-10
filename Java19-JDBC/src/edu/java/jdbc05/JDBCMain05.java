package edu.java.jdbc05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import oracle.jdbc.OracleDriver;

public class JDBCMain05 {
	// 1. DB에 사용할 상수들, insert update delete 같음
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; // 접속할 오라클 DB 경로
	public static final String USER = "scott";
	public static final String PASSWORD = "tiger";

	public static final String TABLE_NAME = "EX_CONTACT";
	public static final String COL_CONTACT_ID = "CONTACT_ID";
	public static final String COL_NAME = "NAME";
	public static final String COL_PHONE = "PHONE";
	public static final String COL_EMAIL = "EMAIL";

	// 데이터 등록??? 쿼리로 노략질
	// INSERT INTO EX_CONTACT
	// VALUES(CONTACT_SEQ.nextval, ?, ?, ?); // 현재 미정, 나중에 넣을게 ~ ?
	public static final String SQL_INSERT = "INSERT INTO " + TABLE_NAME // INTO 뒤 띄워쓰기 주의
	// " VALUES" 앞 띄워쓰기 주의!!!
			+ " VALUES (CONTACT_SEQ.nextval, ?, ?, ?)";

	public static void main(String[] args) {
		System.out.println("JDBC 5 - 입력받은 데이터 -> 쿼리 & insert");

		Connection conn = null; // 물음표~랑 Prepared 단짝
		PreparedStatement pstmt = null; // ctrl space sql로 고고, statement < prepared~ 상위버전으로생각
		// PreparedStatement : 매개변수를 갖고 있는 SQL 문장 활용하는 클래스
		// Statement와 상속관계..;;; ?보이면 걍 써라...;;;
		try {
			// 2. Oracle JDBC 드라이버를 메모리에 로드
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			// 3. DB와 Connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB연결성공");

			// 4. Connection 객체를 사용하여 PreparedStatement 객체를 생성
			pstmt = conn.prepareStatement(SQL_INSERT);

			Scanner sc = new Scanner(System.in);

			System.out.println("name?");
			String name = sc.nextLine();

			System.out.println("phone?");
			String phone = sc.nextLine();

			System.out.println("email?");
			String email = sc.nextLine();

			// 5. SQL 문장 완성 - SQL_INSERT 쿼리의 ?를 채워주는 코드
			pstmt.setString(1, name); // 물음표 갯수만큼 채워라 제발
			pstmt.setString(2, phone);// 순서, 갯수 조심해라 제발
			pstmt.setString(3, email);
			// SQL 쿼리의 ? 순서와 parameterIndex의 값은 동일하게 지정
			// 예시) ?가 첫 번째이면 parameterIndex = 1

			// setInt() : DB의 Number 타입
			// setString() : DB의 varchar, varchar2 타입
			// setFloat() : DB의 Float 타입
			// setDate() : DB의 Date타입
//				System.out.println(SQL_INSERT);

			// 6. SQL 문장 실행(DB 서버로 SQL 전송)
			int result = pstmt.executeUpdate();// 안에 뭐 쳐넣지마라

			// 7. DB 서버가 보낸 결과 확인/처리
			System.out.println(result + "행이 삽입됩니다.");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}// end main()
}
