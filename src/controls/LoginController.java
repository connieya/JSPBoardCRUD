package controls;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.MySqlUserDAO;
import vo.User;


public class LoginController implements Controller {
	MySqlUserDAO userDao;
	
	public LoginController setUserDao(MySqlUserDAO userDao) {
		this.userDao = userDao;
		return this;
	}
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		if(model.get("loginInfo") == null) {
			return "/auth/LoginForm.jsp";
		}else {
			User loginInfo = (User) model.get("loginInfo");
		
			User user = userDao.login(
					loginInfo.getId(), 
					loginInfo.getPassword());
			if(user != null) {
				HttpSession session = (HttpSession) model.get("session");
				session.setAttribute("user", user);
				return "redirect:../board/list.do";
			}else {
				return "/auth/LoginFail";
			}
		}
	}

}
