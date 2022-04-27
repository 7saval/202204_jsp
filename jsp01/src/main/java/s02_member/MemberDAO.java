package s02_member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//db를 접속 클래스
public class MemberDAO {
	//반환형 메소드명(매개변수){}
	
	//db에 insert를 실행해주는 메소드
	int insert(Member member) {
		int cnt = 0; //적용건수
		//db접속
		Connection con = DBConn.getCon();
		String sql="INSERT INTO member(userid, passwd, name, email)\r\n"
				+ "VALUES(?,?,?,?)";
		try {
			PreparedStatement pstmt= con.prepareStatement(sql);
			pstmt.setString(1, member.getUserid());
			pstmt.setString(2, member.getPasswd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getEmail());
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cnt;
	};
	
	//조회리스트
	List<Member> selectList(){
		List<Member> mlist= new ArrayList<>();
		Connection con = DBConn.getCon();
		String sql = "SELECT * FROM member";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String userid= rs.getString("userid");
				String passwd= rs.getString("passwd");
				String name= rs.getString("name");
				String email= rs.getString("email");
				Member member = new Member(userid, passwd, name, email);
				mlist.add(member);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mlist;
	}
	//한건 조회
	Member selectOne(String userid) {
		Member member=null;
		Connection con = DBConn.getCon();
		String sql="SELECT * FROM member\r\n"
				+ "WHERE userid = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				member = new Member();
				member.setUserid(userid);
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
	int update(Member member) {
		int cnt=0; //적용건수
		Connection con = DBConn.getCon();
		String sql="UPDATE MEMBER\r\n"
				+ "SET passwd = ?,\r\n"
				+ "NAME = ?,\r\n"
				+ "email = ?\r\n"
				+ "WHERE userid = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getPasswd());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getEmail());
			pstmt.setString(4, member.getUserid());
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}
	int delete(String userid) {
		int cnt=0;
		Connection con = DBConn.getCon();
		String sql="DELETE FROM MEMBER\r\n"
				+ "WHERE userid = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,userid);
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}

	
	
	
	
	
}
