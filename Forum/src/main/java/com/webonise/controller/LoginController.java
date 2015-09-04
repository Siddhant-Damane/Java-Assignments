package com.webonise.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.webonise.models.Users;
import com.webonise.service.LoginService;

@Controller
public class LoginController {

	private static final Logger logger = Logger.getLogger(LoginController.class);

	@Autowired
	private LoginService loginService;

	private static Users dummyUser = new Users();

	@RequestMapping("/login")
	public ModelAndView getLoginForm(@ModelAttribute Users users,
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		String message = "";
		if (error != null) {
			message = "Incorrect username or password !";
		} else if (logout != null) {
			message = "Logout successful !";
			return new ModelAndView("redirect: /");
		}
		return new ModelAndView("login", "message", message);
	}

	@RequestMapping(value = "/signupprocess", method = RequestMethod.POST)
	public String singUpProcess(@ModelAttribute("user") Users user, Model model) {

		try {
			loginService.registerUser(user);
		} catch (Exception e) {

			logger.info("Exception is " + e.getMessage());
			return "redirect:/signup?error";
		}
		return "redirect:/?signup";
	}

	@RequestMapping("/signup")
	public String getUser(Model model, @RequestParam(value = "error", required = false) String error) {

		String message = "";
		if (error != null) {
			message = "User name already exits, please choose other user name!";
		}

		model.addAttribute("message", message);
		model.addAttribute("user", dummyUser);
		return "signup";
	}

	@RequestMapping("/403")
	public String getAccessDenied(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = "";
		if (!(auth instanceof AnonymousAuthenticationToken) && auth != null) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			username = userDetail.getUsername();
		}

		else {
			return "redirect:/";
		}

		model.addAttribute("userName", username);
		return "403";
	}
}
