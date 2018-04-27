package by.htp.periodicals.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import by.htp.periodicals.dao.HibernateUtil;
import by.htp.periodicals.dao.UserDao;
import by.htp.periodicals.domain.User;

public class UserDaoImpl implements UserDao {

	@Override
	public User read(int id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		User user = (User) session.get(User.class, id);
		session.getTransaction().commit();
		session.close();
		return user;
	}

	@Override
	public List<User> readAll() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		@SuppressWarnings("unchecked")
		List<User> userGroup = criteria.list();
		session.close();
		return userGroup;
	}

}
