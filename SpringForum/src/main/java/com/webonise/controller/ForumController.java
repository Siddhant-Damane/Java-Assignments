package com.webonise.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		model.addAttribute("question", new Question());
		model.addAttribute("loginStatus", forumService.isLogin());
		return "questionAnswersList";
	}

	@RequestMapping(value = "/addQuestion", method = RequestMethod.POST)
	public String addQuestion(@ModelAttribute("question") Question question, Model model,
			RedirectAttributes attribute) {

		String msg = "";
		if (question.getQuestion().equals("")) {
			msg = "Please fill the Question";
			attribute.addFlashAttribute("msg", msg);
			return "redirect:/";
		} else {
			forumService.addQuestion(question);
		}
		return "redirect:/";
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

		List<Answers> answersList = forumService.getAsnwerById(questionId);
		model.addAttribute("question", forumService.getQuestionById(questionId).getQuestion());
		model.addAttribute("answer", new Answers());
		model.addAttribute("questionId", questionId);
		return new ModelAndView("displayAnswer", "answers", answersList);
	}

	@RequestMapping(value = "/question/{questionId}/answers/addAnswer", method = RequestMethod.POST)
	public String addAnswer(@PathVariable("questionId") long questionId, @ModelAttribute("answer") Answers answer,
			Model model, RedirectAttributes attribute) {

		String msg = "";
		if (answer.getAnswer().equals("")) {
			msg = "Please fill the Answer";
			attribute.addFlashAttribute("msg", msg);
			return "redirect:/question/{questionId}/answers";
		} else {
			forumService.addAnswer(answer, questionId);
		}
		return "redirect:/question/{questionId}/answers";
	}

	/*
	 * @RequestMapping(value= "/searchQuestion", method = RequestMethod.POST)
	 * public String searchQuestion(@ModelAttribute("question") Question
	 * question, Model model, RedirectAttributes attribute){
	 * 
	 * String msg=""; if(question.getQuestion().equals("")) { msg =
	 * "Please fill the Question"; attribute.addFlashAttribute("msg", msg);
	 * return "redirect:/"; } else { List<Question> questions=
	 * forumService.searchQuestion(question);
	 * model.addAttribute("question",questions); } return "searchedQuestion"; }
	 */
}