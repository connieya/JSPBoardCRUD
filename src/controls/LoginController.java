package controls;

import java.util.Map;

import javax.servlet.http.HttpSession;

import user.User;
import user.UserDAO;

public class LoginController implements Controller {
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		if(model.get("loginInfo") == null) {
			return "/auth/LoginForm.jsp";
		}else {
			UserDAO userDao = (UserDAO) model.get("userDao");
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
