package com.webonise.hibernatexml;

import java.io.Serializable;

public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7257354701666287441L;

	private int studentId;
	private String studentName;
	private float studentCgpa;

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

	public float getStudentCgpa() {
		return studentCgpa;
	}

	public void setStudentCgpa(float studentCgpa) {
		this.studentCgpa = studentCgpa;
	}

}
