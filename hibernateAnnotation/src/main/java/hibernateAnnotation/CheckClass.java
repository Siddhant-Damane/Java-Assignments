package hibernateAnnotation;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class CheckClass {

	final static Logger logger = Logger.getLogger(CheckClass.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sessionFactory = new AnnotationConfiguration().configure().addAnnotatedClass(Student.class)
				.addAnnotatedClass(Teacher.class).buildSessionFactory();

		Session session = sessionFactory.openSession();

		session.beginTransaction();

		Student student = new Student();
		student = (Student) session.get(Student.class, 51);
		logger.info("Student " + student.getStudentName() + " has total  :: " + student.getTeachers().size()
				+ " teachers and their names are :: ");
		
		for (Teacher s : student.getTeachers()) {
		 logger.info(s.getTeacherName());
		}

		Teacher teacher = new Teacher();
		teacher = (Teacher) session.get(Teacher.class, 12);

		logger.info("Teacher :: " + teacher.getTeacherName() + " has student :: "
				+ teacher.getStudent().getStudentName());

		sessionFactory.close();
	}

}
