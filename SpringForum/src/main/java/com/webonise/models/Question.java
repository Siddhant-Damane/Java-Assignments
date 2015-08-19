package com.webonise.models;

import java.io.Serializable;
import java.util.Set;

public class Question implements Serializable{

	/**
	 * 
	 */
	
	private int questionId;
	private int userId;
	private String question;
	private Set<Answer> answers;
	
	public Set<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", userId=" + userId + ", question=" + question + ", anwsers="
				+ answers + "]";
	}
}
