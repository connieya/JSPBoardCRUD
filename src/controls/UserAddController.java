package controls;

import java.util.Map;

import bind.DataBinding;
import dao.MySqlUserDAO;
import vo.User;


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
