package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.Board;
import board.BoardDAO;

@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		try {
			ServletContext sc = this.getServletContext();
			BoardDAO dao = (BoardDAO)sc.getAttribute("dao");
			int pagenum =1;
			req.setAttribute("boards", dao.list(pagenum));	
			
			resp.setContentType("text/html; charset=UTF-8");
			RequestDispatcher rd = req.getRequestDispatcher("/board/board.jsp");
			rd.include(req, resp);				
		} catch (Exception e) {
			req.setAttribute("error", e);
			RequestDispatcher rd = req.getRequestDispatcher("/Error.jsp");
			rd.forward(req, resp);
			System.out.println(e.getMessage());
		}
	}	
}
