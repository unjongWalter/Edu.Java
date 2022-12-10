package edu.java.jdbc04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import edu.java.jdbc03.ContactVO;
import oracle.jdbc.OracleDriver;

public class JDBCMain04 {
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
		System.out.println("JDBC 4 - select by index");

		Connection conn = null;
		Statement stmt = null; // ctrl space sql로 고고
		ResultSet rs = null; // executeQuery관련, 여기 잘봐라

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
			String sql_select_by_contact_id = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL_CONTACT_ID + " = 2"; // 2번
																													// 갖고온나.
			System.out.println(sql_select_by_contact_id);

			// 6. SQL 문장 실행(DB 서버로 SQL 전송)
			rs = stmt.executeQuery(sql_select_by_contact_id);

			// 7. DB 서버가 보낸 결과 확인/처리
			// ResultSet.next() :
			// ResultSet에서 다음행(row, record)이 있으면
			// true를 리턴, ResultSet이 가르키는 위치를 다음 위치로 변경

			// ArrayList<ContactVO>
			// ArrayList<ContactVO> list = new ArrayList<>(); 노필요
			if (rs.next()) { // 레코드가 존재할 때까지
				int contactId = rs.getInt(1); // CONTACT_ID 컬럼, 데이터 형태/타입 알아봐라
				String name = rs.getString(2); // NAME
				String phone = rs.getString(3); // PHONE
				String email = rs.getString(4); // EMAIL

				ContactVO vo = new ContactVO(contactId, name, phone, email); // 묶는데이
				System.out.println(vo);
			}

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
}
