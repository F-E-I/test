/*
 * Copyright (c) 2014 FDZCXY Teaching Management System. All rights
 * reserved.
 * For more information, please see http://www.fdzcxy.com/
 */
package com.fdzcxy.tms.manager.exception.base;

/**
 * Òì³£×·×Ù½Ó¿Ú
 * 
 * @author zhongf
 * @date 2014-9-19
 * @version 1.0
 */
public interface Traceable {

	public String getTraceID();

	public long getTimestamp();
}
