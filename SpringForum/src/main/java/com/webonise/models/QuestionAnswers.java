package com.webonise.models;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;

import com.webonise.databaseconnector.DBUtility;

import java.sql.Connection;

public class QuestionAnswers implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1873710719374784211L;
	private static final Logger logger = Logger.getLogger(QuestionAnswers.class);
	/**
	 * 
	 */

	public ArrayList<String> questionAnswers;
	public HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

	public HashMap<String, ArrayList<String>> getMap() {
		return map;
	}

	public QuestionAnswers(Connection connection) {

		try {
			Statement statementQuestion = connection.createStatement();
			Statement statementAnswer = connection.createStatement();
			int questionId;
			ResultSet questionSet = statementQuestion.executeQuery("select * from questions");
			while (questionSet.next()){
				questionId = questionSet.getInt(1);
				ResultSet answerSet = statementAnswer
						.executeQuery("Select * from answers where ques_id=" + questionId + "");
				questionAnswers = new ArrayList<String>();
				if (answerSet != null) {
					while (answerSet.next()) {
						questionAnswers.add(answerSet.getString(2));
					}
				}
				else{
					logger.info("Sorry, No Answer is present for id ");		
				}
				map.put(questionSet.getString(3), questionAnswers);
				logger.info("list is " + questionAnswers);
			}
		} catch (Exception e) {
			logger.error(e);
		}

	}

}
