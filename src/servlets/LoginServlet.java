package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.User;


@WebServlet("/auth/login")
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		RequestDispatcher rd = req.getRequestDispatcher("/auth/login.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			ServletContext sc = this.getServletContext();
			conn = (Connection) sc.getAttribute("conn");
			stmt = conn.prepareStatement("select * from user where id =? and password =?");
			stmt.setString(1, req.getParameter("id"));
			stmt.setString(2, req.getParameter("password"));
			rs = stmt.executeQuery();
			if(rs.next()) {
				User user = new User()
						.setEmail(rs.getString("email")).setName(rs.getString("name")).setNo(rs.getInt("no"));
				HttpSession session = req.getSession();
				session.setAttribute("user", user);
			}else {
				RequestDispatcher rd = req.getRequestDispatcher("/auth/LoginFail.jsp");
				rd.forward(req, resp);
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
	
}
