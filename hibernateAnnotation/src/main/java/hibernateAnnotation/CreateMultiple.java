package hibernateAnnotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class CreateMultiple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sessionFactory = new AnnotationConfiguration().configure().addAnnotatedClass(Student.class)
				.addAnnotatedClass(Teacher.class).buildSessionFactory();

		Session session = sessionFactory.openSession();

		session.beginTransaction();

		Student student = new Student();
		student = (Student) session.get(Student.class, 50);
		Teacher teacher = new Teacher();
		teacher.setTeacherId(10);
		teacher.setTeacherName("siddhant");
		teacher.setSubject("Fun");
		teacher.setStudent(student);

		// session.getTransaction().commit();

		student.getTeachers().add(teacher);
		session.save(teacher);

		session.getTransaction().commit();
		// sessionFactory.close();

		sessionFactory.close();

	}

}
