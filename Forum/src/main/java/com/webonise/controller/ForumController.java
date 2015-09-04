package com.webonise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.webonise.models.Answers;
import com.webonise.models.Question;
import com.webonise.service.QuestionService;

@Controller
public class ForumController {

	@Autowired
	private QuestionService questionService;
	
	private static Question dummyQuestion= new Question();
	
	private static Answers dummyAnswer = new Answers();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String displayHomePage(Model model, @RequestParam(value = "signup", required = false) String signup) {

		
		String message = "" ;
		if (signup != null) {
			message = "Signup Successfully please login to continue !";
		}
		model.addAttribute("message",message);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userName = authentication.getName();
		model.addAttribute("userName", userName);
		model.addAttribute("question", dummyQuestion);
		model.addAttribute("answer", dummyAnswer);

		model.addAttribute("listOfQuestionAnswer", questionService.getCacheQuestions());

		return "index";
	}
}