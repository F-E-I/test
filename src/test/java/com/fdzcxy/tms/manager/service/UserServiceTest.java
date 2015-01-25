/*
 * Copyright (c) 2014 FDZCXY Teaching Management System. All rights
 * reserved.
 * 
 * For more information, please see http://www.fdzcxy.com/
 */
package com.fdzcxy.tms.manager.service;

import junit.framework.Assert;

import org.junit.Test;

import com.fdzcxy.tms.manager.BaseTest;
import com.fdzcxy.tms.manager.model.User;

/**
 * TODO Please add class comment here
 *
 * @author fzhong
 * @date 2014Äê8ÔÂ7ÈÕ
 * @version 1.0
 */
public class UserServiceTest extends BaseTest {

	@Test
	public void testUserDao() {
		User user = new User();
		user.setUserName("test");
		user.setPassword("test");
		UserService userService = (UserService) context.getBean("userService");
		Assert.assertEquals(null, userService.checkUser(user));
	}
}
