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

import com.webonise.models.Answers;
import com.webonise.models.Question;
import com.webonise.models.User;
import com.webonise.service.ForumService;

@Controller
public class ForumController {

	private static final Logger logger = LoggerFactory.getLogger(ForumController.class);

	@Autowired
	ForumService forumService;

	@RequestMapping("/")
	public String giveDefaultList(Model model) {

		forumService.setMap();
		model.addAttribute("map", forumService.getMap());
		model.addAttribute("loginStatus", forumService.isLogin());
		return "questionAnswersList";
	}
	
	@RequestMapping("/question")
	public ModelAndView listQuestions() {
		List<Question> questions = forumService.getAllQuestions();
		logger.info("trying to find Questions");
		return new ModelAndView("listAllQuestions", "questions", questions);
	}
		
	@RequestMapping("/question/{ques_id}")
	public ModelAndView displayQuestion(@PathVariable("ques_id") int quesId, Model model) {

		Question question = forumService.getQuestionById(quesId);
		model.addAttribute("ques_id", quesId);
		return new ModelAndView("displayQuestion", "question", question);
	}
	
	@RequestMapping("/question/{questionId}/answers")
	public ModelAndView questionAnswer(@PathVariable("questionId") long questionId, Model model) {

		List<Answers> answers = forumService.getAsnwerById(questionId);
		model.addAttribute("question",forumService.getQuestionById(questionId).getQuestion());
		return new ModelAndView("displayAnswer", "answers", answers);
	}
}