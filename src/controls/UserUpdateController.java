package controls;

import java.util.Map;

import user.User;
import user.UserDAO;

public class UserUpdateController implements Controller {

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		UserDAO userDAO = (UserDAO) model.get("user");

		if (model.get("userUpdate") == null) {
			Integer no = (Integer) model.get("no");
			User user = userDAO.userDetail(no);
			model.put("user", user);
			return "/user/UserForm.jsp";
		} else {
			User user = (User) model.get("userUpdate");
			userDAO.update(user);
			return "redirect:home.do";
		}
	}

}
