package com.webonise.hibernatexml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Create {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		Student student = new Student();

		//student.setStudent_id(2);
		student.setStudentName("Damane");
		student.setStudentCgpa(7);
		session.save(student);
		session.getTransaction().commit();

		sessionFactory.close();

	

	}

}
