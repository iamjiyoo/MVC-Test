package kr.co.mlec.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import kr.co.mlec.board.dao.BoardDAO;
import kr.co.mlec.board.service.BoardService;
import kr.co.mlec.board.service.BoardServiceImpl;

@WebListener
public class ContextListenter implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext sc = event.getServletContext();
		
		BoardDAO boardDao = new BoardDAO();
		sc.setAttribute("boardDao", boardDao);
		
		BoardService boardService = new BoardServiceImpl(boardDao);
		sc.setAttribute("boardService", boardService);
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	
}
