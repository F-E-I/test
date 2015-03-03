/*
 * Copyright (c) 2014 FDZCXY Teaching Management System. All rights
 * reserved.
 * 
 * For more information, please see http://www.fdzcxy.com/
 */
package com.fdzcxy.tms.manager.action;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.fdzcxy.tms.manager.common.Const;
import com.fdzcxy.tms.manager.model.Course;
import com.fdzcxy.tms.manager.model.User;
import com.fdzcxy.tms.manager.service.CourseService;
import com.opensymphony.xwork2.ActionContext;
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
		@Result(name = "index", location = "user", type = "redirect"),
		@Result(name = "courseIndex", location = "teacher/course.jsp") })
public class CourseAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private static final String INDEX = "index";
	private static final String COURSE_INDEX = "courseIndex";

	private Course course;
	private String courseId;

	@Resource(name = "courseService")
	private CourseService courseService;

	@Override
	public String execute() throws Exception {
		ActionContext ac = ActionContext.getContext();
		Map<String, Object> session = ac.getSession();

		Course course = courseService.findById(Integer.valueOf(courseId));
		session.put(Const.SESSION_COURSE, course);
		return COURSE_INDEX;
	}

	public String add() throws Exception {
		if (course == null) {
			throw new Exception("�γ̶���Ϊ��");
		}
		if (StringUtils.isEmpty(course.getCourseName())) {
			throw new Exception("�γ����Ʋ���Ϊ��");
		}

		ActionContext ac = ActionContext.getContext();
		Map<String, Object> session = ac.getSession();
		User user = (User) session.get(Const.SESSION_USER);
		course.setProfessorId(user.getId());
		course.setProfessorName(user.getUserName());

		courseService.addCourse(course);
		return INDEX;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
}
