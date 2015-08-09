/*
 * Copyright (c) 2014 FDZCXY Teaching Management System. All rights
 * reserved.
 * 
 * For more information, please see http://www.fdzcxy.com/
 */
package com.fdzcxy.tms.manager.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fdzcxy.tms.manager.dao.QuestionDao;
import com.fdzcxy.tms.manager.model.Question;
import com.fdzcxy.tms.manager.service.QuestionService;

/**
 * 问题服务实现
 *
 * @author fzhong
 * @date 2015年3月12日
 * @version 1.0
 */
@Service("questionService")
public class QuestionServiceImpl implements QuestionService {

	@Resource(name = "questionDao")
	private QuestionDao questionDao;

	public void addQuestion(Question question) {
		questionDao.addQuestion(question);
	}

	public List<Question> findAllQuestions() {
		return questionDao.findAll();
	}

	public List<Question> findByStatus(String status) {
		return questionDao.findByStatus(status);
	}

	public List<Question> findByCourseCode(String courseCode) {
		return questionDao.findByCourseCode(courseCode);
	}

	public List<Question> findByCourseCodeAndStatus(String courseCode,
			String status) {
		return questionDao.findByCourseCodeAndStatus(courseCode, status);
	}

	public Question findById(int id) {
		return questionDao.findById(id);
	}

	public void update(Question question) {
		questionDao.updateQuestion(question);
	}

	public void saveOrUpdate(Question question) {
		questionDao.saveOrUpdateQuestion(question);
	}

	public void deleteQuestionById(int id) {
		questionDao.deleteQuestionById(id);
	}
}
