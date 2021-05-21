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

import controls.BoardAddController;
import controls.BoardListController;
import controls.LogOutController;
import controls.LoginController;
import controls.UserAddController;
import dao.MySqlBoardDAO;
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
					
			MySqlBoardDAO boardDao = new MySqlBoardDAO();
			boardDao.setDataSource(ds);
			
			MySqlUserDAO userDao = new MySqlUserDAO();
			userDao.setDataSource(ds);
			
			sc.setAttribute("/auth/login.do", 
					new LoginController().setUserDao(userDao));
			sc.setAttribute("/auth/logout.do", new LogOutController());
			sc.setAttribute("/board/list.do",
					new BoardListController().setBoardDao(boardDao));
			sc.setAttribute("/user/add.do",
					new UserAddController().setUserDao(userDao));
			sc.setAttribute("/board/add.do",
					new BoardAddController().setBoardDao(boardDao));
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		
	}
	
}
