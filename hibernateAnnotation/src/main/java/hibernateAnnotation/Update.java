package hibernateAnnotation;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class Update {

	final static Logger logger = Logger.getLogger(Update.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		Student student = new Student();
	
		student = (Student) session.get(Student.class, 2);
		student.setStudentName("Updated");
	
		
		session.getTransaction().commit();
		sessionFactory.close();
		
		logger.info("INFO: updated name" + student.getStudentName() );

	}

}
