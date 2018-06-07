package by.htp.periodicals.web.controller;

import static by.htp.periodicals.util.WebConstantDecloration.*;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	
	@RequestMapping(value = "user/main", method = RequestMethod.GET)
	ModelAndView main(Principal principal) {
		ModelAndView modelAndView = new ModelAndView(VIEW_USER_MAIN);
		modelAndView.addObject("user", principal.getName());
		return modelAndView;
	}

}
