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
import com.webonise.dao.AnswerDao;
import com.webonise.models.Answers;

@Repository("answerDao")
public class AnswerDaoImpl implements AnswerDao {

	final static Logger logger = Logger.getLogger(AnswerDaoImpl.class);

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction transaction = null;

	@Override
	public List<Answers> findByQuestionId(long questionId) {

		session = sessionFactory.openSession();

		Criteria criteria = session.createCriteria(Answers.class);
		criteria.add(Restrictions.like("questionid", questionId));
		@SuppressWarnings("unchecked")
		ArrayList<Answers> answerlist = (ArrayList<Answers>) criteria.list();		
		session.close();
		
		return answerlist;

	}

	@Override
	public Answers findByAnswerId(long answerId) {

		session = sessionFactory.openSession();
		Answers answers = (Answers) session.get(Answers.class, answerId);
		session.close();
		return answers;
	}

	@Override
	public void saveAnser(Answers answer) {

		session = sessionFactory.openSession();
		transaction = session.getTransaction();
		session.beginTransaction();
		session.save(answer);
		transaction.commit();
		session.close();

	}

	@Override
	public Answers findOne(long answerId) {

		session = sessionFactory.openSession();
		Answers answers = (Answers) session.get(Answers.class, answerId);
		session.close();
		return answers;
	}

	@Override
	public void delete(long answerId) {

		session = sessionFactory.openSession();
		transaction = session.getTransaction();
		session.beginTransaction();
		session.delete(session.get(Answers.class, answerId));
		transaction.commit();
		session.close();
	}

	@Override
	public void saveAndUpdate(Answers answer) {

		session = sessionFactory.openSession();
		transaction = session.getTransaction();
		session.beginTransaction();
		session.update(answer);
		transaction.commit();
		session.close();
	}
}
