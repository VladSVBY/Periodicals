package by.htp.periodicals.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.htp.periodicals.dao.RoleDao;
import by.htp.periodicals.dao.UserDao;
import by.htp.periodicals.domain.Role;
import by.htp.periodicals.domain.User;
import by.htp.periodicals.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Override
	public boolean loginExist(String login) {
		User user = userDao.find(login);
		return user != null;
	}

	@Override
	public void registerNewUser(User user) {
		Role userRole = roleDao.read(1);
		user.setRole(userRole);
		userDao.create(user);
	}

	@Override
	public User find(String login, String password) {
		List<User> users = userDao.find(login, password);
		if (!users.isEmpty()) {
			return users.get(0);
		}
		return null;
	}
	
	@Override
	public User find(String login) {
		return userDao.find(login);
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
