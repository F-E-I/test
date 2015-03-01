/*
 * Copyright (c) 2014 FDZCXY Teaching Management System. All rights
 * reserved.
 * 
 * For more information, please see http://www.fdzcxy.com/
 */
package com.fdzcxy.tms.manager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * �γ�ģ��
 *
 * @author fzhong
 * @date 2015��2��13��
 * @version 1.0
 */
@Entity
@Table(name = "COURSE")
public class Course {

	@Id
	@Column(name = "ID")
	private int id;

	@Column(name = "COURSE_NAME")
	private String courseName;

	@Column(name = "COURSE_CODE")
	private String courseCode;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "SUBJECT")
	private String subject;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "PROFESSOR_ID")
	private int professorId;

	@Column(name = "PROFESSOR_NAME")
	private String professorName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getProfessorId() {
		return professorId;
	}

	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}

	public String getProfessorName() {
		return professorName;
	}

	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}

}
