package dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import dto.Reply;

class JunitTestReply {
	private ReplyDAO replydao = new ReplyDAO();
	@Test
	void testInsert() {
		Reply reply = new Reply();
		reply.setBnum(163);
		reply.setContent("댓글5");
		reply.setRestep(3);
		reply.setRelevel(1);
		int cnt = replydao.insert(reply);
		System.out.println(cnt+"건 추가");
	}
	@Test
	void testUpdate() {
		Reply reply = new Reply();
		reply.setRnum(2);
		reply.setContent("댓글4");
		int cnt = replydao.update(reply);
		System.out.println(cnt+"건 수정");
	}
	@Test
	void testDelete() {
		int cnt = replydao.delete(2);
		System.out.println(cnt+"건 삭제");
	}
	@Test
	void testSelectOne() {
		Reply reply = replydao.selectOne(4);
		System.out.println(reply);
	}
	@Test
	void testSelectList() {
		List<Reply> rlist = replydao.selectList(163);
		System.out.println(rlist);
	}
}
