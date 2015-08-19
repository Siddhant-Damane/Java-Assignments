package com.webonise.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.webonise.models.User;

public interface ForumService {

	public HashMap<String, ArrayList<String>> getFullMap();
	public void setmap() ;
	public void login();
	public void logout();
	public boolean isLogin();
	public List<User> getAllUsers();
	public List<String> getAllQuestions();
	public String getQuestionById(int questionId);
	public User getUserById(int userid);
	public List<String> getAsnwerById(int questionId);

}

