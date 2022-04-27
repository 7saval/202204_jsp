package dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import dto.Member;

class JunitTest {
	MemberDAO mdao = new MemberDAO();
	@Test
	void testInsert() {
		Member member = new Member();
		member.setCustname("김자바");
		member.setPhone("010-0000-1111");
		member.setAddress("서울 동대문구 휘경3동");
		member.setJoindate("20151204");
		member.setGrade("A");
		member.setCity("01");
		int cnt = mdao.insert(member);
		System.out.println(cnt+"건 추가");
	}
	
	@Test
	void testUpdate() {
		Member member = new Member();
		member.setCustno(100008);
		member.setCustname("박자바");
		member.setPhone("011-1111-1111");
		member.setAddress("서울 동작구 휘경3동");
		member.setJoindate("20201204");
		member.setGrade("C");
		member.setCity("02");
		System.out.println(member);
		int cnt = mdao.update(member);
		System.out.println(cnt+"건 수정");
		
	}
	@Test
	void testDelete() {
		Member member = new Member();
		int cnt = mdao.delete(100008);
		System.out.println(cnt+"건 삭제");
		
	}
	
	@Test
	void testSelectOne() {
		Member member = mdao.selectOne(100007);
		System.out.println(member);
	}
	@Test
	void testSelectList() {
		List<Member> mlist = mdao.selectList();
		System.out.println(mlist);
	}
}
