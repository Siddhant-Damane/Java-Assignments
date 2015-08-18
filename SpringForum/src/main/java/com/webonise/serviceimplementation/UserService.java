package com.webonise.serviceimplementation;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ListIterator;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.sql.Statement;
import java.text.ParseException;

import com.webonise.databaseconnector.DBUtility;
import com.webonise.models.QuestionAnswers;
import com.webonise.models.User;
import com.webonise.service.ForumService;

@Service
public class UserService implements ForumService {

	private Connection connection;

	public QuestionAnswers questionAnswers;

	public boolean loginStatus = false;

	public UserService() {
		System.out.println("db from user service");
		connection = DBUtility.getConnection();
		if (connection != null)
			System.out.println("db afteruser service");
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

		else {

			System.out.println("Service is returning null ");
			return null;
		}
	}

	@Override
	public void login() {
		// TODO Auto-generated method stub
		this.loginStatus = true;

	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub
		this.loginStatus = false;

	}

	public int getUserCount() {
		int count = 0;// TODO Auto-generated method stub
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select count(*) as count from tblUser");
			while (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public void addUser(User user) {
		try {

			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into tblUser(userid,firstname,lastname,email) values (?,?, ?, ? )");
			// Parameters start with 1
			preparedStatement.setInt(1, user.getUserid());
			preparedStatement.setString(2, user.getFirstName());
			preparedStatement.setString(3, user.getLastName());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteUser(int userId) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from tblUser where userid=?");
			// Parameters start with 1
			preparedStatement.setInt(1, userId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateUser(User user) throws ParseException {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update tblUser set lastname=?,email=?" + "where userid=?");
			// Parameters start with 1
			preparedStatement.setString(1, user.getLastName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setInt(3, user.getUserid());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<User> getAllUsers() {
		System.out.println("get All");
		List<User> users = new ArrayList<User>();
		try {
			Statement statement = connection.createStatement();

			System.out.println("stamt " + statement);
			int i = 0;
			ResultSet rs = statement.executeQuery("select * from tblUser");
			while (rs.next()) {
				System.out.println("i= " + i++);
				User user = new User();
				user.setUserid(rs.getInt("userid"));
				user.setFirstName(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));
				user.setEmail(rs.getString("email"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println(users);
		return users;
	}

	public User getUserById(int userId) {
		User user = new User();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from tblUser where userid=?");
			preparedStatement.setInt(1, userId);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				user.setUserid(rs.getInt("userid"));
				user.setFirstName(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));

				user.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public List<String> getAllQuestions() {
		// TODO Auto-generated method stub

		List<String> questions = new ArrayList<String>();
		try {
			Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery("select * from questions");
			while (rs.next()) {

				questions.add(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return questions;
	}

	public String getQuestionById(int ques_id) {

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from questions where ques_id=?");
			preparedStatement.setInt(1, ques_id);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {

				return rs.getString(3);

			} else
				return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public List<String> getAsnwerById(int quesId) {
		List<String> answers = new ArrayList<String>();

		try {
			Statement statement=connection.createStatement();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from answers where ques_id=?");
			preparedStatement.setInt(1, quesId);
			ResultSet question=statement.executeQuery("select question from questions where ques_id="+quesId+"");
			if(question.next())
			{
				answers.add("Question : "+question.getString(1));
			}
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				while (rs.next()) {
					answers.add(rs.getString(2));

				}
				return answers;

			} else
				return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

}
