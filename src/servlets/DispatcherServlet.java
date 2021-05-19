package servlets;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controls.BoardListController;
import controls.Controller;
import controls.LoginController;
import controls.UserAddController;
import controls.UserUpdateController;
import user.User;

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
		
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String servletPath = request.getServletPath();
		
		
		try {
			ServletContext sc = this.getServletContext();
			
			HashMap<String, Object> model = new HashMap<>();
			model.put("userDao", sc.getAttribute("user"));
			model.put("boardDao", sc.getAttribute("board"));
			model.put("session", request.getSession());
			
			Controller pageController = null;
			if(servletPath.equals("/board/list.do")) {
				pageController = new BoardListController();
			}else if(servletPath.equals("/user/add.do")) {
				pageController = new UserAddController();
				if(request.getParameter("email") != null) {
					model.put("user", new User()
							.setEmail(request.getParameter("email"))
							.setGender(request.getParameter("gender"))
							.setId(request.getParameter("id"))
							.setName(request.getParameter("name"))
							.setPassword(request.getParameter("password")));
				}
			}else if(servletPath.equals("/user/update.do")) {
				pageController = new UserUpdateController();
				if(request.getParameter("email")!= null) {
					model.put("userUpdate",new User()
							.setEmail(request.getParameter("email"))
							.setId(request.getParameter("id"))
							.setName(request.getParameter("name"))
							.setPassword(request.getParameter("password"))
							);
				}else {
					model.put("no",  Integer.parseInt(request.getParameter("no")));
				}
			}else if("/auth/login.do".equals(servletPath)) {
				pageController = new LoginController();
				if(request.getParameter("id")!= null) {
					model.put("loginInfo", new User()
							.setId(request.getParameter("id"))
							.setPassword(request.getParameter("password")));
				}
				
			}else if("/home.do".equals(servletPath)) {
				response.sendRedirect("/index.jsp");
			}
			
			String viewUrl = pageController.execute(model);
			
			for(String key : model.keySet()) {
				request.setAttribute(key, model.get(key));
			}
			if (viewUrl.startsWith("redirect:")) {
				response.sendRedirect(viewUrl.substring(9));
				return;
			}else {
				RequestDispatcher rd = request.getRequestDispatcher(viewUrl);
		        rd.include(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		}
	}

}
