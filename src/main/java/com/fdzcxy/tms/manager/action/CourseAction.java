/*
 * Copyright (c) 2014 FDZCXY Teaching Management System. All rights
 * reserved.
 * 
 * For more information, please see http://www.fdzcxy.com/
 */
package com.fdzcxy.tms.manager.action;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.fdzcxy.tms.manager.model.Course;
import com.fdzcxy.tms.manager.service.CourseService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Course Action
 *
 * @author fzhong
 * @date 2015��2��13��
 * @version 1.0
 */
@ParentPackage("tms-default")
@Namespace("/jsp")
@Action("course")
@Results({ @Result(name = "json", type = "json"),
		@Result(name = "index", location = "user", type = "redirect") })
public class CourseAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private static final String INDEX = "index";

	private Course course;

	@Resource(name = "courseService")
	private CourseService courseService;

	public String add() throws Exception {
		if (course == null) {
			throw new Exception("�γ̶���Ϊ��");
		}
		if (StringUtils.isEmpty(course.getCourseName())) {
			throw new Exception("�γ����Ʋ���Ϊ��");
		}

		courseService.addCourse(course);
		return INDEX;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
}
