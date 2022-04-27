package dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import dto.Member;

class JunitTest {
	MemberDAO mdao = new MemberDAO();
	@Test
	void testInsert() {
		Member member = new Member();
		member.setUserid("iu");
		member.setPasswd("1112");
		member.setSalt("1112");
		member.setZipcode("16244");
		member.setAddrload("서울시 관악구 동호로");
		member.setAddrdetail("행복하우스2");
		member.setFilename("cat.png");
		int cnt = mdao.insert(member);
		System.out.println(cnt+"건 추가");
	}
	
	@Test
	void testUpdate() {
		Member member = new Member();
		member.setUserid("java");
		member.setPasswd("2222");
		member.setSalt("2222");
		member.setZipcode("16420");
		member.setAddrload("서울시 관악구 국사봉길");
		member.setAddrdetail("행복빌라");
		member.setFilename("dog.png");
		System.out.println(member);
		int cnt = mdao.update(member);
		System.out.println(cnt+"건 수정");
		
	}
	@Test
	void testDelete() {
		Member member = new Member();
		int cnt = mdao.delete("java");
		System.out.println(cnt+"건 삭제");
		
	}
	
	@Test
	void testSelectOne() {
		Member member = mdao.selectOne("java");
		System.out.println(member);
	}
	@Test
	void testSelectList() {
		Map<String, String> findmap = new HashMap<>();
		findmap.put("findkey", "addrload");
		findmap.put("findvalue", "관악");
		List<Member> mlist = mdao.selectList(findmap);
		for(Member member:mlist) {
			System.out.println(member.getUserid());
			System.out.println(member.getPasswd());
			System.out.println(member.getSalt());
			System.out.println(member.getZipcode());
			System.out.println(member.getAddrload());
			System.out.println(member.getAddrdetail());
			System.out.println(member.getFilename());
			System.out.println(member.getRegidate());
		}
		
	}
}
