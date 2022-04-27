package s02_member;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

class JunitTest {

	@Test
	void testDBConn() {
		//db컨넥션 테스트
		Connection con = DBConn.getCon();
		System.out.println(con);
		//con이 null아닐 때 성공
		assertNotNull(con);
	}
	
	@Test
	void testInsert() {
		Member member = new Member();
		member.setUserid("hong");
		member.setPasswd("1234");
		member.setName("홍길동");
		member.setEmail("hong@gmail.com");
		System.out.println(member);
		MemberDAO mdao = new MemberDAO();
		int cnt = mdao.insert(member);
		System.out.println(cnt+"건 추가");
	}

}
