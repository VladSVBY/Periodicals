package by.htp.periodicals.web.controller;

import static by.htp.periodicals.util.WebConstantDecloration.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import by.htp.periodicals.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	UserService userService;

	@RequestMapping(value = "/login")
	public ModelAndView login(@RequestParam(value = "error", required = false) String error) {
		ModelAndView modelAndView = new ModelAndView(VIEW_LOGIN);
		if (error != null) {
			modelAndView.addObject("error_msg", "Invalid username or password");
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/accessDenied")
	public ModelAndView loginag() {
		return new ModelAndView("login");
	}
}
