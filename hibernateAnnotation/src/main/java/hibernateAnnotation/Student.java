package hibernateAnnotation;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenerationTime;

@Entity
@Table(name="Student")
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1789665102138513150L;

	@Id	
	@Column(name="STUDENT_ID")
	private int studentId;
	
	@Column(name="NAME")
	private String studentName;
	
	@Column(name="CGPA")
	private double cgpa;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
	private Set<Teacher> teachers = new HashSet<Teacher>();

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public double getCgpa() {
		return cgpa;
	}

	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}

	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}
	
}
