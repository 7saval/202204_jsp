package service;

import java.util.List;

import dao.BoardfileDAO;
import dto.Boardfile;

public class BoardfileService {
	private BoardfileDAO boardfiledao = new BoardfileDAO();
	public List<Boardfile> selectList(int bnum){
		return boardfiledao.selectList(bnum);
	}
}
