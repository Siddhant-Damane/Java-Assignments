package com.webonise.models;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "questions")
public class Question implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4392712718828502723L;


	@Id
	@GeneratedValue
	@Column(name="ques_id")
	private long questionId;
	
	@Column(name="user_id")
	private long userId;
	
	@Column(name="question")
	private String question;

	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}

	
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
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
		return "Question [questionId=" + questionId + ", userId=" + userId + ", question=" + question + "]";
	}



}