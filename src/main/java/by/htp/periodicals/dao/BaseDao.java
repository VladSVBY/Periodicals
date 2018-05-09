package by.htp.periodicals.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import by.htp.periodicals.dao.util.HibernateUtil;
import by.htp.periodicals.domain.BaseEntity;

public interface BaseDao<T extends BaseEntity> {

	default void create(T entity) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(entity);
		session.getTransaction().commit();
		session.close();
	}
	
	T read(int id);
	
	List<T> readAll();
	
	default void update(T entity) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.update(entity);
		session.getTransaction().commit();
		session.close();
	}
	
	default void delete(int id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		T entity = read(id);
		session.delete(entity);
		session.getTransaction().commit();
		session.close();
	}
}
