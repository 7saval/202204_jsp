package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Member;

public class MemberDAO {
	private Connection con;
	private String sql;
	private PreparedStatement pstmt;
	//한건조회
	public Member selectOne(String userid){
		Member member = null;
		con = DBConn.getCon();
		sql = "SELECT * FROM member\r\n"
				+ "WHERE userid = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			ResultSet rs= pstmt.executeQuery();
			if(rs.next()) {
				member= new Member();
				member.setUserid(rs.getString("userid"));
				member.setPasswd(rs.getString("passwd"));
				member.setName(rs.getString("name"));
				member.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return member;
	}
}
