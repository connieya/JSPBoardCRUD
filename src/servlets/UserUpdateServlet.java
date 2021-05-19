package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.User;
import user.UserDAO;

// ServletContext에 보관된 UserDao 사용하기
@SuppressWarnings("serial")
@WebServlet("/user/update")
public class UserUpdateServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ServletContext sc = this.getServletContext();
			UserDAO userDao = (UserDAO) sc.getAttribute("user");	
			User user =userDao.userDetail(Integer.parseInt(request.getParameter("no")));
			request.setAttribute("user", user);
			RequestDispatcher rd = request.getRequestDispatcher("/user/update.jsp");
					
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			try {
				ServletContext sc = this.getServletContext();
				UserDAO dao = (UserDAO) sc.getAttribute("user");
				
				dao.update(new User()
						.setEmail(req.getParameter("email"))
						.setId(req.getParameter("id"))
						.setName(req.getParameter("name"))
						.setPassword(req.getParameter("password")));
			} catch (Exception e) {
				// TODO: handle exception
			}
	}
}
