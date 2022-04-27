package dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import dto.Board;
import dto.Boardfile;

class JunitTestBoardfile {
	BoardfileDAO bfdao = new BoardfileDAO();
	@Test
	void testInsert() {
		Boardfile boardfile = new Boardfile();
		boardfile.setBnum(6);
		boardfile.setFilename("제목4");
		int cnt = bfdao.insert(boardfile);
		System.out.println(cnt+"건 추가");
	}
	@Test
	void testUpdate() {
		Boardfile boardfile = new Boardfile();
		boardfile.setBfnum(2);
		boardfile.setFilename("아이유");
		int cnt = bfdao.update(boardfile);
		System.out.println(cnt+"건 수정");
	}
	@Test
	void testDelete() {
		Boardfile boardfile = new Boardfile();
		int cnt = bfdao.delete(2);
		System.out.println(cnt+"건 삭제");
	}
	@Test
	void testSelecOne() {
		Boardfile boardfile = bfdao.selectOne(3);
		System.out.println(boardfile);
	}
	@Test
	void testSelectList() {
		Map<String, Object> findmap = new HashMap<>();
		findmap.put("findkey", "filename");
		findmap.put("findvalue", "제목");
		List<Boardfile> bflist = bfdao.selectList(findmap);
		System.out.println(bflist);
	}

}
