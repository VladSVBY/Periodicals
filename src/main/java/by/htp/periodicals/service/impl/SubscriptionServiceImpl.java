package by.htp.periodicals.service.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.htp.periodicals.dao.SubscriptionDao;
import by.htp.periodicals.domain.Subscription;
import by.htp.periodicals.domain.SubscriptionStatus;
import by.htp.periodicals.service.SubscriptionService;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
	
	@Autowired
	private SubscriptionDao subscriptionDao;

	@Override
	public List<Subscription> readActiveSubscriptions(int userId) {
		List<Subscription> subscriptions = subscriptionDao.readActive(userId);
		Date currentDate = new Date();
		Iterator<Subscription> iterator = subscriptions.iterator();
		while (iterator.hasNext()) {
			Subscription subscription = iterator.next();
			Date dateOfExpiration = subscription.getEndDate();
			if (dateOfExpiration.before(currentDate)) {
				subscription.setStatus(SubscriptionStatus.EXPIRED);
				subscriptionDao.update(subscription);
				iterator.remove();
			}
		}
		return subscriptions;
	}

	@Override
	public List<Subscription> readNonActiveSubscriptions(int userId) {
		List<Subscription> subscriptions = subscriptionDao.readAllForUser(userId);
		Date currentDate = new Date();
		Iterator<Subscription> iterator = subscriptions.iterator();
		while (iterator.hasNext()) {
			Subscription subscription = iterator.next();
			if (SubscriptionStatus.ACTIVE.equals(subscription.getStatus())) {
				Date dateOfExpiration = subscription.getEndDate();
				if (dateOfExpiration.before(currentDate)) {
					subscription.setStatus(SubscriptionStatus.EXPIRED);
					subscriptionDao.update(subscription);
				} else {
					iterator.remove();
				}
			}
		}
		return subscriptions;
	}

}
