package com.webonise.hibernatexml;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Update {
	final static Logger logger = Logger.getLogger(Update.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		
		Student student = (Student) session.load(Student.class, 51);
		student.setStudentName("abc");
		
		session.getTransaction().commit();
		sessionFactory.close();

		
		logger.info("INFO:  name " + student.getStudentName() );
	}

}
