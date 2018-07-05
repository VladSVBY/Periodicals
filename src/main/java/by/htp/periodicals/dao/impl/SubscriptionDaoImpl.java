package by.htp.periodicals.dao.impl;

import static by.htp.periodicals.dao.util.ColumnNameDecloration.*;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import by.htp.periodicals.dao.SubscriptionDao;
import by.htp.periodicals.dao.util.HibernateUtil;
import by.htp.periodicals.domain.Subscription;
import by.htp.periodicals.domain.SubscriptionStatus;

@Repository
public class SubscriptionDaoImpl implements SubscriptionDao {

	@Override
	public Subscription read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Subscription> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Subscription> readActive(int userId) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Subscription.class);
		criteria.add(Restrictions.eq(SUBSCRIPTION_PROPERTY_USER_ID, userId));
		criteria.add(Restrictions.eq(SUBSCRIPTION_PROPERTY_STATUS, SubscriptionStatus.ACTIVE));
		@SuppressWarnings("unchecked")
		List<Subscription> subscriptions = criteria.list();
		session.close();
		return subscriptions;
	}

	@Override
	public List<Subscription> readAllForUser(int userId) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Subscription.class);
		criteria.add(Restrictions.eq(SUBSCRIPTION_PROPERTY_USER_ID, userId));
		@SuppressWarnings("unchecked")
		List<Subscription> subscriptions = criteria.list();
		session.close();
		return subscriptions;
	}

}
