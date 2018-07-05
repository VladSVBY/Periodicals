package by.htp.periodicals.service;

import java.util.List;

import by.htp.periodicals.domain.Subscription;

public interface SubscriptionService {
	
	List<Subscription> readActiveSubscriptions(int userId);
	
	List<Subscription> readNonActiveSubscriptions(int userId);

}
