package kr.co.mlec.board.control;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.board.service.BoardService;
import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.framework.Controller;
import kr.co.mlec.framework.ModelAndView;
import kr.co.mlec.framework.RequestMapping;

@Controller
public class BoardController {
	
	@RequestMapping("/board/list.do")
	public ModelAndView list(HttpServletRequest req, HttpServletResponse resp)
		throws Exception {
		
		ServletContext sc = req.getServletContext();
		BoardService service = (BoardService)sc.getAttribute("boardService");
		
		ArrayList<BoardVO> list = service.retrieveBoard();
		

		ModelAndView mav = new ModelAndView();
		mav.setView("/jsp/board/list.jsp");
		mav.addAttribute("list", list);
		
		return mav;
	}
	
	@RequestMapping("/board/write.do")
	public ModelAndView write(HttpServletRequest req, HttpServletResponse resp) 
		throws Exception {
	
		String title = req.getParameter("title");
		String writer = req.getParameter("writer");
		String content = req.getParameter("content");
		
		BoardVO board = new BoardVO();
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		
		ServletContext sc = req.getServletContext();
		BoardService service = (BoardService)sc.getAttribute("boardService");
		int cnt = service.writeBoard(board);
		
		ModelAndView mav = new ModelAndView("/board/list.do");
		String msg = "게시글이 등록되었습니다.";
		if(cnt != 1) {
			msg = "게시글 등록 처리시 오류가 발생하였습니다.";
		}
		mav.addAttribute("msg", msg);
		return mav;
	}
}
