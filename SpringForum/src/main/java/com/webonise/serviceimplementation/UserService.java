package com.webonise.serviceimplementation;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.sql.Statement;
import com.webonise.databaseconnector.DBUtility;
import com.webonise.models.QuestionAnswers;
import com.webonise.models.User;
import com.webonise.service.ForumService;

@Service
public class UserService implements ForumService {

	private Connection connection;
	private static final Logger logger = Logger.getLogger(UserService.class);

	public QuestionAnswers questionAnswers;

	public boolean loginStatus = false;

	public UserService() {
		logger.info("Using Database through UserServie");
		connection = DBUtility.getConnection();
		if (connection != null)
			logger.info("Database After UserService");
	}

	public boolean isLogin() {
		return this.loginStatus;
	}

	public void setmap() {
		questionAnswers = new QuestionAnswers(connection);
	}

	@Override
	public HashMap<String, ArrayList<String>> getFullMap() {
		// TODO Auto-generated method stub

		if (questionAnswers.getMap() != null) {
			return questionAnswers.getMap();
		}
		else{
			logger.info("Service is returning null ");
			return null;
		}
	}

	@Override
	public void login() {
		
		this.loginStatus = true;

	}

	@Override
	public void logout() {
		
		this.loginStatus = false;

	}



	public List<User> getAllUsers() {
		logger.info("Listing All Users");
		List<User> users = new ArrayList<User>();
		try {
			Statement statement = connection.createStatement();
			logger.info("Statement " + statement);
			int i = 0;
			ResultSet reultSet = statement.executeQuery("select * from users");
			while (reultSet.next()) {
				logger.info("i= " + i++);
				User user = new User();
				user.setUserId(reultSet.getInt("user_id"));
				user.setUserName(reultSet.getString("user_name"));				
				user.setPassword(reultSet.getString("password"));
				users.add(user);
			}
		} catch (SQLException e) {
			logger.error(e);
		}

		logger.info(users);
		return users;
	}

	public User getUserById(int userId) {
		User user = new User();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from users where user_id=?");
			preparedStatement.setInt(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				user.setUserId(resultSet.getInt("user_id"));
				user.setUserName(resultSet.getString("user_name"));
				user.setPassword(resultSet.getString("password"));
			}
		} catch (SQLException e) {
			logger.error(e);
		}
		return user;
	}

	public List<String> getAllQuestions() {
		
		List<String> questions = new ArrayList<String>();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from questions");
			while (resultSet.next()) {

				questions.add(resultSet.getString(3));
			}
		} catch (SQLException e) {
			logger.error(e);
		}

		return questions;
	}

	public String getQuestionById(int questionId) {

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from questions where ques_id=?");
			preparedStatement.setInt(1, questionId);
			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()) {

				return resultSet.getString(3);

			}else
				return null;
		} catch (SQLException e) {
			logger.error(e);
		}
		return null;

	}

	public List<String> getAsnwerById(int questionId) {
		List<String> answers = new ArrayList<String>();

		try {
			Statement statement=connection.createStatement();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from answers where ques_id=?");
			preparedStatement.setInt(1, questionId);
			ResultSet question=statement.executeQuery("select question from questions where ques_id="+questionId+"");
			if(question.next())
			{
				answers.add("Question : "+question.getString(1));
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				while (resultSet.next()) {
					answers.add(resultSet.getString(2));
				}
				return answers;

			} else
				return null;
		} catch (SQLException e) {
			logger.error(e);
		}
		return null;

	}

}
