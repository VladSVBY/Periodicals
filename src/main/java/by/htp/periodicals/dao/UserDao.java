package by.htp.periodicals.dao;

import java.util.List;

import by.htp.periodicals.domain.User;

public interface UserDao extends BaseDao<User> {
	
	User findByLogin(String login);
	
	List<User> findByLoginAndPassword(String login, String password);
}
