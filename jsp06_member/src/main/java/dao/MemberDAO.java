package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dto.Member;

public class MemberDAO {
	private Connection con;
	private String sql;
	private PreparedStatement pstmt;
	//추가
	public int insert(Member member) {
		int cnt=0;
		con=DBConn.getCon();
		sql="INSERT INTO MEMBER(userid, passwd, salt, zipcode, addrload, addrdetail, filename)\r\n"
				+ "VALUES(?,?,?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getUserid());
			pstmt.setString(2, member.getPasswd());
			pstmt.setString(3, member.getSalt());
			pstmt.setString(4, member.getZipcode());
			pstmt.setString(5, member.getAddrload());
			pstmt.setString(6, member.getAddrdetail());
			pstmt.setString(7, member.getFilename());
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
//		StringBuffer sb = new StringBuffer();
//		sb.append("UPDATE MEMBER\\r\\n");
//		sb.append("SET passwd = ?,\r\n");
//		sb.append("salt = ?,\r\n");
//		sb.append("zipcode = ?,\r\n");
//		sb.append("addrload = ?,\r\n");
//		sb.append("addrdetail = ?,\r\n");
//		sb.append("filename = ?\r\n");
//		sb.append("WHERE userid = ?");
		sql="UPDATE MEMBER\r\n"
				+ "SET passwd = ?,\r\n"
				+ " salt = ?,\r\n"
				+ " zipcode = ?,\r\n"
				+ "addrload = ?,\r\n"
				+ " addrdetail = ?,\r\n"
				+ "filename = ?\r\n"
				+ "WHERE userid = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getPasswd());
			pstmt.setString(2, member.getSalt());
			pstmt.setString(3, member.getZipcode());
			pstmt.setString(4, member.getAddrload());
			pstmt.setString(5, member.getAddrdetail());
			pstmt.setString(6, member.getFilename());
			pstmt.setString(7, member.getUserid());
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cnt;
	}
	//삭제
	public int delete(String userid) {
		int cnt=0;
		con = DBConn.getCon();
		sql="DELETE FROM MEMBER\r\n"
				+ "WHERE userid = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
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
	public Member selectOne(String userid) {
		Member member=null;
		con = DBConn.getCon();
		sql="SELECT*FROM MEMBER\r\n"
				+ "WHERE userid = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				member = new Member();
				member.setUserid(userid);
				member.setPasswd(rs.getString("passwd"));
				member.setSalt(rs.getString("salt"));
				member.setZipcode(rs.getString("zipcode"));
				member.setAddrload(rs.getString("addrload"));
				member.setAddrdetail(rs.getString("addrdetail"));
				member.setFilename(rs.getString("filename"));
				member.setRegidate(rs.getTimestamp("regidate")); //날짜 시분초까지 가져오기
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
	public List<Member> selectList(Map<String, String> findmap){
		List<Member> mlist = new ArrayList<>();
		con = DBConn.getCon();	
		//findkey: addrload, findvalue:관악
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT*FROM MEMBER\r\n");
		//오라클의 데이터가 null이면 조회되지 않는다.
		if(!findmap.get("findvalue").equals(""))
			sb.append("WHERE "+ findmap.get("findkey")+ " LIKE '%' || ? ||'%'");
		sb.append("ORDER BY " + findmap.get("findkey"));
//		sql="SELECT*FROM MEMBER\r\n"
//				+ "WHERE "+ findmap.get("findkey")+ " LIKE '%' || ? ||'%'"
//				+ "ORDER BY " + findmap.get("findkey");
		try {
			pstmt = con.prepareStatement(sb.toString());
			if(!findmap.get("findvalue").equals(""))
				pstmt.setString(1, findmap.get("findvalue"));
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Member member = new Member();
				member.setUserid(rs.getString("userid"));
				member.setPasswd(rs.getString("passwd"));
				member.setSalt(rs.getString("salt"));
				member.setZipcode(rs.getString("zipcode"));
				member.setAddrload(rs.getString("addrload"));
				member.setAddrdetail(rs.getString("addrdetail"));
				member.setFilename(rs.getString("filename"));
				member.setRegidate(rs.getTimestamp("regidate"));
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
