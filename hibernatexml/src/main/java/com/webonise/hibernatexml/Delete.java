package com.webonise.hibernatexml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Delete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();

		Student student = (Student) session.load(Student.class, 2);
		session.delete(student);

		session.getTransaction().commit();
		sessionFactory.close();
	}

}
