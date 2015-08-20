package com.webonise.models;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="answers")
public class Answers implements Serializable {	
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = -1104332242612789528L;

	@Id
	@GeneratedValue
	@Column(name="ans_id")
	private long answerId;
	
	@Column(name="answer")
	private String answer;
	
	@Column(name="ques_id")
	private long questionId; 
	
	@Column(name="user_id")
	private long userId;

	public long getAnswerId() {
		return answerId;
	}

	public void setAnswerId(long answerId) {
		this.answerId = answerId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

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

	@Override
	public String toString() {
		return "Answers [answerId=" + answerId + ", answer=" + answer + ", questionId=" + questionId + ", userId="
				+ userId + "]";
	}


}
