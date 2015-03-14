/*
 * Copyright (c) 2014 FDZCXY Teaching Management System. All rights
 * reserved.
 * 
 * For more information, please see http://www.fdzcxy.com/
 */
package com.fdzcxy.tms.manager.common;

/**
 * 常量
 *
 * @author fzhong
 * @date 2014年7月26日
 * @version 1.0
 */
public class Const {
	public static final String USER_NAME = "admin";
	public static final String PASSWORD = "admin";

	public static final String SESSION_USER = "user";
	public static final String SESSION_MENULIST = "menuList";
	public static final String SESSION_COURSELIST = "courseList";
	public static final String SESSION_COURSE = "course";
	public static final String SESSION_QUESTIONS = "questions";
	public static final String SESSION_ACTIVED_QUESTIONS = "activedQuestions";

	public static final int MEMU_MAIN_ID = 0;

	public static final String QUESTION_TYPE_SINGLE_SELECT = "0";
	public static final String QUESTION_TYPE_MULTIPLE_SELECT = "1";
	public static final String QUESTION_TYPE_WORD_ANSWER = "2";

	public static final String QUESTION_STATUS_CLOSED = "0";
	public static final String QUESTION_STATUS_DISCUSS = "1";
	public static final String QUESTION_STATUS_SHOW = "2";
	public static final String QUESTION_STATUS_HOMEWORK = "3";
	public static final String QUESTION_STATUS_REVIEW = "4";

	public static final int QUESTION_TIME_LIMIT_OFF = 0;
	public static final int QUESTION_TIME_LIMIT_ON = 1;

}
