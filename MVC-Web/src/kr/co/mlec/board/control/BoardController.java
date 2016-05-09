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
}
