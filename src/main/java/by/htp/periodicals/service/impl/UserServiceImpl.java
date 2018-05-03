package by.htp.periodicals.service.impl;

import by.htp.periodicals.dao.UserDao;
import by.htp.periodicals.service.UserService;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	

}
