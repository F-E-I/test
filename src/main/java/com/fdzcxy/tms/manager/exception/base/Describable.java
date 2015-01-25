/*
 * Copyright (c) 2014 FDZCXY Teaching Management System. All rights
 * reserved.
 * For more information, please see http://www.fdzcxy.com/
 */
package com.fdzcxy.tms.manager.exception.base;

/**
 * 异常描述接口
 * 
 * @author zhongf
 * @date 2014-9-19
 * @version 1.0
 */
public interface Describable {

	/**
	 * 获取错误码
	 * 
	 * @return
	 */
	public String getCode();
}
