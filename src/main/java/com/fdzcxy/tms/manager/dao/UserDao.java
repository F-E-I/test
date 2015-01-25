/*
 * Copyright (c) 2014 FDZCXY Teaching Management System. All rights
 * reserved.
 * For more information, please see http://www.fdzcxy.com/
 */
package com.fdzcxy.tms.manager.dao;

import com.fdzcxy.tms.manager.model.User;

/**
 * 用户Dao接口
 * 
 * @author fzhong
 * @date 2014年8月1日
 * @version 1.0
 */
public interface UserDao {

	public void addUser(User user);

	public User findByUserName(String userName) throws Exception;
}
