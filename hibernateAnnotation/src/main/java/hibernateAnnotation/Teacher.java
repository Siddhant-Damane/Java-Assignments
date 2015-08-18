package hibernateAnnotation;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenerationTime;

@Entity
@Table(name = "Teacher")
public class Teacher implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1789665102138513150L;

	@Id
	@GeneratedValue
	@Column(name = "TEACHER_ID")
	private int teacherId;

	@Column(name = "NAME")
	private String teacherName;

	@Column(name = "Subject")
	private String subject;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STUDENT_ID")
	private Student student;

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}
