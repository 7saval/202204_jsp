package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dto.Member;
import dto.Money;
import dto.MoneyList;

public class MoneyDAO {
	private Connection con;
	private String sql;
	private PreparedStatement pstmt;
	//매출조회
	public List <Map<String, Object>> selectList(){
		List <Map<String, Object>> mlist = new ArrayList<>();
		con = DBConn.getCon();	
		String sql = "SELECT mn.custno, mb.custname, \r\n"
				+ " decode(mb.grade,'A','VIP','B','일반','C','직원') grade, SUM(mn.price) price\r\n"
				+ "FROM money_tbl_02 mn JOIN member_tbl_02 mb on(mn.custno = mb.custno)\r\n"
				+ "GROUP BY mn.custno, mb.custname, mb.grade\r\n"
				+ "ORDER BY price DESC";
		try {
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
//				MoneyList monlist = new MoneyList();
//				monlist.setCustno(rs.getInt("custno"));
//				monlist.setCustname(rs.getString("custname"));
//				monlist.setGrade(rs.getString("grade"));
//				monlist.setPrice(rs.getInt("price"));
//				mlist.add(monlist);
				int custno = rs.getInt("custno");
				String custname = rs.getString("custname");
				String grade = rs.getString("grade");
				int price = rs.getInt("price");
				//map생성
				Map<String, Object> map = new HashMap<>();
				map.put("custno", custno);
				map.put("custname",custname);
				map.put("grade", grade);
				map.put("price", price);
				mlist.add(map);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mlist;
	}
}
