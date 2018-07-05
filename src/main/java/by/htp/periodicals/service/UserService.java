package by.htp.periodicals.service;

import by.htp.periodicals.domain.User;

public interface UserService { 
	
	public boolean loginExist(String login);
	
	public void registerNewUser(User user);
	
	public User find(String login, String password);
	
	public User find(String login);

}
