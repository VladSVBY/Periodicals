package by.htp.periodicals.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.htp.periodicals.domain.User;
import by.htp.periodicals.service.UserService;
import by.htp.periodicals.web.util.HttpRequestParamValidator;
import by.htp.periodicals.web.util.ValidateNullParamException;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView main() {
		return new ModelAndView("loginpage", "user", new User());
	}
	
	@RequestMapping(value = "/login_user", method = RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute("user") User user, HttpServletRequest request, HttpSession session) {
		try {
			HttpRequestParamValidator.validateUserParams(user);
		} catch (ValidateNullParamException e) {
			request.setAttribute("fail_msg", e.getMessage());
			return new ModelAndView("loginpage", "user", user);
		}
		User currentUser = userService.findUserByLoginAndPassword(user.getLogin(), user.getPassword());
		if (currentUser == null) {
			request.setAttribute("fail_msg", "There is no such user");
			return new ModelAndView("loginpage", "user", user);
		}
		session.setAttribute("current_user", currentUser);
		return new ModelAndView("user/main");
	}

}
