/*
 * Copyright (c) 2014 FDZCXY Teaching Management System. All rights
 * reserved.
 * 
 * For more information, please see http://www.fdzcxy.com/
 */
package com.fdzcxy.tms.manager.dao;

import java.util.List;

import com.fdzcxy.tms.manager.model.Question;

/**
 * 问题DAO
 *
 * @author fzhong
 * @date 2015年3月12日
 * @version 1.0
 */
public interface QuestionDao {

	public void addQuestion(Question question);

	public List<Question> findAll();

	public List<Question> findByStatus(String status);

	public List<Question> findByCourseCode(String courseCode);

	public List<Question> findByCourseCodeAndStatus(String courseCode,
			String status);

}
