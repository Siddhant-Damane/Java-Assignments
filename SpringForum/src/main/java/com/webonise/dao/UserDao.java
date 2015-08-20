package com.webonise.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webonise.models.Answers;
import com.webonise.models.User;

@Repository
public interface UserDao extends JpaRepository<User, Long>,ForumDao {	
	
	User findByUserId(long userId);
	
}
