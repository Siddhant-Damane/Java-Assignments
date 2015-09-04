package com.webonise.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webonise.dao.QuestionDao;
import com.webonise.models.Question;

@Repository("questionDao")
public class QuestionDaoImpl implements QuestionDao {

	final static Logger logger = Logger.getLogger(QuestionDaoImpl.class);

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction transaction = null;

	@Override
	public Question findByQuestionId(long questionId) {

		session = sessionFactory.openSession();
		Question question = (Question) session.get(Question.class, questionId);
		session.close();
		return question;
	}

	@Override
	public List<Question> findByQuestion(String question) {

		session = sessionFactory.openSession();

		Criteria criteria = session.createCriteria(Question.class);
		criteria.add(Restrictions.like("question", "%" + question + "%"));
		@SuppressWarnings("unchecked")
		ArrayList<Question> questionlist = (ArrayList<Question>) criteria.list();
		logger.info("Question list  retrived is " + questionlist);		
		session.close();
		return questionlist;

	}

	@Override
	public List<Question> findAll() {

		session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		ArrayList<Question> questionlist = (ArrayList<Question>) session.createCriteria(Question.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		session.close();		
		return questionlist;
	}

	@Override
	public void saveQuestion(Question question) {

		session = sessionFactory.openSession();
		transaction = session.getTransaction();
		session.beginTransaction();
		session.save(question);
		transaction.commit();		
		session.close();
	}

	@Override
	public void delete(long questionId) {

		session = sessionFactory.openSession();
		transaction = session.getTransaction();
		session.beginTransaction();
		session.delete(session.get(Question.class, questionId));
		transaction.commit();		
		session.close();
	}
}
