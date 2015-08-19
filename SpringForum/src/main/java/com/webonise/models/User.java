package com.webonise.models;

import java.io.Serializable;
import java.util.Set;


public class User implements Serializable{

	/**
	 * 
	 */
	/**
	 * 
	 */
	private int userId;
	private String userName;
	private String password;
	private Set<Question> questions;
	private Set<Answer> answers;
		
	public Set<Question> getQuestions() {
		return questions;
	}


	public Set<Answer> getAnswers() {
		return answers;
	}


	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}


	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userid=" + userId + ", Name=" + userName
				+ ", password="
				+ password + "]";
	}		
}

