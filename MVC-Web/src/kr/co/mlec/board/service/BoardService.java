package kr.co.mlec.board.service;

import java.util.ArrayList;

import kr.co.mlec.board.vo.BoardVO;

public interface BoardService {

	public ArrayList<BoardVO> retrieveBoard() throws Exception;
	
	public int writeBoard(BoardVO board) throws Exception;
}
