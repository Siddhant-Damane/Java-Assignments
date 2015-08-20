package com.webonise.serviceimplementation;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webonise.dao.AnswerDao;
import com.webonise.dao.QuestionDao;
import com.webonise.dao.UserDao;
import com.webonise.models.Answers;
import com.webonise.models.Question;
import com.webonise.models.User;
import com.webonise.service.ForumService;

@Service
public class ForumServiceImplementation implements ForumService {

	@Autowired
	private QuestionDao questionDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private AnswerDao answerDao;

	@Override
	public HashMap<Question, List<Answers>> getMap() {

		HashMap<Question, List<Answers>> map = new HashMap<Question, List<Answers>>();

		List<Question> questionList = questionDao.findAll();

		for (Question question : questionList) {
			List<Answers> answers = answerDao.findByQuestionId(question.getQuestionId());
			map.put(question, answers);

		}
		return map;
	}

	@Transactional
	public HashMap<Question, List<Answers>> getAll() {
		return null;

	}

	@Override
	public void login() {

	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isLogin() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<String> getAsnwerById(int quesId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Question getQuestionById(long quesId) {

		Question question = questionDao.findByQuestionId(quesId);
		return question;
	}

	@Override
	public List<Question> getAllQuestions() {

		List<Question> list = questionDao.findAll();

		return list;

	}

	@Override
	public User getUserById(long userId) {

		User user = userDao.findByUserId(userId);
		return user;
	}

	@Override
	public List<Answers> getAsnwerById(long questionId) {

		List<Answers> answers = answerDao.findByQuestionId(questionId);
		return answers;
	}

	@Override
	public List<User> getAllUsers() {

		List<User> list = userDao.findAll();

		return list;
	}

	@Override
	public void setMap() {

	}

	@Override
	public void addQuestion(Question question) {
		// TODO Auto-generated method stub
		if (question.getUserId() == 0) {
			question.setUserId(1);

		}
		questionDao.saveAndFlush(question);

	}

	public void addAnswer(Answers answer, long questionId) {
		if (answer.getUserId() == 0) {
			answer.setUserId(1);

		}
		answer.setQuestionId(questionId);
		answerDao.saveAndFlush(answer);
	}

	public List<Question> searchQuestion(Question question) {

		List<Question> questions = questionDao.search(question.getQuestion());

		return questions;

	}
}
