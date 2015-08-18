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
@RequestMapping("/service/answer")

public class ForumAnswerController {
	
	
	UserService userService=new UserService();
	
	@ResponseBody
	@RequestMapping(value = "/question/{ques_id}", method = RequestMethod.GET,headers="Accept=application/json")
	public List<String> getQuestion(@PathVariable("ques_id") int quesId) 
	{
		System.out.println("called");
		List<String> answer=userService.getAsnwerById(quesId);
		return answer;
	}
}
