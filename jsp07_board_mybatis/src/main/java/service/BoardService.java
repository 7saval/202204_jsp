package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.BoardDAO;
import dao.BoardfileDAO;
import dao.ReplyDAO;
import dto.Board;
import dto.Boardfile;

public class BoardService {
	private BoardDAO boarddao = new BoardDAO();
	private BoardfileDAO boardfiledao = new BoardfileDAO();
	private ReplyDAO replydao = new ReplyDAO();
	public void insert(Board board, List<String> filenames) {
		//게시물 저장
		int cnt = boarddao.insert(board);
		System.out.println(cnt+"건 board 추가");
		
		//게시물 파일 저장
		//bnum는 board저장 시 생성(boardMapper에서 selectKey로 세팅)
		for(String filename:filenames) {
			Boardfile boardfile = new Boardfile();
			boardfile.setBnum(board.getBnum());
			boardfile.setFilename(filename);
			cnt += boardfiledao.insert(boardfile);
		}
		System.out.println(cnt+"건 boardfile 추가");
	}
	public List<Board> selecList(Map<String, Object> findmap) {
				
		//1)페이징 처리
		int perPage = 10; //한페이지의 게시물수:
		int curPage = (int)findmap.get("curPage"); //현재 페이지
		int startnum = (curPage-1)*perPage +1; //시작 번호
		int endnum = startnum + perPage -1; //끝 번호
		findmap.put("startnum", startnum);
		findmap.put("endnum", endnum);
		
		//2)페이징블럭 처리
		//2-1)전체게시물 수
		int totCnt = boarddao.select_totalcnt(findmap);
		int totPage = totCnt/perPage;
		if(totCnt % perPage >0) totPage++; //나머지가 있으면 +1
		findmap.put("totPage", totPage);
	
		int perBlock = 10;
		int startPage = curPage-((curPage-1)%perBlock);
		int endPage = startPage+(perBlock-1);
		//endPage수정
		if(endPage>totPage) endPage = totPage;
		
		findmap.put("startPage", startPage); //블럭의 시작페이지
		findmap.put("endPage", endPage); //블럭의 끝페이지
		
		System.out.println("findmap: "+findmap);
		return boarddao.selectList(findmap);
	}
	public Board selectOne(int bnum) {
		return boarddao.selectOne(bnum);
	}
	public void delete(int bnum) {
		//1)댓글 삭제(자식):반드시 자식부터 삭제
		int cnt = replydao.delete_bnum(bnum);
		System.out.println(cnt+"건 reply 삭제");
		//2)게시물 파일 삭제(자식):반드시 자식부터 삭제
		cnt = boardfiledao.delete_bnum(bnum);
		System.out.println( cnt+"건 boardfile 삭제");
		//3)게시물 삭제(부모)
		cnt = boarddao.delete(bnum);
		System.out.println(cnt+"건 board 삭제");
	}
	public void update(Board board, List<String> filenames, String[] removefiles) {
		//1) 게시물수정
		boarddao.update(board);
		//2)추가할 파일들 추가
		for(String filename:filenames) {
			Boardfile boardfile = new Boardfile();
			boardfile.setBnum(board.getBnum());
			boardfile.setFilename(filename);
			boardfiledao.insert(boardfile);
		}
		
		//3)파일들 삭제
		if(removefiles == null) return ;
		for(String bfnum:removefiles) {
			boardfiledao.delete(Integer.parseInt(bfnum));
		}
		
	}
	//조회수+1
	public void update_readcnt(int bnum) {
		boarddao.update_readcnt(bnum);
	}
}
