package com.webonise.controller;



import java.util.List;
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

public class ForumController {
	
	@Autowired
	ForumService forumService;

	@RequestMapping("/")
	public String giveDefaultList(Model model) {

		forumService.setmap();
		model.addAttribute("map", forumService.getFullMap());
		model.addAttribute("loginStatus", forumService.isLogin());
		return "questionAnswersList";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, @RequestParam("userName") String userName) {

		forumService.login();

		model.addAttribute("map", forumService.getFullMap());
		model.addAttribute("loginStatus", forumService.isLogin());

		model.addAttribute("user", userName);

		return "questionAnswersList";
	}

	@RequestMapping("/logout")
	public String logout(Model model) {

		forumService.logout();
		model.addAttribute("map", forumService.getFullMap());
		model.addAttribute("loginStatus", forumService.isLogin());
		return "questionAnswersList";
	}

	@RequestMapping("/users")
	public ModelAndView listUsers() {
		List<User> users=forumService.getAllUsers();
		return new ModelAndView("listUsers", "users", users);
	}
		
	
	@RequestMapping("/questions")
	public ModelAndView listQuestions() {
		List<String> questions=forumService.getAllQuestions();		
		return new ModelAndView("listQuestions", "questions", questions);
	}
	
	@RequestMapping("/questions/{questionId}")
	public ModelAndView displayQuestion(@PathVariable("questionId") int questionId,Model model) {
		String question=forumService.getQuestionById(questionId);
		model.addAttribute("questionId",questionId);
		return new ModelAndView("displayQuestion", "question", question);
	}

	@RequestMapping("/users/{userId}")
	public ModelAndView dispUser(@PathVariable("userId") int userId) {
		User user=forumService.getUserById(userId);	
		return new ModelAndView("displayUser", "user", user);
	}
	
	@RequestMapping("/questions/{questionId}/answers")
	public ModelAndView questionAnswer(@PathVariable("questionId") int questionId) {
		List<String> answers=forumService.getAsnwerById(questionId);
		return new ModelAndView("displayAnswer", "answers", answers);
	}

}