package by.htp.periodicals.service;

import by.htp.periodicals.domain.Review;

public interface ReviewService {

	void create(Review review);
	
	void delete(int reviewId);
}
