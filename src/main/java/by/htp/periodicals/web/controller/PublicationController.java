package by.htp.periodicals.web.controller;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.htp.periodicals.domain.Publication;
import by.htp.periodicals.domain.Review;
import by.htp.periodicals.domain.User;
import by.htp.periodicals.service.PublicationService;
import by.htp.periodicals.service.ReviewService;
import by.htp.periodicals.service.UserService;
import by.htp.periodicals.service.impl.PublicationServiceImpl;

@Controller
public class PublicationController {
	
	@Autowired
	 private PublicationService publicationService;
	
	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main(HttpServletRequest request) {
		request.setAttribute("publication_group", publicationService.readAll());
		return "index";
	}

	@RequestMapping(value = "publication/{id}", method = RequestMethod.GET)
	public ModelAndView showPublication(@PathVariable("id") int id) {
		ModelAndView modelAndView = new ModelAndView("publicationpage");
		Publication publication = publicationService.read(id);
		modelAndView.addObject("publication", publication);
		modelAndView.addObject("review", new Review());
		return modelAndView;
	}
	
	@RequestMapping(value = "publication/{publicationId}/add_review", method = RequestMethod.POST)
	public void addReview(@ModelAttribute("review") Review review, @PathVariable("publicationId") int publicationId, HttpServletResponse response, HttpSession session, Principal principal, HttpServletRequest request) {
		Publication publication = publicationService.read(publicationId);
		User user = userService.find(principal.getName());
		review.setUser(user);
		review.setPublication(publication);
		reviewService.create(review);
		try {
			response.sendRedirect(request.getHeader("referer"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
