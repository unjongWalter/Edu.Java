package edu.java.jdbc06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import oracle.jdbc.OracleDriver;

public class JDBCMain06 {
	// 1. DB에 사용할 상수들, insert update delete 같음
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; // 접속할 오라클 DB 경로
	public static final String USER = "scott";
	public static final String PASSWORD = "tiger";

	public static final String TABLE_NAME = "EX_CONTACT";
	public static final String COL_CONTACT_ID = "CONTACT_ID";
	public static final String COL_NAME = "NAME";
	public static final String COL_PHONE = "PHONE";
	public static final String COL_EMAIL = "EMAIL";

	// 데이터 수정
	// UPDATE EX_CONTACT
	// SET NAME = ?, PHONE = ?, EMAIL = ?
	// WHERE CONTACT_ID = ?
	public static final String SQL_UPDATE = 
			"UPDATE " + TABLE_NAME + " SET " +
					COL_NAME + " = ? , " +
					COL_PHONE + " = ? , " + 
					COL_EMAIL + " = ?  " + // 쉼표는 두개만~
					"WHERE " + COL_CONTACT_ID + " = ?";
		
	// 데이터 삭제, CONTACT_ID 한놈갖고 삭제해삔다
	// DELETE EX_CONTACT WHERE CONTACT_ID = ?
	public static final String SQL_DELETE = 
			"DELETE " + TABLE_NAME + " WHERE " + COL_CONTACT_ID + " = ?";
	
	public static void main(String[] args) {
		System.out.println("JDBC 6 - 입력받은 데이터 -> 쿼리 & update, delete");

		Connection conn = null;
		PreparedStatement pstmt = null; // ctrl space sql로 고고
		// PreparedStatement : 매겨변수를 갖고 있는 SQL 문장 활용하는 클래스
		// Statement와 상속관계..;;; ?보이면 걍 써라...;;;
		try {
			// 2. Oracle JDBC 드라이버를 메모리에 로드
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			// 3. DB와 Connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB연결성공");

			// 4. Connection 객체를 사용하여 PreparedStatement 객체를 생성
			pstmt = conn.prepareStatement(SQL_UPDATE);

			Scanner sc = new Scanner(System.in);

			System.out.println("name?");
			String name = sc.nextLine();

			System.out.println("phone?");
			String phone = sc.nextLine();

			System.out.println("email?");
			String email = sc.nextLine();
			
			System.out.println("index???");
			int contactId = sc.nextInt();

			// 5. SQL 문장 완성 - SQL_INSERT 쿼리의 ?를 채워주는 코드
			pstmt.setString(1, name); // 물음표 갯수만큼 채워라 제발
			pstmt.setString(2, phone);
			pstmt.setString(3, email);
			pstmt.setInt(4, contactId); // 이건 왜 4번이고 지랄이야 슈밥...
			
			// SQL 쿼리의 ? 순서와 parameterIndex의 값은 동일하게 지정
			// 예시) ?가 첫 번째이면 parameterIndex = 1

			// setInt() : DB의 Number 타입
			// setString() : DB의 varchar, varchar2 타입
			// setFloat() : DB의 Float 타입
			// setDate() : DB의 Date타입
//					System.out.println(SQL_INSERT);

			// 6. SQL 문장 실행(DB 서버로 SQL 전송)
			int result = pstmt.executeUpdate();

			// 7. DB 서버가 보낸 결과 확인/처리
			System.out.println(result + "행이 수정됩니다.");

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
