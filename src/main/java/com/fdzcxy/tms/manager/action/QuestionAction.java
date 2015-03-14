/*
 * Copyright (c) 2014 FDZCXY Teaching Management System. All rights
 * reserved.
 * 
 * For more information, please see http://www.fdzcxy.com/
 */
package com.fdzcxy.tms.manager.action;

import java.util.ArrayList;
import java.util.List;
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
import com.fdzcxy.tms.manager.model.Question;
import com.fdzcxy.tms.manager.service.QuestionService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Question Action
 *
 * @author fzhong
 * @date 2015年3月8日
 * @version 1.0
 */
@ParentPackage("tms-default")
@Namespace("/jsp")
@Action("question")
@Results({ @Result(name = "json", type = "json"),
		@Result(name = "courseIndex", location = "course", type = "redirect"),
		@Result(name = "singleSelect", location = "question/singleSelect.jsp") })
public class QuestionAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private static final String COURSE_INDEX = "courseIndex";
	private static final String JSON = "json";

	private String type;

	private Question question;

	private List<String> options = new ArrayList<String>(10);

	private String[] correctOptions;

	private boolean createAndActive;

	@Resource(name = "questionService")
	private QuestionService questionService;

	@Override
	public String execute() throws Exception {
		if (Const.QUESTION_TYPE_SINGLE_SELECT.equals(type)) {
			return "singleSelect";
		} else if (Const.QUESTION_TYPE_MULTIPLE_SELECT.equals(type)) {
			return "multipleSelect";
		} else if (Const.QUESTION_TYPE_WORD_ANSWER.equals(type)) {
			return "wordAnswer";
		}
		return null;
	}

	public String add() throws Exception {
		if (question == null) {
			throw new Exception("问题对象为空");
		}
		if (StringUtils.isEmpty(question.getTitle())
				|| StringUtils.isEmpty(question.getDetail())
				|| StringUtils.isEmpty(question.getType())) {
			throw new Exception("必输要素为空");
		}

		ActionContext ac = ActionContext.getContext();
		Map<String, Object> session = ac.getSession();

		Course course = (Course) session.get(Const.SESSION_COURSE);
		question.setCourseCode(course.getCourseCode());
		// 设置状态
		if (createAndActive) {
			question.setStatus(Const.QUESTION_STATUS_SHOW);
		} else {
			question.setStatus(Const.QUESTION_STATUS_CLOSED);
		}
		// 设置选项
		if (options != null) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < options.size() - 1; i++) {
				sb.append(options.get(i)).append("#");
			}
			sb.append(options.get(options.size() - 1));
			question.setOptions(sb.toString());
		}
		// 设置正确答案
		if (correctOptions != null) {
			StringBuffer sb = new StringBuffer();
			for (String str : correctOptions) {
				sb.append(str);
			}
			question.setAnswer(sb.toString());
		}

		questionService.addQuestion(question);
		return COURSE_INDEX;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public List<String> getOptions() {
		return options;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}

	public String[] getCorrectOptions() {
		return correctOptions;
	}

	public void setCorrectOptions(String[] correctOptions) {
		this.correctOptions = correctOptions;
	}

	public boolean isCreateAndActive() {
		return createAndActive;
	}

	public void setCreateAndActive(boolean createAndActive) {
		this.createAndActive = createAndActive;
	}

}
