package edu.java.contact06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import oracle.jdbc.OracleDriver;

public class ContactDAOImple implements ContactDAO, OracleQuery {

	// Singleton
	private static ContactDAOImple instance = null;

	// DB 드라이버 등록
	private ContactDAOImple() { // 기본생성자로 판 깔아주냐?
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 등록 성공");

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	// instance를 return하는 method
	public static ContactDAOImple getInstance() {
		if (instance == null) {
			instance = new ContactDAOImple();
		}
		return instance;
	} //end DAOImple getInstance

	@Override // dao의 틀, return = result;
	public int insert(ContactVO vo) { // 리턴타입 성공 실패 0 or 1
		// DB 연결 -> vo 데이터를 DB에 저장하고 결과(result) return
		// DB연결
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0; // 그릇 준비, 리턴에서 알 수 있도록 초기화.

		// DB 저장
		try {
			DriverManager.registerDriver(new OracleDriver());
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPhone());
			pstmt.setString(3, vo.getEmail());

			result = pstmt.executeUpdate();
			System.out.println(result + "행의 데이터가 저장되었습니다.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close(); // 역순 닫기
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result; // 리턴 조심... 필수
	} // end insert

	@Override // return = list;
	public ArrayList<ContactVO> select() { // 셀렉트올
		// DB 연결 -> 전체 데이터를 검색하여 return
		// ArrayList, DB 연결
		ArrayList<ContactVO> list = new ArrayList<ContactVO>();
		Connection conn = null; // 연결을 위한
		PreparedStatement pstmt = null; // 상태정보
		ResultSet rs = null; // object로 돌려주기 위한

		try {
			DriverManager.registerDriver(new OracleDriver());
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(SQL_SELECT);
			rs = pstmt.executeQuery();

			while (rs.next()) {// 행이 존재할때까지
				int contactId = rs.getInt(1); // 컬럼이랑 매치된다.
				String name = rs.getString(2);
				String phone = rs.getString(3);
				String email = rs.getString(4);

				ContactVO vo = new ContactVO(contactId, name, phone, email); //포장해서 보낸다.
				System.out.println(vo); // log찍기
				list.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list; // 조심, 리스트 돌려주는 것...
	}// end select all

	@Override
	public ContactVO select(int contactId) {
		// DB에 연결 -> 인덱스 검색 데이터 리턴

		ArrayList<ContactVO> list = new ArrayList<ContactVO>();
		ContactVO vo = null; // 이거 개념.... 슙압
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; //검색은 리서트셋 무조건 써라

		try {
			DriverManager.registerDriver(new OracleDriver());
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(SQL_SELECT_BY_CONTACT_ID);
			pstmt.setInt(1, contactId);

			rs = pstmt.executeQuery();
			if (rs.next()) { // 행이 존재하면
//				contactId = rs.getInt(1); // 없애도 된대~ 개념숙지
				String name = rs.getString(2);
				String phone = rs.getString(3);
				String email = rs.getString(4);

				vo = new ContactVO(contactId, name, phone, email); // ContactVO 널처리
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return vo;
	} // end select by contactId

	@Override
	public int update(ContactVO vo) {
		// DB 연결 -> 인덱스 데이터 수정
//		int count = dao.select().get(0).getId();
//		int size = dao.select().size()-1;
//		if(index >= count && index <= (count+size)){}
		int result = 0; // 그릇 초기화 필수
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			DriverManager.registerDriver(new OracleDriver());
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(SQL_UPDATE);
			
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPhone());
			pstmt.setString(3, vo.getEmail());
			pstmt.setInt(4, vo.getContactId());

			result = pstmt.executeUpdate(); // SQL_UPDATE 지우기 필수, result 그릇 초기화
			System.out.println(result + "행의 데이터가 변경되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result; // 0이면 실패 1이면 저장성공
	}// end update

	@Override
	public int delete(int contactId) {
		// DB 연결 -> 인덱스 데이터 삭제
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			DriverManager.registerDriver(new OracleDriver());
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(SQL_DELETE);
			pstmt.setInt(1, contactId); // 변경

			result = pstmt.executeUpdate();
			System.out.println(result + "행의 데이터가 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result; // 0이면 실패 1이면 저장성공
	}// end delete
}// end ContactDAOImple
