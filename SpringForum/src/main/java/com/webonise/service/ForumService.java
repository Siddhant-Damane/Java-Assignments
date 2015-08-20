package com.webonise.service;


import java.util.HashMap;
import java.util.List;

import com.webonise.models.Answers;
import com.webonise.models.Question;
import com.webonise.models.User;

public interface ForumService {

	
	public void setMap();

	public void login();

	public void logout();

	public boolean isLogin();

	public List<String> getAsnwerById(int quesId);

	public Question getQuestionById(long questionId);

	public List<Question> getAllQuestions();

	public User getUserById(long id);

	public List<User> getAllUsers();

	public HashMap<Question, List<Answers>> getMap();

	public List<Answers> getAsnwerById(long questionId);
}
