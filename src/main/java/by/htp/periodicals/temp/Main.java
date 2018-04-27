package by.htp.periodicals.temp;

import by.htp.periodicals.dao.RoleDao;
import by.htp.periodicals.dao.UserDao;
import by.htp.periodicals.dao.impl.RoleDaoImpl;
import by.htp.periodicals.dao.impl.UserDaoImpl;
import by.htp.periodicals.domain.Role;
import by.htp.periodicals.domain.User;

public class Main {
	
	public static void main(String[] args) {
		Role role = new Role();
		role.setRoleName("Administrator");
		
		RoleDao roleDao = new RoleDaoImpl();
		roleDao.create(role);
		System.out.println("Generated Role_ID : " + role.getId());
		
		User user = new User();
		user.setFirstName("Vladislav");
		user.setRole(role);
		
		UserDao userDao = new UserDaoImpl();
		userDao.create(user);
		System.out.println("Generated User_ID : " + user.getId());
		
		user.setLastName("Sevashko");
		userDao.update(user);
		User user2 = userDao.read(1);
		System.out.println(user2);
	}

}
