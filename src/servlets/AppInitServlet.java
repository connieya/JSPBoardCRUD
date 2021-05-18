package servlets;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class AppInitServlet extends HttpServlet {
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("AppInitServlet 준비..");
		super.init(config);
		try {
			ServletContext sc = this.getServletContext();
			Class.forName(sc.getInitParameter("driver"));
			Connection conn = DriverManager.getConnection(sc.getInitParameter("url"),
					sc.getInitParameter("username"),
					sc.getInitParameter("password"));
			// 데이터베이스 커넥션 객체를 준비 다 한 뒤, ServletContext 객체에 저장
					sc.setAttribute("conn", conn);		
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Override
	public void destroy() {
		System.out.println("AppInitServlet 마무리..");
		super.destroy();
		Connection conn =
				(Connection) this.getServletContext().getAttribute("conn");
		
		try {
			if(conn!=null && conn.isClosed() == false) {
				conn.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
