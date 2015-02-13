/*
 * Copyright (c) 2014 FDZCXY Teaching Management System. All rights
 * reserved.
 * 
 * For more information, please see http://www.fdzcxy.com/
 */
package com.fdzcxy.tms.manager.service;

import java.util.List;

import com.fdzcxy.tms.manager.model.Course;

/**
 * Interface of Course Service
 *
 * @author fzhong
 * @date 2015��2��13��
 * @version 1.0
 */
public interface CourseService {

	public void addCourse(Course course);

	public List<Course> findAllCourses();
}
