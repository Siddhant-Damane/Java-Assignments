package com.webonise.controller;

import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.webonise.models.User;
import com.webonise.serviceimplementation.UserService;


@Controller
@RequestMapping("/service/question/")

public class ForumQuestionController {
	
	
	UserService userService=new UserService();
	
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET,headers="Accept=application/json")
	public String getQuestion(@PathVariable int id) {
		String question=userService.getQuestionById(id);
		return question;
	}

	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET,headers="Accept=application/json")
	public List<String> getAllQuestions() {
		List<String> questions=userService.getAllQuestions();
		return questions;
	}
	
}
