package kr.co.mlec.board.service;

import java.util.ArrayList;

import kr.co.mlec.board.dao.BoardDAO;
import kr.co.mlec.board.vo.BoardVO;

public class BoardServiceImpl implements BoardService {

	private BoardDAO dao;
	
	public BoardServiceImpl(BoardDAO dao) {
		this.dao = dao;
	}

	@Override
	public ArrayList<BoardVO> retrieveBoard() throws Exception {
		ArrayList<BoardVO> list = dao.selectBoardList();
		return list;
	}

	@Override
	public int writeBoard(BoardVO board) throws Exception {
		int cnt = dao.insertBoard(board);
		return cnt;
	}

}
