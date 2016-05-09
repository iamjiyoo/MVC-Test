package kr.co.mlec.framework;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispatcherServlet
 */
@SuppressWarnings("serial")
@WebServlet(
		urlPatterns = { "*.do" }, 
		initParams = { 
				@WebInitParam(name = "controllers", value = "kr.co.mlec.board.control.BoardController|kr.co.mlec.login.control.LoginController")
		})
public class DispatcherServlet extends HttpServlet {

	private HandlerMapping mappings;
	
	public void init(ServletConfig config) throws ServletException {
		String uriCtrlNames = config.getInitParameter("controllers");
		System.out.println(uriCtrlNames);

		try {
			mappings = new HandlerMapping(uriCtrlNames);
		} catch(Exception e) {
			throw new ServletException(e);
		}
		
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		System.out.println("요청 uri : " + uri);
		
		String contextPath = request.getContextPath();
		System.out.println("contextPath : " + contextPath);
		
		uri = uri.substring(contextPath.length());
		CtrlAndMethod control = mappings.getCtrlAndMethod(uri);
		System.out.println("control : " + control);
		
		String view = "";
		try {
			if(control == null) {
				throw new Exception("요청하신 URL이 올바르지 않습니다");
			}
		} catch(Exception e) {
			request.setAttribute("exception", e);
			view = "/ErrorServlet";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

}








