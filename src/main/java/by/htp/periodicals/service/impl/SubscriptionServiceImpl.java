package by.htp.periodicals.service.impl;

import by.htp.periodicals.dao.SubscriptionDao;
import by.htp.periodicals.service.SubscriptionService;

public class SubscriptionServiceImpl implements SubscriptionService {
	
	private SubscriptionDao subscriptionDao;

	public void setSubscriptionDao(SubscriptionDao subscriptionDao) {
		this.subscriptionDao = subscriptionDao;
	}

}
