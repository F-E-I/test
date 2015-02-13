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
 * 课程DAO实现
 *
 * @author fzhong
 * @date 2015年2月13日
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
}
