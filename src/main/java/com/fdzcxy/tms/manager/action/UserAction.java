/*
 * Copyright (c) 2014 FDZCXY Teaching Management System. All rights
 * reserved.
 * For more information, please see http://www.fdzcxy.com/
 */
package com.fdzcxy.tms.manager.action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.ExceptionMappings;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.fdzcxy.tms.manager.common.Const;
import com.fdzcxy.tms.manager.model.Course;
import com.fdzcxy.tms.manager.model.Menu;
import com.fdzcxy.tms.manager.model.User;
import com.fdzcxy.tms.manager.service.CourseService;
import com.fdzcxy.tms.manager.service.MenuService;
import com.fdzcxy.tms.manager.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * User Action
 * 
 * @author fzhong
 * @date 2014��7��26��
 * @version 1.0
 */
@ParentPackage("tms-default")
@Namespace("/jsp")
@Action("user")
@Results({ @Result(name = "success", location = "teacher/welcome.jsp"),
		@Result(name = "error", location = "error.jsp"),
		@Result(name = "login", location = "login.jsp"),
		@Result(name = "logout", location = "login.jsp", type = "redirect"),
		@Result(name = "sql", location = "exception.jsp") })
@ExceptionMappings({ @ExceptionMapping(exception = "java.sql.SQLException", result = "sql") })
public class UserAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private static final String LOGOUT = "logout";

	@Resource(name = "userService")
	private UserService userService;

	@Resource(name = "menuService")
	private MenuService menuService;

	@Resource(name = "courseService")
	private CourseService courseService;

	private User user;

	@Override
	public String execute() throws Exception {
		ActionContext ac = ActionContext.getContext();
		Map<String, Object> session = ac.getSession();

		List<Course> courseList = courseService.findAllCourses();
		session.put(Const.SESSION_COURSELIST, courseList);
		return SUCCESS;
	}

	public String login() throws Exception {
		if (user == null) {
			return LOGIN;
		}

		ActionContext ac = ActionContext.getContext();
		Map<String, Object> session = ac.getSession();
		session.put(Const.SESSION_USER, user);

		String errMsg = userService.checkUser(user);
		if (errMsg == null) {
			List<Menu> menuList = menuService.findMainMenus();
			session.put(Const.SESSION_MENULIST, menuList);

			List<Course> courseList = courseService.findAllCourses();
			session.put(Const.SESSION_COURSELIST, courseList);
			return SUCCESS;
		} else {
			addActionError(errMsg);
			return LOGIN;
		}
	}

	public String logout() throws Exception {
		ActionContext ac = ActionContext.getContext();
		Map<String, Object> session = ac.getSession();
		session.clear();
		return LOGOUT;
	}

	public String register() throws Exception {
		throw new SQLException("�ù����ݲ����ã�");
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
