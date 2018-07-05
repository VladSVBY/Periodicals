package by.htp.periodicals.web.controller;

import static by.htp.periodicals.util.WebConstantDecloration.*;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.htp.periodicals.domain.Subscription;
import by.htp.periodicals.domain.User;
import by.htp.periodicals.service.SubscriptionService;
import by.htp.periodicals.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SubscriptionService subscriptionService;
	
	@RequestMapping(value = "user/profile", method = RequestMethod.GET)
	ModelAndView main(Principal principal) {
		ModelAndView modelAndView = new ModelAndView(VIEW_USER_PROFILE);
		String login = principal.getName();
		modelAndView.addObject(MODEL_ATTR_USER, userService.find(login));
		return modelAndView;
	}
	
	@RequestMapping(value = "user/subscriptions", method = RequestMethod.GET)
	ModelAndView showSubscriptions(Principal principal) {
		ModelAndView modelAndView = new ModelAndView(VIEW_USER_SUBSCRIPTIONS);
		String login = principal.getName();
		User user = userService.find(login);
		List<Subscription> subscriptions = subscriptionService.readActiveSubscriptions(user.getId());
		modelAndView.addObject(MODEL_ATTR_ACTIVE_SUBSCRIPTIONS, subscriptions);
		return modelAndView;
	}
	
	@RequestMapping(value = "user/subscription-history", method = RequestMethod.GET)
	ModelAndView showSubscriptionHistory(Principal principal) {
		ModelAndView modelAndView = new ModelAndView(VIEW_USER_SUBSCRIPTION_HISTORY);
		String login = principal.getName();
		User user = userService.find(login);
		List<Subscription> subscriptions = subscriptionService.readNonActiveSubscriptions(user.getId());
		modelAndView.addObject(MODEL_ATTR_NONACTIVE_SUBSCRIPTIONS, subscriptions);
		return modelAndView;
	}
	
	@RequestMapping(value = "user/prepare_subscription/{publicationId}", method = RequestMethod.GET)
	String prepareSubscription(@PathVariable int publicationId, HttpServletRequest request) {
		request.setAttribute(REQUEST_PARAM_PUBLICATION_ID, publicationId);
		return VIEW_SUBSCRIPTION;
	}

}
