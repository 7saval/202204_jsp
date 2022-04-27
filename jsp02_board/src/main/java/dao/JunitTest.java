package dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import dto.Board;

class JunitTest {
	BoardDAO bdao = new BoardDAO();
	@Test
	void testInsert() {
		Board board = new Board();
		board.setWriter("아이유");
		board.setSubject("제목테스트");
		board.setContents("내용");
		int cnt =bdao.insert(board);
		System.out.println(cnt+"건 추가");
	}

	@Test
	void testUpdate() {
		Board board = new Board();
		board.setSeq(2);
		board.setWriter("아이유");
		board.setSubject("제목테스트");
		board.setContents("나의옛날이야기");
		System.out.println(board);
		int cnt= bdao.update(board);
		System.out.println(cnt+"건 수정");
	}

	@Test
	void testDelete() {
		int cnt = bdao.delete(1);
		System.out.println(cnt +"건 삭제");
	}

	@Test
	void testSelectList() {
		List<Board> blist = bdao.selectList("제목", "제목");
		System.out.println(blist);
	}

	@Test
	void testSelectOne() {
		Board board = bdao.selectOne(2);
		System.out.println(board);
	}

}
