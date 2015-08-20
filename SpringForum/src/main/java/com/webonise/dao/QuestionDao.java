package com.webonise.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webonise.models.Answers;
import com.webonise.models.Question;
import com.webonise.models.User;

@Repository
public interface QuestionDao extends JpaRepository<Question, Long>, ForumDao {

	Question findByQuestionId(long questionId);
}
