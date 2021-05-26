package controls.user;

import java.util.Map;

import annotation.Component;
import bind.DataBinding;
import controls.Controller;
import dao.MySqlUserDAO;
import vo.User;

@Component("/user/add.do")
public class UserAddController implements Controller , DataBinding {
	MySqlUserDAO userDao;
	
	public UserAddController setUserDao(MySqlUserDAO userDao) {
		this.userDao = userDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		User user = (User) model.get("user");
		if(user.getEmail() == null) {
			return "/user/UserForm.jsp";
		}else {
			userDao.join(user);
			return "redirect:home.do";
		}
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"user", vo.User.class
		};
	}

}
