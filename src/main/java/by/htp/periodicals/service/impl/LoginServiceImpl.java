package by.htp.periodicals.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import by.htp.periodicals.dao.UserDao;
import by.htp.periodicals.domain.Role;
import by.htp.periodicals.domain.User;

@Service("loginService")
public class LoginServiceImpl implements UserDetailsService{
	
	@Autowired
	UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.find(username);
		if (user == null) {
			throw new UsernameNotFoundException("There is no such user");
		}
		List<GrantedAuthority> authorities = buildUserAuthority(user.getRole()); 
		 return buildUserForAuthentication(user, authorities);
	}
	
	private org.springframework.security.core.userdetails.User buildUserForAuthentication(User user, List<GrantedAuthority> authorities){
		return new org.springframework.security.core.userdetails.User(
				user.getLogin(), user.getPassword(), authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(Role role){
		List<GrantedAuthority> result = new ArrayList<>();
		result.add(new SimpleGrantedAuthority("ROLE_USER"));
		return result;
	}
	
}
