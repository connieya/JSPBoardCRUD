package listeners;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

import controls.BoardListController;
import controls.LogOutController;
import controls.LoginController;
import controls.UserAddController;
import dao.BoardDAO;
import dao.MySqlUserDAO;
import util.DBConnectionPool;

@WebListener
public class ContextLoaderListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent event) {
		try {
			ServletContext sc = event.getServletContext();
			
			InitialContext initialContext = new InitialContext();
			DataSource ds = (DataSource) initialContext.lookup(
					"java:comp/env/jdbc/pgh");
					
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.setDataSource(ds);
			
			MySqlUserDAO userDao = new MySqlUserDAO();
			userDao.setDataSource(ds);
			
			sc.setAttribute("/auth/login.do", 
					new LoginController().setUserDao(userDao));
			sc.setAttribute("/auth/logout.do", new LogOutController());
			sc.setAttribute("/board/list.do",
					new BoardListController().setBoardDao(boardDAO));
			sc.setAttribute("/user/add.do",
					new UserAddController().setUserDao(userDao));
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		
	}
	
}
