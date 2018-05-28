package by.htp.periodicals.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import by.htp.periodicals.dao.RoleDao;
import by.htp.periodicals.dao.util.HibernateUtil;
import by.htp.periodicals.domain.Role;

@Repository
public class RoleDaoImpl implements RoleDao {

	@Override
	public Role read(int id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Role role = (Role) session.get(Role.class, id);
		session.getTransaction().commit();
		session.close();
		return role;
	}

	@Override
	public List<Role> readAll() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Role.class);
		@SuppressWarnings("unchecked")
		List<Role> roleGroup = criteria.list();
		session.close();
		return roleGroup;
	}

}
