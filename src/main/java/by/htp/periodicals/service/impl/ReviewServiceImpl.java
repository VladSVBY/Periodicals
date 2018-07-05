package by.htp.periodicals.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.htp.periodicals.dao.ReviewDao;
import by.htp.periodicals.domain.Review;
import by.htp.periodicals.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	ReviewDao reviewDao;
	
	@Override
	public void create(Review review) {
		review.setDate(new Date());
		reviewDao.create(review);
	}

	@Override
	public void delete(int reviewId) {
		reviewDao.delete(reviewId);		
	}

}
