package dao;

import vo.User;

public interface UserDao {
	int next() throws Exception;
	User login(String id, String password) throws Exception;
	int join(User user) throws Exception;
	int update(User user) throws Exception;
	User userDetail(int no) throws Exception;
	int delete(int no) throws Exception;
	

}
