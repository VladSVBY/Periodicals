package by.htp.periodicals.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.htp.periodicals.service.ReviewService;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	
	private static final Logger logger = Logger.getLogger(AdminController.class);
	
	private static final String REQUEST_HEADER_REFERER = "referer";
	
	@Autowired
	private ReviewService reviewService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String editPublications() {
		return "";
	}
	
	@RequestMapping(value = "delete-review/{id}", method = RequestMethod.DELETE)
	public void deleteReview(@PathVariable int id, HttpServletRequest request, HttpServletResponse response) {
		reviewService.delete(id);
		String refererPage = request.getHeader(REQUEST_HEADER_REFERER);
		try {
			response.sendRedirect(refererPage);
		} catch (IOException e) {
			logger.error(e);
		}
	}

}
