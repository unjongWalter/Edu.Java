package edu.java.project01;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import oracle.jdbc.driver.OracleDriver;

public class VendorDAOImple implements VendorDAO, VendorOracleQuery{

	private static VendorDAOImple instance = null;
	
	private VendorDAOImple() {}
	
	public static VendorDAOImple getInstance() {		
		if(instance == null) {
			instance = new VendorDAOImple();
		}
		return instance;
	}

	@Override // insert 
	public int insert(VendorVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		ArrayList<VendorVO> list = new ArrayList<>();
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("vendor insert ora success");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("vendor insert conn success");
			pstmt = conn.prepareStatement(SQL_INSERT);
			
			pstmt.setString(1, vo.getVendorName());
			pstmt.setString(2, vo.getVendorPhone());
			pstmt.setString(3, vo.getVendorEmail());		
		
			result = pstmt.executeUpdate();			
			list.add(vo);
			System.out.println("vendor insert success");
			
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

	// select
	@Override
	public ArrayList<VendorVO> select() {
		ArrayList<VendorVO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("select ora success");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("select conn success");
			pstmt = conn.prepareStatement(SQL_SELECT);
			rs = pstmt.executeQuery();
			int count = 0; // count
			while(rs.next()) {
				int vendorId = rs.getInt(1);
				String vendorName = rs.getString(2);
				String vendorPhone = rs.getString(3);
				String vendorEmail = rs.getString(4);
				
				VendorVO vo = new VendorVO(vendorId, vendorName, vendorPhone, vendorEmail);
				list.add(vo);
				System.out.println("select " + count);
				count++;
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
		return list;
	}//end select

	@Override
	public int update(VendorVO vo) {
		int result = 0; // 그릇 초기화 필수
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("update ora success");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("update conn success");
			pstmt = conn.prepareStatement(SQL_UPDATE);
			
			pstmt.setString(1, vo.getVendorName());
			pstmt.setString(2, vo.getVendorPhone());
			pstmt.setString(3, vo.getVendorEmail());
			pstmt.setInt(4, vo.getVendorId());

			result = pstmt.executeUpdate(); // SQL_UPDATE 지우기 필수, result 그릇 초기화
			System.out.println(result + "update success");
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
	}//end update

	@Override
	public int delete(int vendorId) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			DriverManager.registerDriver(new OracleDriver());			
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("delete ora success");
			
			pstmt = conn.prepareStatement(SQL_DELETE);
			System.out.println("delete conn success");
			pstmt.setInt(1, vendorId); // 변경

			result = pstmt.executeUpdate();
			System.out.println(result + "delete success");
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
	}//end delete
}//end VendorDAOImple
