package edu.java.project01;

// 데이터 -> 저장소로 넘기기 위한 메소드
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import oracle.jdbc.OracleDriver;

public class ItemDAOImple implements ItemDAO, ItemOracleQuery {

	// 다형성 불러오게하자
	private static ItemDAOImple instance = null;

	private ItemDAOImple() {} 
	// 생성자는 클래스 호출할 때 무조건 실행

	public static ItemDAOImple getInstance() {
		if (instance == null) {
			instance = new ItemDAOImple();
		}
		return instance;
	}
	
	@Override // insert
	// 등록되면 등록된 내역 포함 다시 보내버려
	public int insert(ItemVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0; // vessel
		ArrayList<ItemVO> list = new ArrayList<>();
		
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("item insert success2");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("item insert success2");
			pstmt = conn.prepareStatement(SQL_INSERT);
			
			pstmt.setString(1, vo.getItemN());
			pstmt.setString(2, vo.getItemPurchaseP());
			pstmt.setString(3, vo.getItemSalesP());
			pstmt.setString(4, vo.getItemPurchaseC());
			pstmt.setString(5, vo.getItemSalesC());
			pstmt.setString(6, vo.getVendorName());
			
			list.add(vo);
			result = pstmt.executeUpdate();
			System.out.println(result + " insert success");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("item insert failed");
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}// end insert

	@Override // select
	public ArrayList<ItemVO> select() {
		ArrayList<ItemVO> list = new ArrayList<ItemVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
				
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("item select success1");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("item select success2");
			pstmt = conn.prepareStatement(SQL_SELECT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int itemId = rs.getInt(1); 
				String itemN = rs.getString(2);
				String itemPurchaseP = rs.getString(3);
				String itemSalesP = rs.getString(4);
				String itemPurchaseC = rs.getString(5);
				String itemSalesC = rs.getString(6);
				String vendorName = rs.getString(7);
				Date itemD = rs.getDate(8);
				ItemVO vo = new ItemVO(itemId, itemN, itemPurchaseP, itemSalesP, itemPurchaseC, itemSalesC, vendorName,
						itemD); 
				System.out.println(vo + "이 검색되었습니다."); 
				list.add(vo);
			}			
			int result = pstmt.executeUpdate();
			System.out.println(result + "아이템 목록이 검색됩니다.");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("item select failed");
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
	}// end select

	@Override //update
	public int update(ItemVO vo) {		
		int result = 0; 
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("item update success1");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("item update success2");
			pstmt = conn.prepareStatement(SQL_UPDATE);

			pstmt.setString(1, vo.getItemN());
			pstmt.setString(2, vo.getItemPurchaseP());
			pstmt.setString(3, vo.getItemSalesP());
			pstmt.setString(4, vo.getItemPurchaseC());
			pstmt.setString(5, vo.getItemSalesC());
			pstmt.setString(6, vo.getVendorName());
			pstmt.setInt(7, vo.getItemId());

			result = pstmt.executeUpdate(); 
			System.out.println(result + "행의 데이터가 변경되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("item update failed");
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result; 
	}// end update

	@Override // delete
	public int delete(int itemId) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			DriverManager.registerDriver(new OracleDriver());
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("item delete success1");
			pstmt = conn.prepareStatement(SQL_DELETE);
			System.out.println("item delete success2");
			pstmt.setInt(1, itemId); // 변경
			result = pstmt.executeUpdate();
			System.out.println(result + "행의 데이터가 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("item delate failed");
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

}// end ItemDAOImple
