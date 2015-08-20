package com.webonise.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.webonise.models.Answers;

@Repository
public interface AnswerDao extends JpaRepository<Answers, Long>, ForumDao {

	List<Answers> findByQuestionId(long questionId);
}
