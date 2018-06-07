package by.htp.periodicals.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import by.htp.periodicals.dao.PublicationDao;
import by.htp.periodicals.dao.util.HibernateUtil;
import by.htp.periodicals.domain.Publication;
import by.htp.periodicals.domain.Role;

@Repository
public class PublicationDaoImpl implements PublicationDao{

	@Override
	public Publication read(int id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Publication publication = (Publication) session.get(Publication.class, id);
		session.getTransaction().commit();
		session.close();
		return publication;
	}

	@Override
	public List<Publication> readAll() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Publication.class);
		@SuppressWarnings("unchecked")
		List<Publication> publicationGroup = criteria.list();
		session.close();
		return publicationGroup;
	}

}
