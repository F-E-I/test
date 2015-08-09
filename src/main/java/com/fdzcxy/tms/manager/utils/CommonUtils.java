/*
 * Copyright (c) 2014 FDZCXY Teaching Management System. All rights
 * reserved.
 * 
 * For more information, please see http://www.fdzcxy.com/
 */
package com.fdzcxy.tms.manager.utils;

import com.fdzcxy.tms.manager.common.Const;

/**
 * 公共工具类
 *
 * @author fzhong
 * @date 2015年3月15日
 * @version 1.0
 */
public class CommonUtils {

	public static String getStatusName(String statusId) {
		if (Const.QUESTION_STATUS_ASK.equals(statusId)) {
			return "active-visible";
		} else if (Const.QUESTION_STATUS_SHOW.equals(statusId)) {
			return "visible";
		} else if (Const.QUESTION_STATUS_HOMEWORK.equals(statusId)) {
			return "active";
		} else if (Const.QUESTION_STATUS_REVIEW.equals(statusId)) {
			return "review";
		} else if (Const.QUESTION_STATUS_CLOSED.equals(statusId)) {
			return "inactive";
		} else {
			return null;
		}
	}
}
