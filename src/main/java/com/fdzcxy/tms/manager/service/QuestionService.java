/*
 * Copyright (c) 2014 FDZCXY Teaching Management System. All rights
 * reserved.
 * 
 * For more information, please see http://www.fdzcxy.com/
 */
package com.fdzcxy.tms.manager.service;

import java.util.List;

import com.fdzcxy.tms.manager.model.Question;

/**
 * �������ӿ�
 *
 * @author fzhong
 * @date 2015��3��12��
 * @version 1.0
 */
public interface QuestionService {

	public void addQuestion(Question question);

	public List<Question> findAllQuestions();

	public List<Question> findByStatus(String status);

	public List<Question> findByCourseCode(String courseCode);

	public List<Question> findByCourseCodeAndStatus(String courseCode,
			String status);

	public Question findById(int id);

	public void update(Question question);

	public void saveOrUpdate(Question question);

}
