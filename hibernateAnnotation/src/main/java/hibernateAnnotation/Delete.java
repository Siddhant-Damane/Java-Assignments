package hibernateAnnotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class Delete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		Student student = new Student();
	
		student = (Student) session.get(Student.class, 2);
		
		session.delete(student);
		
		session.getTransaction().commit();
		sessionFactory.close();

	}

}
