package by.htp.periodicals.dao;

import java.util.List;

import by.htp.periodicals.domain.User;

public interface UserDao extends BaseDao<User> {
	
	User find(String login);
	
	List<User> find(String login, String password);
}
