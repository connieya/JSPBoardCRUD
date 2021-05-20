package controls;

import java.util.Map;

import dao.MySqlUserDAO;

public class UserDeleteController implements Controller {
	MySqlUserDAO userDao;
	
	public UserDeleteController setUserDao(MySqlUserDAO userDao) {
		this.userDao = userDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		Integer no = (Integer) model.get("no");
		userDao.delete(no);
		
		return "redirect:home.do";
	}

}
