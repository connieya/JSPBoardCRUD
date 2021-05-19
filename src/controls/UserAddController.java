package controls;

import java.util.Map;

import user.User;
import user.UserDAO;

public class UserAddController implements Controller {

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		if(model.get("user") == null) {
			return "/user/UserForm.jsp";
		}else {
			User user = (User) model.get("user");
			UserDAO userDao =  (UserDAO) model.get("userDao");
			userDao.join(user);
			
			return "redirect:home.do";
		}
	}

}
