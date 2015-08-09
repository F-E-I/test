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
 * 问题模型
 *
 * @author fzhong
 * @date 2015年3月12日
 * @version 1.0
 */
@Entity
@Table(name = "QUESTION")
public class Question {

	@Id
	@Column(name = "ID")
	private Integer id;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "DETAIL")
	private String detail;

	@Column(name = "OPTIONS")
	private String options;

	@Column(name = "ANSWER")
	private String answer;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "TYPE")
	private String type;

	@Column(name = "C_SCORE")
	private double correntScore;

	@Column(name = "P_SCORE")
	private double participationScore;

	@Column(name = "TIME")
	private int time;

	@Column(name = "TIME_LIMIT")
	private int timeLimit;

	@Column(name = "COURSE_CODE")
	private String courseCode;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getCorrentScore() {
		return correntScore;
	}

	public void setCorrentScore(double correntScore) {
		this.correntScore = correntScore;
	}

	public double getParticipationScore() {
		return participationScore;
	}

	public void setParticipationScore(double participationScore) {
		this.participationScore = participationScore;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String[] getOptionList() {
		if (this.options != null) {
			return this.options.split("#");
		}
		return null;
	}

}
