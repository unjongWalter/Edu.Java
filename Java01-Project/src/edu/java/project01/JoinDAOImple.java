package edu.java.project01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import oracle.jdbc.OracleDriver;

public class JoinDAOImple implements JoinDAO, JoinOracleQuery {

	private static JoinDAOImple instance = null;

	private JoinDAOImple() {}

	public static JoinDAOImple getInstance() {
		if (instance == null) {
			instance = new JoinDAOImple();
		}
		return instance;
	}

	@Override 
	// 회원가입 
	public int insert(JoinVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0; // vessel
		ArrayList<JoinVO> list = new ArrayList<>();
		
		try {
			DriverManager.registerDriver(new OracleDriver());			
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Join driver success");
			
			pstmt = conn.prepareStatement(SQL_INSERT);
			System.out.println("Join connection success");
			pstmt.setString(1, vo.getJoinId());
			pstmt.setString(2, vo.getJoinPassword());
			pstmt.setString(3, vo.getJoinName());
			pstmt.setString(4, vo.getJoinPhone());
			pstmt.setString(5, vo.getJoinEmail());
		
			list.add(vo);
			result = pstmt.executeUpdate();
			System.out.println(result + " insert success");
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
		return result;
	}//end insert
	
	// 아이디 중복확인, 로그인 
	public ArrayList<JoinVO> select() {
		ArrayList<JoinVO> list = new ArrayList<>();
		JoinVO vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			DriverManager.registerDriver(new OracleDriver());
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("JoinVO ora success");
			pstmt = conn.prepareStatement(SQL_SELECT);
		
			System.out.println("JoinVO conn success");
			rs = pstmt.executeQuery(); // 비워둬
			while(rs.next()){
				String memberId = rs.getString(1);
				String memberPw = rs.getString(2);
				
				vo = new JoinVO(memberId, memberPw);
				list.add(vo);
				System.out.println(TABLE_NAME + "테이블에서 1행 조회함");
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}//end select

}//end JoinDAOImple
