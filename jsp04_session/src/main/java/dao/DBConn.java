package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//db컨넥션을 반환
public class DBConn {
	//static : 정적메소드
	static Connection getCon() {
		Connection con=null;
		//url, user, password
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "hr";
		try {
			//오라클 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//컨넥션 객체 생성
			con = DriverManager.getConnection(url, user, password);
			System.out.println("컨넥션 완료");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이브 로딩 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("접속 실패");
			e.printStackTrace();
		}
		
		return con;
	}
}
