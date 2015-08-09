/*
 * Copyright (c) 2014 FDZCXY Teaching Management System. All rights
 * reserved.
 * 
 * For more information, please see http://www.fdzcxy.com/
 */
package com.fdzcxy.tms.manager.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fdzcxy.tms.manager.common.CommonDaoSupport;
import com.fdzcxy.tms.manager.dao.QuestionDao;
import com.fdzcxy.tms.manager.model.Question;

/**
 * 问题DAO实现
 *
 * @author fzhong
 * @date 2015年3月12日
 * @version 1.0
 */
@Service("questionDao")
public class QuestionDaoImpl extends CommonDaoSupport implements QuestionDao {

	public void addQuestion(Question question) {
		this.save(question);
	}

	public void updateQuestion(Question question) {
		this.update(question);
	}

	public void saveOrUpdateQuestion(Question question) {
		this.saveOrUpdate(question);
	}

	@SuppressWarnings("unchecked")
	public List<Question> findAll() {
		String hql = " from com.fdzcxy.tms.manager.model.Question";
		List<Question> list = this.find(hql);
		if (list.size() <= 0) {
			return null;
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Question> findByStatus(String status) {
		String hql = " from com.fdzcxy.tms.manager.model.Question q where q.status=?";
		List<Question> list = this.find(hql, status);
		if (list.size() <= 0) {
			return null;
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Question> findByCourseCode(String courseCode) {
		String hql = " from com.fdzcxy.tms.manager.model.Question q where q.courseCode=?";
		List<Question> list = this.find(hql, courseCode);
		if (list.size() <= 0) {
			return null;
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Question> findByCourseCodeAndStatus(String courseCode,
			String status) {
		String hql = " from com.fdzcxy.tms.manager.model.Question q where q.courseCode=? and q.status=?";
		List<Question> list = this.find(hql, courseCode, status);
		if (list.size() <= 0) {
			return null;
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public Question findById(int id) {
		String hql = " from com.fdzcxy.tms.manager.model.Question q where q.id=?";
		List<Question> list = this.find(hql, id);
		if (list.size() <= 0) {
			return null;
		}
		return list.get(0);
	}

	public void deleteQuestionById(int id) {
		this.executeQuery(
				"delete from com.fdzcxy.tms.manager.model.Question q where q.id=?",
				id);
	}
}
