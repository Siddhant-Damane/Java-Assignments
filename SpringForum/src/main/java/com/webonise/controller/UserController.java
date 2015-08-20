package com.webonise.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.webonise.models.User;
import com.webonise.service.ForumService;

@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(ForumController.class);
	
	@Autowired
	ForumService forumService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, @RequestParam("userName") String userName) {

		forumService.login();
		model.addAttribute("map", forumService.getMap());
		model.addAttribute("loginStatus", forumService.isLogin());
		model.addAttribute("user", userName);
		return "questionAnswersList";
	}

	@RequestMapping("/logout")
	public String logout(Model model) {

		forumService.logout();
		model.addAttribute("map", forumService.getMap());
		model.addAttribute("loginStatus", forumService.isLogin());
		return "questionAnswersList";
	}
	
	@RequestMapping("/user")
	public ModelAndView listUsers() {

		List<User> users = forumService.getAllUsers();
		return new ModelAndView("listAllUsers", "users", users);
	}

	@RequestMapping("/user/{userid}")
	public ModelAndView dispUser(@PathVariable("userid") int userid) {

		User user = forumService.getUserById(userid);
		return new ModelAndView("displayUser", "user", user);
	}
}
