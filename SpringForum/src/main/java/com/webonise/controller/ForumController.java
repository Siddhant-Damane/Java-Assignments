package com.webonise.controller;

import java.util.LinkedHashMap;
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
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.webonise.models.User;
import com.webonise.service.ForumService;

@Controller

public class ForumController {

	private static final Logger logger = LoggerFactory.getLogger(ForumController.class);

	@Autowired
	ForumService forumservice;

	@RequestMapping("/")
	public String giveDefaultList(Model model) {
		System.out.println("1");
		forumservice.setmap();
		System.out.println("2");
		model.addAttribute("map", forumservice.getFullMap());
		model.addAttribute("loginStatus", forumservice.isLogin());

		return "QuestionAnswersList";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, @RequestParam("userName") String userName) {

		forumservice.login();

		model.addAttribute("map", forumservice.getFullMap());
		model.addAttribute("loginStatus", forumservice.isLogin());

		model.addAttribute("user", userName);

		return "QuestionAnswersList";
	}

	@RequestMapping("/logout")
	public String logout(Model model) {

		forumservice.logout();

		model.addAttribute("map", forumservice.getFullMap());
		model.addAttribute("loginStatus", forumservice.isLogin());

		return "QuestionAnswersList";
	}

	@RequestMapping("/listUsers")
	public ModelAndView listUsers() {
		System.out.println("listing user");
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:7000/forum/service/user/";
		
		List<LinkedHashMap> users = restTemplate.getForObject(url, List.class);
		
		System.out.println(users);
		return new ModelAndView("listUsers", "users", users);
	}
	
	
	
	@RequestMapping("/listQuestions")
	public ModelAndView listQuestions() {
		System.out.println("listing Questions");
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:7000/forum/service/question/";
		
		List<LinkedHashMap> questions = restTemplate.getForObject(url, List.class);			
		return new ModelAndView("listQuestions", "questions", questions);
	}
	
	@RequestMapping("/displayQuestion/{ques_id}")
	public ModelAndView displayQuestion(@PathVariable("ques_id") int ques_id,Model model) {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:7000/forum/service/question/{ques_id}";
		String question = restTemplate.getForObject(url, String.class, ques_id);
		model.addAttribute("ques_id",ques_id);
		return new ModelAndView("displayQuestion", "question", question);
	}

	@RequestMapping("/dispUser/{userid}")
	public ModelAndView dispUser(@PathVariable("userid") int userid) {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:7000/forum/service/user/{userid}";
		User user = restTemplate.getForObject(url, User.class, userid);		
		return new ModelAndView("dispUser", "user", user);
	}
	
	@RequestMapping("/question/{ques_id}/answers")
	public ModelAndView questionAnswer(@PathVariable("ques_id") int ques_id) {
		System.out.println("entered");
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:7000/forum/service/answer/question/{ques_id}";
		List<String> answers = restTemplate.getForObject(url, List.class, ques_id);		
		return new ModelAndView("displayAnswer", "answers", answers);
	}

}