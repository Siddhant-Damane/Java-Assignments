package com.webonise.models;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import java.sql.Connection;

public class QuestionAnswers implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1873710719374784211L;
	/**
	 * 
	 */

	public ArrayList<String> Qans;
	public HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

	public HashMap<String, ArrayList<String>> getMap() {
		return map;
	}

	public QuestionAnswers(Connection connection) {
		
		

		try {
			Statement statementQuestion = connection.createStatement();
			Statement statementAnswer = connection.createStatement();
		
			int quesId;
			ResultSet questionSet = statementQuestion.executeQuery("select * from questions");
			while (questionSet.next()) {
				
				
				quesId = questionSet.getInt(1);
				
				ResultSet answerSet = statementAnswer.executeQuery("Select * from answers where ques_id=" + quesId + "");
				Qans = new ArrayList<String>();
				if (answerSet != null) {
					while (answerSet.next()) {
						Qans.add(answerSet.getString(2));
						
					}
					
				}
				else
				{
					System.out.println("Sorry, No Answer is present for id ");
					//Qans.add("");
				}
				
				map.put(questionSet.getString(3),Qans);
				
				System.out.println("list is " + Qans);
				
				
				
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
}
