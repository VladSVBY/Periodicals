package by.htp.periodicals.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import by.htp.periodicals.dao.UserDao;
import by.htp.periodicals.domain.User;
import by.htp.periodicals.service.UserService;
import by.htp.periodicals.web.util.HttpRequestParamValidator;
import by.htp.periodicals.web.util.ValidateNullParamException;

@Controller
@RequestMapping(value = "/registration")
public class RegistrationController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView main() {
		return new ModelAndView("registerpage", "user", new User());
	}
	
	@RequestMapping(value = "/register_user", method = RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute("user") User user, HttpServletRequest request) {
		try {
			HttpRequestParamValidator.validateUserParams(user);
		} catch (ValidateNullParamException e) {
			request.setAttribute("fail_msg", e.getMessage());
			return new ModelAndView("registerpage", "user", user);
		}
		if (userService.loginExist(user.getLogin())) {
			request.setAttribute("fail_msg", "User with your login already exist");
			return new ModelAndView("registerpage", "user", user); 
		}
		userService.registerNewUser(user);
		return new ModelAndView("loginpage");
	}
	
	@RequestMapping(value = "/check_login", method = RequestMethod.GET)
	public @ResponseBody String checkLogin(@RequestParam("login") String login) {
		if (userService.loginExist(login)) {
			return "Login already exists!";
		}
		return "Login is free!";
	}
	
	@RequestMapping(value = "/ckeck_password", method = RequestMethod.GET)
	public @ResponseBody String checkPassword() {
		return "hello";
	}
	
}
