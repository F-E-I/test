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

import com.fdzcxy.tms.manager.dao.CourseDao;
import com.fdzcxy.tms.manager.model.Course;
import com.fdzcxy.tms.manager.service.CourseService;

/**
 * 课程服务实现
 *
 * @author fzhong
 * @date 2015年2月13日
 * @version 1.0
 */
@Service("courseService")
public class CourseServiceImpl implements CourseService {

	@Resource(name = "courseDao")
	private CourseDao courseDao;

	public void addCourse(Course course) {
		courseDao.addCourse(course);
	}

	public List<Course> findAllCourses() {
		return courseDao.findAll();
	}

	public Course findById(int id) {
		return courseDao.findById(id);
	}
}
