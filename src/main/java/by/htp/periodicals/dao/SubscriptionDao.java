package by.htp.periodicals.dao;

import java.util.List;

import by.htp.periodicals.domain.Subscription;

public interface SubscriptionDao extends BaseDao<Subscription> {
	
	List<Subscription> readActive(int userId);
	
	List<Subscription> readAllForUser(int userId);

}
