package kr.co.mlec.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.util.ConnectionPool;

public class BoardDAO {

	public ArrayList<BoardVO> selectBoardList() throws Exception {
		
		ArrayList<BoardVO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ConnectionPool.getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append("select no, writer, title, ");
			sql.append("       to_char(reg_date, 'yyyy-mm-dd') as reg_date ");
			sql.append("  from board_t ");
			sql.append(" order by no desc ");
			
			pstmt = conn.prepareStatement(sql.toString());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVO board = new BoardVO();
				
				int no = rs.getInt("no");
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String regDate = rs.getString("reg_date");
				
				board.setNo(no);
				board.setTitle(title);
				board.setWriter(writer);
				board.setRegDate(regDate);
				
				list.add(board);
			}
			
		} catch(Exception e)  {
			throw e;
		} finally {
			if(pstmt != null) {
				pstmt.close();
			}
			ConnectionPool.close(conn);
		}
		
		
		
		return list;
	}
	
	public int insertBoard(BoardVO board) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		
		try {
			conn = ConnectionPool.getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append("insert into board_t(no, title, writer, content) ");
			sql.append("  values(seq_t_board_no.nextval, ?, ?, ?) ");
			
			pstmt = conn.prepareStatement(sql.toString());
			int index = 1;
			pstmt.setString(index++, board.getTitle());
			pstmt.setString(index++, board.getWriter());
			pstmt.setString(index++,  board.getContent());
			
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			throw e;
		} finally {
			if(pstmt != null) {
				pstmt.close();
			}
			ConnectionPool.close(conn);
		}
		return cnt;
	}
}
