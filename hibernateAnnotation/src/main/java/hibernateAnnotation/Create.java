package hibernateAnnotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class Create {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		Student student = new Student();
		//student.setStudent_id(23);
		student.setStudentName("sid");
		student.setCgpa(7.3);
		
		session.save(student);
		session.getTransaction().commit();
		sessionFactory.close();

	}

}
