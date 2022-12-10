package edu.java.jdbc03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import oracle.jdbc.OracleDriver;

public class JDBCMain03_pstmt {
	// 1. DB에 사용할 상수들, insert update delete 같음
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; // 접속할 오라클 DB 경로
	public static final String USER = "scott";
	public static final String PASSWORD = "tiger";

	public static final String TABLE_NAME = "EX_CONTACT";
	public static final String COL_CONTACT_ID = "CONTACT_ID";
	public static final String COL_NAME = "NAME";
	public static final String COL_PHONE = "PHONE";
	public static final String COL_EMAIL = "EMAIL";

	public static final String SQL_SELECT = // 이게 기어올라왔네
			"SELECT * FROM " + TABLE_NAME + " ORDER BY " + COL_CONTACT_ID;

	public static void main(String[] args) {
		System.out.println("JDBC 3 - select all");

		Connection conn = null;
		PreparedStatement pstmt = null; // ctrl space sql로 고고
		ResultSet rs = null; // executeQuery관련, 여기 잘봐라

		try {
			// 2. Oracle JDBC 드라이버를 메모리에 로드
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			// 3. DB와 Connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB연결성공");

			// 4. SQL 문장 작성? 작성하고자하는 QUERY...
			// SELECT * FROM EX_CONTACT ORDER BY CONTACT_ID;
			// System.out.println(SQL_SELECT);

			// 5. Connection 객체를 사용하여 Statement 객체를 생성
			pstmt = conn.prepareStatement(SQL_SELECT); // prepared에는 셀렉트...

			// 6. SQL 문장 실행(DB 서버로 SQL 전송)
			rs = pstmt.executeQuery();

			// 7. DB 서버가 보낸 결과 확인/처리
			// ResultSet.next() :
			// ResultSet에서 다음행(row, record)이 있으면
			// true를 리턴, ResultSet이 가르키는 위치를 다음 위치로 변경

			// ArrayList<ContactVO> 여기 중요하댄다... 슈밥쇼뵵샤뱔
			ArrayList<ContactVO> list = new ArrayList<>();
			while (rs.next()) { // 레코드가 존재할 때까지
				int contactId = rs.getInt(1); // CONTACT_ID 컬럼, 데이터 형태/타입 알아봐라
				String name = rs.getString(2); // NAME
				String phone = rs.getString(3); // PHONE
				String email = rs.getString(4); // EMAIL

				ContactVO vo = new ContactVO(contactId, name, phone, email); // 묶는데이
				list.add(vo); // Array에서 꺼냈다가 묶어서 집어넣고 쓴다
			}

			for (ContactVO vo : list) {
				System.out.println(vo);
			}
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
