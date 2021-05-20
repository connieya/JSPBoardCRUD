package controls;

import java.util.Map;

import bind.DataBinding;
import dao.MySqlUserDAO;
import dao.UserDao;
import vo.User;


public class UserUpdateController implements Controller ,DataBinding {
	UserDao userDao;
	
	public UserUpdateController setUserDao(UserDao userDao) {
		this.userDao = userDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		User user = (User) model.get("user");

		if (user.getEmail() == null) {
			Integer no = (Integer) model.get("no");
			User detailInfo = userDao.userDetail(no);
			return "/user/UserForm.jsp";
		} else {
			userDao.update(user);
			return "redirect:home.do";
		}
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"no", Integer.class,
				"user" , vo.User.class
		};
	}

}
