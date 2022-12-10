package edu.java.jdbc07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import edu.java.jdbc03.ContactVO;
import oracle.jdbc.driver.OracleDriver;
// 인서트 딜리트업데이트 셀렉트바이인덱스는 프리페어드~
// 4번 걍 셀렉트 vs 7번 물음표 사용 셀렉트
public class JDBCMain07 {

	// 1. DB에 사용할 상수들, insert update delete 같음
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; // 접속할 오라클 DB 경로
	public static final String USER = "scott";
	public static final String PASSWORD = "tiger";

	public static final String TABLE_NAME = "EX_CONTACT";
	public static final String COL_CONTACT_ID = "CONTACT_ID";
	public static final String COL_NAME = "NAME";
	public static final String COL_PHONE = "PHONE";
	public static final String COL_EMAIL = "EMAIL";

	public static final String SQL_SELECT_BY_CONTACT_ID =
			"SELECT * FROM " + TABLE_NAME + " WHERE " + COL_CONTACT_ID + " = ?";
		
	public static void main(String[] args) {
		System.out.println("JDBC 7 - select by index");
		Connection conn = null; // 여는역할이라 밑에서 꼭 닫아라
		PreparedStatement pstmt = null; // 밑에서 역순으로 닫아라
		ResultSet rs = null; 
		
		// 2. Oracle DB 드라이버를 메모리에 로드
		try {
			DriverManager.registerDriver(new OracleDriver());
			
			// 3. DB의 Connection연결 맺음
			conn = DriverManager.getConnection(URL, USER,PASSWORD);
			System.out.println("DB 연결 성공");
			
			// 4. Connection 객체 사용, Pre~ 객체 생성
			pstmt = conn.prepareStatement(SQL_SELECT_BY_CONTACT_ID);// 확인 할거 상수형태로
			
			Scanner sc = new Scanner(System.in);
			System.out.println("inex no?");
			int contactId = sc.nextInt();
			
			// 5. SQL 문장 완성
			pstmt.setInt(1, contactId);
			
			// 6. SQL 문장 실행(DB 서버로 SQL 전송)
			rs = pstmt.executeQuery();
			
			// 7. DB서버가 보낸 결과 확인/처리			
			if(rs.next()) {
				contactId = rs.getInt(1); // CONTACT_ID 컬럼
				String name = rs.getString(2); // name
				String phone = rs.getString(3); // phone
				String email = rs.getString(4); // email
				
				ContactVO vo = new ContactVO(contactId, name, phone, email);
				System.out.println(vo);
			}			
		} catch (SQLException e) {
			System.out.println(e.toString());// 이렇게 해놔라...
			e.printStackTrace();
		} finally { // DB는 conn.close(); 여기서 꼭 닫아라, 또 try-catch써라
			try {
				rs.close(); // 열었던 순서대로 닫아라...
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		
	}// end main()

}// end JDBCMain07
