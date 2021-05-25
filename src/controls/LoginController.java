package controls;

import java.util.Map;

import javax.servlet.http.HttpSession;

import annotation.Component;
import dao.MySqlUserDAO;
import dao.UserDao;
import vo.User;

@Component("/auth/login.do")
public class LoginController implements Controller {
	UserDao userDao;
	
	public LoginController setUserDao(UserDao userDao) {
		this.userDao = userDao;
		return this;
	}
	public Object[] getDataBinders() {
	    return new Object[]{
	        "loginInfo", vo.User.class
	    };
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
				return "/auth/LoginFail.jsp";
			}
		}
	}

}
