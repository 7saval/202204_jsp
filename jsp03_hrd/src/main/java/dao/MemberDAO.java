package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Member;

public class MemberDAO {
	private Connection con;
	private String sql;
	private PreparedStatement pstmt;
	//추가
	public int insert(Member member) {
		int cnt=0;
		con=DBConn.getCon();
		sql="INSERT INTO member_tbl_02(custno, custname, phone, address, joindate, grade,city)\r\n"
				+ "VALUES((select nvl(MAX(custno)+1,1) FROM member_tbl_02),\r\n"
				+ "?,?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getCustname());
			pstmt.setString(2, member.getPhone());
			pstmt.setString(3, member.getAddress());
			pstmt.setString(4, member.getJoindate());
			pstmt.setString(5, member.getGrade());
			pstmt.setString(6, member.getCity());
			cnt= pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}
	//수정
	public int update(Member member) {
		int cnt=0;
		con = DBConn.getCon();
		sql="UPDATE member_tbl_02\r\n"
				+ "SET custname = ?,\r\n"
				+ "phone = ?,\r\n"
				+ "address = ?,\r\n"
				+ "joindate = ?,\r\n"
				+ "grade = ?,\r\n"
				+ "city = ?\r\n"
				+ "WHERE custno = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getCustname());
			pstmt.setString(2, member.getPhone());
			pstmt.setString(3, member.getAddress());
			pstmt.setString(4, member.getJoindate());
			pstmt.setString(5, member.getGrade());
			pstmt.setString(6, member.getCity());
			pstmt.setInt(7, member.getCustno());
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cnt;
	}
	//삭제
	public int delete(int custno) {
		int cnt=0;
		con = DBConn.getCon();
		sql="DELETE FROM member_tbl_02\r\n"
				+ "where custno = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, custno);
			cnt= pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("예외발생");
			e.printStackTrace();
		} 
		
		return cnt;
	}
	//한건 조회
	public Member selectOne(int custno) {
		Member member=null;
		con = DBConn.getCon();
		sql="SELECT custno, custname, phone, address, \r\n"
				+ "to_char(joindate,'YYYY-MM-DD') joindate, grade, city\r\n"
				+ "FROM member_tbl_02\r\n"
				+ "where custno =?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, custno);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				member = new Member();
				member.setCustno(custno);
				member.setCustname(rs.getString("custname"));
				member.setPhone(rs.getString("phone"));
				member.setAddress(rs.getString("address"));
				member.setJoindate(rs.getString("joindate"));
				member.setGrade(rs.getString("grade"));
				member.setCity(rs.getString("city"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("예외발생");
			e.printStackTrace();
		} 
		return member;
	}
	//리스트
	public List<Member> selectList(){
		List<Member> mlist = new ArrayList<>();
		con = DBConn.getCon();		
		sql="SELECT custno, custname, phone, address, to_char(joindate,'YYYY-MM-DD') joindate,\r\n"
				+ "decode(grade, 'A', 'VIP', 'B', '일반','C','직원') grade, city \r\n"
				+ "FROM member_tbl_02\r\n"
				+ "ORDER BY custno";
		try {
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Member member = new Member();
				member.setCustno(rs.getInt("custno"));
				member.setCustname(rs.getString("custname"));
				member.setPhone(rs.getString("phone"));
				member.setAddress(rs.getString("address"));
				member.setJoindate(rs.getString("joindate"));
				member.setGrade(rs.getString("grade"));
				member.setCity(rs.getString("city"));
				mlist.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("예외발생");
			e.printStackTrace();
		} 
		return mlist;
	}
	
}
