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
import com.fdzcxy.tms.manager.dao.CourseDao;
import com.fdzcxy.tms.manager.model.Course;

/**
 * �γ�DAOʵ��
 *
 * @author fzhong
 * @date 2015��2��13��
 * @version 1.0
 */
@Service("courseDao")
public class CourseDaoImpl extends CommonDaoSupport implements CourseDao {

	public void addCourse(Course course) {
		this.save(course);
	}

	@SuppressWarnings("unchecked")
	public List<Course> findAll() {
		String hql = " from com.fdzcxy.tms.manager.model.Course";
		List<Course> list = this.find(hql);
		if (list.size() <= 0) {
			return null;
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public Course findById(int id) {
		String hql = " from com.fdzcxy.tms.manager.model.Course c where c.id=?";
		List<Course> list = this.find(hql, id);
		if (list.size() <= 0) {
			return null;
		}
		return list.get(0);
	}
}
